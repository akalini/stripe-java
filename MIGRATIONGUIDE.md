# Migration guide for version 8

## Required upgrade to latest Stripe API version
 Up until `stripe-java` version 7, we maintained model classes in a backward-compatible
 way. Regardless of your Stripe API version (in dashboard settings), you could always use the 
 latest version of this client library. In this major version 8, and moving forward, the library 
 only supports model classes of latest Stripe API version. To use this new version safely, it 
 requires your Stripe API version upgrade to the latest one.
 
 Under the hood, this new version 8 sets `Stripe-Version` request header to `Stripe#API_VERSION` 
 statically-defined in the library. Making API requests alone is fine; the return JSON response 
 has schema according to the specified version, and it is compatible with Java model 
 classes of the library. However, event integration without upgrading your API version, can 
 result in unhandled failures, both for webhooks and `/v1/events/*` via `Event#retrieve`.
 
 The event data object in `Event#data#object` is JSON rendered according to your Stripe API 
 version at the time of its creation. Without upgrading your API version, using this 
 library pinned at a specific version has no implication on the JSON schema of the data 
 object; setting version in the header to retrieve events will only render the outer wrapper and 
 metadata as the specified version, but not the inner data object. Similarly, the data object in 
 webhook events are also rendered at your Stripe API version. Thus, simply deserializing this data 
 object at old API version to the model of latest schema in this library can cause incomplete 
 deserialized object or runtime exceptions. Therefore, it is necessary that you upgrade to the 
 latest API version to ensure events are created with the same API version supported by this library. 
 
## API version upgrade with `stripe-java`

According to the official [recommendations](https://stripe.com/docs/upgrades#how-can-i-upgrade-my-api)
 for Stripe API version upgrade, there are two main impact:
 1) Request and response for normal API calls 
 2) Event response structure

### 1. Request and response for API calls

API calls, as discussed here, will refer to the associated methods on model classes that make
HTTP requests, specifically excluding methods on `Event.java` to be discussed together with 
webhook events in the following section.

You can test a new version for the API calls by adding dependency of `stripe-java` version `8.x` 
and above. This will set `Stripe-Version` in request header to the latest API version, simulating 
making API calls as if you have upgraded.   
 
#### API response  
 
As any new `stripe-java` major versions, changes in schema of API responses 
are reflected explicitly in typed Java classes. With the help of compiler failing loudly, you can
 readily fix and update your getter methods. In this version 8, fields or its corresponding getter 
 methods previously marked with `@Deprecated` are removed, and other field changes are documented in the 
 change log section below.
 
