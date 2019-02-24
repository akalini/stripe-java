// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.model.issuing;

import com.google.gson.annotations.SerializedName;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Address;
import com.stripe.model.HasId;
import com.stripe.model.MetadataStore;
import com.stripe.model.StripeObject;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import com.stripe.param.issuing.CardCreateParams;
import com.stripe.param.issuing.CardDetailsParams;
import com.stripe.param.issuing.CardListParams;
import com.stripe.param.issuing.CardRetrieveParams;
import com.stripe.param.issuing.CardUpdateParams;
import java.util.List;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Card extends ApiResource implements HasId, MetadataStore<Card> {
  @SerializedName("authorization_controls")
  AuthorizationControls authorizationControls;

  /** The brand of the card. */
  @SerializedName("brand")
  String brand;

  /** The [Cardholder](/docs/api#issuing_cardholder_object) object to which the card belongs. */
  @SerializedName("cardholder")
  Cardholder cardholder;

  /** Time at which the object was created. Measured in seconds since the Unix epoch. */
  @SerializedName("created")
  Long created;

  /**
   * Three-letter [ISO currency code](https://www.iso.org/iso-4217-currency-codes.html), in
   * lowercase. Must be a [supported currency](https://stripe.com/docs/currencies).
   */
  @SerializedName("currency")
  String currency;

  /** The expiration month of the card. */
  @SerializedName("exp_month")
  Long expMonth;

  /** The expiration year of the card. */
  @SerializedName("exp_year")
  Long expYear;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  @SerializedName("id")
  String id;

  /** The last 4 digits of the card number. */
  @SerializedName("last4")
  String last4;

  /**
   * Has the value `true` if the object exists in live mode or the value `false` if the object
   * exists in test mode.
   */
  @SerializedName("livemode")
  Boolean livemode;

  /**
   * Set of key-value pairs that you can attach to an object. This can be useful for storing
   * additional information about the object in a structured format.
   */
  @Getter(onMethod = @__({@Override}))
  @SerializedName("metadata")
  Map<String, String> metadata;

  /** The name of the cardholder, printed on the card. */
  @SerializedName("name")
  String name;

  /** String representing the object's type. Objects of the same type share the same value. */
  @SerializedName("object")
  String object;

  /** Where and how the card will be shipped. */
  @SerializedName("shipping")
  Shipping shipping;

  /** One of `active`, `inactive`, `canceled`, `lost`, `stolen`, or `pending`. */
  @SerializedName("status")
  String status;

  /** One of `virtual` or `physical`. */
  @SerializedName("type")
  String type;

  /**
   * Returns a list of Issuing <code>Card</code> objects. The objects are sorted in descending order
   * by creation date, with the most recently created object appearing first.
   */
  public static CardCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /**
   * Returns a list of Issuing <code>Card</code> objects. The objects are sorted in descending order
   * by creation date, with the most recently created object appearing first.
   */
  public static CardCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/cards");
    return requestCollection(url, params, CardCollection.class, options);
  }

  /**
   * Returns a list of Issuing <code>Card</code> objects. The objects are sorted in descending order
   * by creation date, with the most recently created object appearing first.
   */
  public static CardCollection list(CardListParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/cards");
    return requestCollection(url, params, CardCollection.class, options);
  }

  /** Creates an Issuing <code>Card</code> object. */
  public static Card create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates an Issuing <code>Card</code> object. */
  public static Card create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/cards");
    return request(ApiResource.RequestMethod.POST, url, params, Card.class, options);
  }

  /** Creates an Issuing <code>Card</code> object. */
  public static Card create(CardCreateParams params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/issuing/cards");
    return request(ApiResource.RequestMethod.POST, url, params, Card.class, options);
  }

  /** Retrieves an Issuing <code>Card</code> object. */
  public static Card retrieve(String card) throws StripeException {
    return retrieve(card, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves an Issuing <code>Card</code> object. */
  public static Card retrieve(String card, RequestOptions options) throws StripeException {
    return retrieve(card, (Map<String, Object>) null, options);
  }

  /** Retrieves an Issuing <code>Card</code> object. */
  public static Card retrieve(String card, Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format("%s%s", Stripe.getApiBase(), String.format("/v1/issuing/cards/%s", card));
    return request(ApiResource.RequestMethod.GET, url, params, Card.class, options);
  }

  /** Retrieves an Issuing <code>Card</code> object. */
  public static Card retrieve(String card, CardRetrieveParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format("%s%s", Stripe.getApiBase(), String.format("/v1/issuing/cards/%s", card));
    return request(ApiResource.RequestMethod.GET, url, params, Card.class, options);
  }

  /**
   * Updates the specified Issuing <code>Card</code> object by setting the values of the parameters
   * passed. Any parameters not provided will be left unchanged.
   */
  public Card update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates the specified Issuing <code>Card</code> object by setting the values of the parameters
   * passed. Any parameters not provided will be left unchanged.
   */
  public Card update(Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s", Stripe.getApiBase(), String.format("/v1/issuing/cards/%s", this.getId()));
    return request(ApiResource.RequestMethod.POST, url, params, Card.class, options);
  }

  /**
   * Updates the specified Issuing <code>Card</code> object by setting the values of the parameters
   * passed. Any parameters not provided will be left unchanged.
   */
  public Card update(CardUpdateParams params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s", Stripe.getApiBase(), String.format("/v1/issuing/cards/%s", this.getId()));
    return request(ApiResource.RequestMethod.POST, url, params, Card.class, options);
  }

  /**
   * For virtual cards only. Retrieves an Issuing <code>Card_details</code> object that contains <a
   * href="/docs/issuing/cards/management#virtual-card-info">the sensitive details</a> of a virtual
   * card.
   */
  public CardDetails details() throws StripeException {
    return details((Map<String, Object>) null, (RequestOptions) null);
  }

  /**
   * For virtual cards only. Retrieves an Issuing <code>Card_details</code> object that contains <a
   * href="/docs/issuing/cards/management#virtual-card-info">the sensitive details</a> of a virtual
   * card.
   */
  public CardDetails details(Map<String, Object> params) throws StripeException {
    return details(params, (RequestOptions) null);
  }

  /**
   * For virtual cards only. Retrieves an Issuing <code>Card_details</code> object that contains <a
   * href="/docs/issuing/cards/management#virtual-card-info">the sensitive details</a> of a virtual
   * card.
   */
  public CardDetails details(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(), String.format("/v1/issuing/cards/%s/details", this.getId()));
    return request(ApiResource.RequestMethod.GET, url, params, CardDetails.class, options);
  }

  /**
   * For virtual cards only. Retrieves an Issuing <code>Card_details</code> object that contains <a
   * href="/docs/issuing/cards/management#virtual-card-info">the sensitive details</a> of a virtual
   * card.
   */
  public CardDetails details(CardDetailsParams params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s",
            Stripe.getApiBase(), String.format("/v1/issuing/cards/%s/details", this.getId()));
    return request(ApiResource.RequestMethod.GET, url, params, CardDetails.class, options);
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class AuthorizationControls extends StripeObject {
    /**
     * Array of strings containing
     * [categories](/docs/api#issuing_authorization_object-merchant_data-category) of authorizations
     * permitted on this card.
     */
    @SerializedName("allowed_categories")
    List<String> allowedCategories;

    /**
     * Array of strings containing
     * [categories](/docs/api#issuing_authorization_object-merchant_data-category) of authorizations
     * to always decline on this card.
     */
    @SerializedName("blocked_categories")
    List<String> blockedCategories;

    /**
     * The currency of the card. See
     * [max_amount](/docs/api#issuing_card_object-authorization_controls-max_amount)
     */
    @SerializedName("currency")
    String currency;

    /**
     * Maximum amount allowed per authorization on this card, in the currency of the card.
     * Authorization amounts in a different currency will be converted to the card's currency when
     * evaluating this control.
     */
    @SerializedName("max_amount")
    Long maxAmount;

    /**
     * Maximum count of approved authorizations on this card. Counts all authorizations
     * retroactively.
     */
    @SerializedName("max_approvals")
    Long maxApprovals;
  }

  @Getter
  @Setter
  @EqualsAndHashCode(callSuper = false)
  public static class Shipping extends StripeObject {
    @SerializedName("address")
    Address address;

    /** The delivery service that shipped a physical product, such as Fedex, UPS, USPS, etc. */
    @SerializedName("carrier")
    String carrier;

    /** A unix timestamp representing a best estimate of when the card will be delivered. */
    @SerializedName("eta")
    Long eta;

    /** Recipient name. */
    @SerializedName("name")
    String name;

    /** Recipient phone (including extension). */
    @SerializedName("phone")
    String phone;

    /**
     * The delivery status of the card. One of `pending`, `shipped`, `delivered`, `returned`,
     * `failure`, or `canceled`.
     */
    @SerializedName("status")
    String status;

    /**
     * The tracking number for a physical product, obtained from the delivery service. If multiple
     * tracking numbers were generated for this purchase, please separate them with commas.
     */
    @SerializedName("tracking_number")
    String trackingNumber;

    /**
     * A link to the shipping carrier's site where you can view detailed information about a card
     * shipment.
     */
    @SerializedName("tracking_url")
    String trackingUrl;

    /**
     * One of `bulk` or `individual`. Bulk shipments will be grouped and mailed together, while
     * individual ones will not.
     */
    @SerializedName("type")
    String type;
  }
}