However, because this client library does not provide explicit enum for certain fields, your 
integration relying on string equality of will not be caught by the compiler. If the enum value 
is removed or replaced with a different name, your code execution flow can get affected. 
Furthermore, the upgrade can change semantics of certain enums, and you should verify the 
implications on using the same enum values. For example, in [version change](https://stripe.com/docs/upgrades#2017-06-05),
`under_review` now takes the meaning previously overloaded in `other` value for 
`Account#Verification#getDisabledReason`; if you use `other` to determine if the disabled account is
 under review, you should check for value `under_review` instead.
 
```
Account account = Account.retrieve();
// need to change "other" to "under_review" instead
if (account.getVerification().disabledReason.equals("other")) {
  // code path assuming account is still under review
}
```

Similar to enum is the value of `object` field in most of model classes. In [version 
change](https://stripe.com/docs/upgrades#2018-09-24) the value for `File` is changed from 
`file_upload` to `file`. Explicit check for `File#getObject` should be updated accordingly.

Beyond the contract that fully-typed system can offer is the change in business implication, 
where the schema remains the same. This is less common, but does happen. For example in [version 
change](https://stripe.com/docs/upgrades#2018-05-21), an `id` of a subscription in line item lost 
its meaning as the subscription ID.  
 
#### API requests 
 
On the API requests, because this client library takes an untyped map as a parameter request to an 
API method, eg. `Source create(Map<String, Object> params)`, removed parameters due to API 
upgrade will not be caught statically. For example, before [version change](https://stripe.com/docs/upgrades#2018-08-23)
`Subscription#cancel` allows deferred cancellation with `at_period_end` request parameter, but 
now removed in favor of `Subscription#update` with `cancel_at_period_end` parameter. Similarly, 
there is extensive change in parameters for `PaymentIntent#create` and `PaymentIntent#confirm` 
for beta users of `PaymentIntent` in [version change](https://stripe.com/docs/upgrades#2018-11-08)

Parameter validation is another common change. For example, 
 [version change](https://stripe.com/docs/upgrades#2018-10-31) requires `Customer#update` 
 parameter `name` to be within 250 character-long. On the other hand, parameter validation can 
 also become less restrictive, and the assumption you had on the valid returned response can be 
 violated. For example, if you had relied on Stripe validation on uniqueness of SKU `attributes` during 
 creation/update, and had built business logic around this assumption, after [version change](https://stripe.com/docs/upgrades#2018-09-06)
  the validation is removed and SKUs returned can have duplicate attributes. Your code 
  depending on SKU attribute uniqueness has to be updated. 
  
Parameter can also take a new default value. Your old code may not explicitly pass the parameter 
value, but after version upgrade when default value kicks in, your same API call now has a 
different business implication. For example, in [version change](https://stripe.com/docs/upgrades#2018-05-21), 
`Subscription#update` will take `trial_from_plan` as true if it is not explicitly specified.

#### API errors

Less obvious ones are changes related to JSON error object which is not directly exposed to you. 
This library converts such failure into `StripeException` a subclass of Java `Exception`. For 
example, in [version change](https://stripe.com/docs/upgrades#2017-12-14) `card_error` is 
introduced, but that will be surfaced to you simply as a different message in `ApiException`. No 
change on your part is required.

Change in HTTP error codes, however, can affect your integration as a different type of 
`StripeException` thrown. For example, in [version change](https://stripe.com/docs/upgrades#2016-10-19),
 insufficient permission will return code 403 instead of 401. This means your code checking for 
 `AuthenticationException` may require updates to `PermissionException` instead. Similarly, 429 is 
 introduced after [version change](https://stripe.com/docs/upgrades#2015-09-08) instead of 400. 
 As a result, any code handling rate-limit should be updated to check for `RateLimitException`.

#### Summary
 
Please consult the API change log for more details. A complementary recommendation for 
`stripe-java` is to pay close attention for the followings;

* API response (beyond compiler complaints)
  - enum values represented as String, 
  - `object` field values renaming
  - change in business meaning of the field
* API request
  - parameter removal
  - parameter validation and effect on resulting API response
  - parameter default value
* API error
  - HTTP error code and its corresponding `StripeException`
  
### 2. Event response structure

The official upgrade [guide](https://stripe.com/docs/upgrades#how-can-i-upgrade-my-api) 
recommends  configuring one test webhook to the latest API version. This allows you to test 
handling event and its event data object rendered at the upgraded API version. In the latest 
`stripe-java`, you will find an API version defined at its static value 
`Stripe#API_VERSION` matching the latest API version you can configure your test webhook to.
 
#### Motivation for handling event compatibility
 
The official guide also recommends the need for compatibility in handling events of both your 
current and new API versions. This is because for a short period of time after you upgrade, there will be 
in-flight events of old API version that you should still handle. Additionally, in the case of API 
version roll-back, you want to smoothly revert by simply reconfigure the dashboard setting 
without the need to re-deploy your code.

Actually, backward compatibility to read old events is needed in general for 
API request to read events going back to 30 days in `Event#retrieve`. 
One approach is having Java model classes that can deserialize events of both versions. 
This is what `stripe-java` version 7 and below attempts to do. In additiona, when there is data 
type conflict (same field name but JSON has unexpected data type), custom deserialization and 
augmented fields are introduced. Version 8, however, will take a different approach. 

#### Illustration of schema incompatibility failure

Currently, getting an `Event` will fail if JSON schema for data object at `event.data.object` is 
not compatible with Java model class for its corresponding object type at `event.data.object.object`. 
Consider the JSON data below (fields omitted for illustration). It has 
`event.data.object.object` as `invoice` so `Event#data#object` will be deserialized to 
`Invoice.java`. Note the `api_version` before [`2012-10-26`](https://stripe.com/docs/upgrades#2012-10-26) 
where the `lines` has become a common paginated collection structure with fields `has_more`, 
`data`, and `total_count`. Suppose the original `lines` schema is simply an array of invoice items.
 Such data type mismatch cannot be deserialized into recent Java model class, and
 `Event.retrieve("evt_123")` will simply fail.
```
{
  "id": "evt_123",
  "object": "event",
  "api_version": "2012-09-24",
  "created": 1549056424,
  "data": {
    "object": { // event data object of rendered at `api_version`
      "id": "in_1DwEmi2eZvKYlo2C5EbZEeaM",
      "object": "invoice", // tells deseiralizer this object should be `Invoice`
      "amount_due": 999,
      "amount_paid": 0,
      "lines": [ // not the paginated collection object as in recent API versions
        {
          "id": "sli_fde81ddce855c9",
          "object": "line_item",
          "amount": 999,
          "type": "subscription"
        }
      ],
      "status": "draft"
    }
  },
  "livemode": false,
  "pending_webhooks": 0,
  "request": {
    "id": null,
    "idempotency_key": null
  },
  "type": "invoice.updated"
}
```

#### Proxy object for deserialization in version 8
`stripe-java` version 8 now supporting model classes of only the latest API version--and not 
backward-compatible--provides a new abstraction to resolve the old event data incompatibility 
problem. We add a proxy object `EventDataObjectDeserializer` in `Event#data#getDataObjectDeserializer`. 
The general approach is to defer data object deserialization to your use-case. This avoids always 
deserializing into model class, risking failure on incompatible schema. The interface makes 
explicit whether deserializiation to full model is safe, possible but giving 
lossy results, or failing with a checked exception. In addition, it provides a recovery 
method to handle incompatible JSON when necessary. This proxy object is introduced in favor of the 
now deprecated method `EventData#getObject`.

```
Event event = Event.retrieve("evt_123");
// deprecated method
EventData eventData = event.getData();
try {
  event.getData().getObject();
} catch (JsonParseException e) {
  // run-time exception on schema incompatible JSON
}
// instead use this proxy object
EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
```

#### Best-attempt field getter method

In practice, you may only use on a few fields from the event. When those fields are fully 
compatible with the current schema, you should be able to access thm, not because of a 
few legacy fields are failing the entire deserialization. The snippet below illustrates the 
first use case of best-attempt field getter. Suppose you want to get an invoice ID and status 
values only:
```
String invoiceId = null;
String status = null;
if (dataObjectDeserializer.deserialize()) {
  Invoice invoice = (Invoice) dataObjectDeserializer.getObject();
  invoiceId = invoice.getId();
  status = invoice.getStatus();
} else {
  try {
    Invoice invoice = (Invoice) dataObjectDeserializer.deserializeUnsafe();
    invoiceId = invoice.getId();
    status = invoice.getStatus();
  } catch (EventDataObjectDeserializationException e) {
    JsonElement parsed = new JsonParser().parse(e.getRawJson());
    invoiceId = parsed.getAsJsonObject().get("id").getAsString();
    status = parsed.getAsJsonObject().get("status").getAsString();
  }
}
```

The first control flow check `dataObjectDeserializer.deserialize()` determines whether it is safe 
for deserialization based on whether `Event#apiVersion` matches that of the library 
`Stripe#API_VERSION`. If so, you can use `getObject()` to get full Stripe object 
`Invoice` here. Otherwise, `getObject()` simply returns null.

However, if there's API version mismatch, but the schema is still compatible, you can use 
`deserializeUnsafe()` to still get the Stripe object. It is unsafe because there is no guarantee 
on data completeness; when JSON field of old schema is not represented in the new Java model class, 
the field is simply lost. This is problematic when API upgrade specifies field transformation, 
like rename or mapping from one value to the other. The `EventDataObjectDeserializer` has no 
knowledge of such transformation, so the deserialized Stripe object can be lossy via this 
explicit unsafe method.

Lastly, if the deserialization fails due to schema incompatibility, you can still access the raw 
JSON of the data object and access the relevant fields. Note that the unsafe deserialization 
throws checked exception `EventDataObjectDeserializationException`, and raw JSON is accessible in
 the exception. 

#### JSON compatibility transformation

The other use-case is when you actually need a Stripe model as a result of event deserialization.  
`deserializeUnsafeWith(CompatibilityTransformer)` provides a mechanism to transform the JSON to 
be compatible with the latest Java model class. Through `CompatibilityTransformer`, you can 
define which type of event and for which version should the transformations be applied to.

In the example below, we want to handle the same JSON invoice event created when we were on Stripe 
API version before `2012-10-26`. We define a `invoiceTransformer` as series of transformation 
required on invoice object starting from the earliest API version (that the event was created at). 

```
EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
EventDataObjectDeserializer.CompatibilityTransformer invoiceTransformer =
    new com.stripe.model.EventDataObjectDeserializer.CompatibilityTransformer() {
      @Override
      public JsonObject transform(JsonObject rawJsonObject, String apiVersion,
                                  String eventType) {
        // Attempt to be forward compatible only for invoice events
        if (!eventType.startsWith("invoice.")) {
          return rawJsonObject;
        }
        
        // update guide on Invoice: https://stripe.com/docs/upgrades#2012-10-26
        // `lines` for line items are in the form of paginated collection
        // supposed the old schema for `lines` is a JSON array
        if (versionToDate(apiVersion).before(versionToDate("2012-10-26"))) {
          JsonArray lines = rawJsonObject.get("lines").getAsJsonArray();
          JsonObject paginatedLines = new JsonObject();
          paginatedLines.add("data", lines);
          paginatedLines.add("has_more", new JsonPrimitive(false));
          paginatedLines.add("total_count", new JsonPrimitive(lines.size()));
          rawJsonObject.add("lines", paginatedLines);
        }
        
        // update guide on Invoice: https://stripe.com/docs/upgrades#2017-12-14
        // invoice item description is always set, if you downstream application
        // code expects non-null description, consider adding default values
        if (versionToDate(apiVersion).before(versionToDate("2017-12-14"))) {
          // add you default values to the line item
        }
        
        // update guide on Invoice: https://stripe.com/docs/upgrades#2018-05-21
        // change in semantics of `id` for invoice line items, but schema remains the same
    
        // update guide on Invoice: https://stripe.com/docs/upgrades#2018-10-31
        // billing_reason taking a new enum, but the old enum is still valid, so no change.

        // following update guide on Invoice: https://stripe.com/docs/upgrades#2018-11-08
        if (versionToDate(apiVersion).before(versionToDate("2018-11-08"))) {
          // From change log, `closed` is deprecated in favor of `auto_advance`
          // when `closed` is true, `auto_advance` is false.
          boolean closedValue = rawJsonObject.get("closed").getAsBoolean();
          rawJsonObject.add("auto_advance", new JsonPrimitive(!closedValue));

          // From change log, `forgiven` is deprecated in favor of `uncollectible` status.
          if (rawJsonObject.get("forgiven").getAsBoolean()) {
            rawJsonObject.add("status", new JsonPrimitive("uncollectible"));
          }
        }
        return rawJsonObject;
      }
    };
StripeObject deserialized = dataObjectDeserializer.deserializeUnsafeWith(invoiceTransformer);
Invoice invoice = (Invoice) deserialized;
```
Because `eventType` is namespaced, we can filter out the class of object to handle. The 
`apiVersion` helps to distinguish events that are eligible for certain transformations. 
Specifically, invoice event with its API version before these dates needs the following 
transformation in order:
* `2012-10-26` - converts two nested list into the paginated object structure
* `2017-12-14` - sets default description to the now always-present field in invoice item
* `2018-11-08` - maps value of deprecated fields to a newly introduced one

The transformation ensures that schema is compatible and avoids deserialization failure. It 
also allows us to custom specify default values for fields that are now non-optional, and does 
 value-mapping to preserve the semantics of the deserailized object. Using 
 `deserializeUnsafeWith` with a specified transformer, we can recover model objects, from old 
 event versions, to be more consistent with objects from the later versions.
   
#### Deprecating event old version handling

After 72 hours when you have successfully upgraded the API version. Any pending old webhook 
events would have been delivered and handled in application code. After 30 days, events 
guaranteed to be available will all have been created with the upgraded API version. At this 
time, you can safely deprecate the backward compatibility event handling logic; model classes 
from API calls, and in event data object via webhook or event endpoints will be of the new API 
version.

## Change log for breaking contracts

We enumerate backward-breaking changes, that are not previously marked with @Deprecated according
 to normal conventions, with their motivations/resolutions.
* [Class changes](https://git.corp.stripe.com/stripe-internal/sdk-autogen-java/blob/master/generated/diff_change_log_class_names.md)
* [Method changes](https://git.corp.stripe.com/stripe-internal/sdk-autogen-java/blob/master/generated/diff_change_log_methods.md)
* [Field changes](https://git.corp.stripe.com/stripe-internal/sdk-autogen-java/blob/master/generated/diff_change_log_fields.md)