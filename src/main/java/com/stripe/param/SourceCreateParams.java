// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class SourceCreateParams extends ApiRequestParams {
  /**
   * Amount associated with the source. This is the amount for which the source will be chargeable
   * once ready. Required for `single_use` sources.
   */
  @SerializedName("amount")
  Long amount;

  /**
   * Three-letter [ISO code for the currency](https://stripe.com/docs/currencies) associated with
   * the source. This is the currency for which the source will be chargeable once ready.
   */
  @SerializedName("currency")
  String currency;

  /**
   * The `Customer` to whom the original source is attached to. Must be set when the original source
   * is not a `Source` (e.g., `Card`).
   */
  @SerializedName("customer")
  String customer;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /**
   * The authentication `flow` of the source to create. `flow` is one of `redirect`, `receiver`,
   * `code_verification`, `none`. It is generally inferred unless a type supports multiple flows.
   */
  @SerializedName("flow")
  Flow flow;

  /**
   * Information about a mandate possibility attached to a source object (generally for bank debits)
   * as well as its acceptance status.
   */
  @SerializedName("mandate")
  Mandate mandate;

  /**
   * A set of key-value pairs that you can attach to a source object. It can be useful for storing
   * additional information about the source in a structured format.
   */
  @SerializedName("metadata")
  Map<String, String> metadata;

  /** The source to share. */
  @SerializedName("original_source")
  String originalSource;

  /**
   * Information about the owner of the payment instrument that may be used or required by
   * particular source types.
   */
  @SerializedName("owner")
  Owner owner;

  /**
   * Optional parameters for the receiver flow. Can be set only if the source is a receiver (`flow`
   * is `receiver`).
   */
  @SerializedName("receiver")
  Receiver receiver;

  /**
   * Parameters required for the redirect flow. Required if the source is authenticated by a
   * redirect (`flow` is `redirect`).
   */
  @SerializedName("redirect")
  Redirect redirect;

  /**
   * An arbitrary string to be displayed on your customer's statement. As an example, if your
   * website is `RunClub` and the item you're charging for is a race ticket, you may want to specify
   * a `statement_descriptor` of `RunClub 5K race ticket.` While many payment types will display
   * this information, some may not display it at all.
   */
  @SerializedName("statement_descriptor")
  String statementDescriptor;

  /**
   * An optional token used to create the source. When passed, token properties will override source
   * parameters.
   */
  @SerializedName("token")
  String token;

  /**
   * The `type` of the source to create. Required unless `customer` and `original_source` are
   * specified (see the [Shared card Sources](/docs/sources/connect#shared-card-sources) guide)
   */
  @SerializedName("type")
  String type;

  @SerializedName("usage")
  Usage usage;

  private SourceCreateParams(
      Long amount,
      String currency,
      String customer,
      List<String> expand,
      Flow flow,
      Mandate mandate,
      Map<String, String> metadata,
      String originalSource,
      Owner owner,
      Receiver receiver,
      Redirect redirect,
      String statementDescriptor,
      String token,
      String type,
      Usage usage) {
    this.amount = amount;
    this.currency = currency;
    this.customer = customer;
    this.expand = expand;
    this.flow = flow;
    this.mandate = mandate;
    this.metadata = metadata;
    this.originalSource = originalSource;
    this.owner = owner;
    this.receiver = receiver;
    this.redirect = redirect;
    this.statementDescriptor = statementDescriptor;
    this.token = token;
    this.type = type;
    this.usage = usage;
  }

  public static Builder builder() {
    return new com.stripe.param.SourceCreateParams.Builder();
  }

  public static class Builder {
    private Long amount;

    private String currency;

    private String customer;

    private List<String> expand;

    private Flow flow;

    private Mandate mandate;

    private Map<String, String> metadata;

    private String originalSource;

    private Owner owner;

    private Receiver receiver;

    private Redirect redirect;

    private String statementDescriptor;

    private String token;

    private String type;

    private Usage usage;

    /** Finalize and obtain parameter instance from this builder. */
    public SourceCreateParams build() {
      return new SourceCreateParams(
          this.amount,
          this.currency,
          this.customer,
          this.expand,
          this.flow,
          this.mandate,
          this.metadata,
          this.originalSource,
          this.owner,
          this.receiver,
          this.redirect,
          this.statementDescriptor,
          this.token,
          this.type,
          this.usage);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link SourceCreateParams#expand}
     * for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /**
     * Add a key/value pair to `metadata` map. A map is initialized for the first call, and
     * subsequent calls adds additional key/value pairs to the original map. See {@link
     * SourceCreateParams#metadata} for the field documentation.
     */
    public Builder putMetadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.put(key, value);
      return this;
    }

    /**
     * Amount associated with the source. This is the amount for which the source will be chargeable
     * once ready. Required for `single_use` sources.
     */
    public Builder setAmount(Long amount) {
      this.amount = amount;
      return this;
    }

    /**
     * Three-letter [ISO code for the currency](https://stripe.com/docs/currencies) associated with
     * the source. This is the currency for which the source will be chargeable once ready.
     */
    public Builder setCurrency(String currency) {
      this.currency = currency;
      return this;
    }

    /**
     * The `Customer` to whom the original source is attached to. Must be set when the original
     * source is not a `Source` (e.g., `Card`).
     */
    public Builder setCustomer(String customer) {
      this.customer = customer;
      return this;
    }

    /**
     * The authentication `flow` of the source to create. `flow` is one of `redirect`, `receiver`,
     * `code_verification`, `none`. It is generally inferred unless a type supports multiple flows.
     */
    public Builder setFlow(Flow flow) {
      this.flow = flow;
      return this;
    }

    /**
     * Information about a mandate possibility attached to a source object (generally for bank
     * debits) as well as its acceptance status.
     */
    public Builder setMandate(Mandate mandate) {
      this.mandate = mandate;
      return this;
    }

    /** The source to share. */
    public Builder setOriginalSource(String originalSource) {
      this.originalSource = originalSource;
      return this;
    }

    /**
     * Information about the owner of the payment instrument that may be used or required by
     * particular source types.
     */
    public Builder setOwner(Owner owner) {
      this.owner = owner;
      return this;
    }

    /**
     * Optional parameters for the receiver flow. Can be set only if the source is a receiver
     * (`flow` is `receiver`).
     */
    public Builder setReceiver(Receiver receiver) {
      this.receiver = receiver;
      return this;
    }

    /**
     * Parameters required for the redirect flow. Required if the source is authenticated by a
     * redirect (`flow` is `redirect`).
     */
    public Builder setRedirect(Redirect redirect) {
      this.redirect = redirect;
      return this;
    }

    /**
     * An arbitrary string to be displayed on your customer's statement. As an example, if your
     * website is `RunClub` and the item you're charging for is a race ticket, you may want to
     * specify a `statement_descriptor` of `RunClub 5K race ticket.` While many payment types will
     * display this information, some may not display it at all.
     */
    public Builder setStatementDescriptor(String statementDescriptor) {
      this.statementDescriptor = statementDescriptor;
      return this;
    }

    /**
     * An optional token used to create the source. When passed, token properties will override
     * source parameters.
     */
    public Builder setToken(String token) {
      this.token = token;
      return this;
    }

    /**
     * The `type` of the source to create. Required unless `customer` and `original_source` are
     * specified (see the [Shared card Sources](/docs/sources/connect#shared-card-sources) guide)
     */
    public Builder setType(String type) {
      this.type = type;
      return this;
    }

    public Builder setUsage(Usage usage) {
      this.usage = usage;
      return this;
    }
  }

  @Getter
  public static class Mandate {
    /**
     * The parameters required to notify Stripe of a mandate acceptance or refusal by the customer.
     */
    @SerializedName("acceptance")
    Acceptance acceptance;

    /** The amount specified by the mandate. (Leave null for a mandate covering all amounts) */
    @SerializedName("amount")
    Object amount;

    /** The currency specified by the mandate. (Must match `currency` of the source) */
    @SerializedName("currency")
    String currency;

    /**
     * The interval of debits permitted by the mandate. Either `one_time` (just permitting a single
     * debit), `scheduled` (with debits on an agreed schedule or for clearly-defined events), or
     * `variable`(for debits with any frequency)
     */
    @SerializedName("interval")
    Interval interval;

    /**
     * The method Stripe should use to notify the customer of upcoming debit instructions and/or
     * mandate confirmation as required by the underlying debit network. Either `email` (an email is
     * sent directly to the customer), `manual` (a `source.mandate_notification` event is sent to
     * your webhooks endpoint and you should handle the notification) or `none` (the underlying
     * debit network does not require any notification).
     */
    @SerializedName("notification_method")
    NotificationMethod notificationMethod;

    private Mandate(
        Acceptance acceptance,
        Object amount,
        String currency,
        Interval interval,
        NotificationMethod notificationMethod) {
      this.acceptance = acceptance;
      this.amount = amount;
      this.currency = currency;
      this.interval = interval;
      this.notificationMethod = notificationMethod;
    }

    public static Builder builder() {
      return new com.stripe.param.SourceCreateParams.Mandate.Builder();
    }

    public static class Builder {
      private Acceptance acceptance;

      private Object amount;

      private String currency;

      private Interval interval;

      private NotificationMethod notificationMethod;

      /** Finalize and obtain parameter instance from this builder. */
      public Mandate build() {
        return new Mandate(
            this.acceptance, this.amount, this.currency, this.interval, this.notificationMethod);
      }

      /**
       * The parameters required to notify Stripe of a mandate acceptance or refusal by the
       * customer.
       */
      public Builder setAcceptance(Acceptance acceptance) {
        this.acceptance = acceptance;
        return this;
      }

      /** The amount specified by the mandate. (Leave null for a mandate covering all amounts) */
      public Builder setAmount(Empty amount) {
        this.amount = amount;
        return this;
      }

      /** The amount specified by the mandate. (Leave null for a mandate covering all amounts) */
      public Builder setAmount(Long amount) {
        this.amount = amount;
        return this;
      }

      /** The currency specified by the mandate. (Must match `currency` of the source) */
      public Builder setCurrency(String currency) {
        this.currency = currency;
        return this;
      }

      /**
       * The interval of debits permitted by the mandate. Either `one_time` (just permitting a
       * single debit), `scheduled` (with debits on an agreed schedule or for clearly-defined
       * events), or `variable`(for debits with any frequency)
       */
      public Builder setInterval(Interval interval) {
        this.interval = interval;
        return this;
      }

      /**
       * The method Stripe should use to notify the customer of upcoming debit instructions and/or
       * mandate confirmation as required by the underlying debit network. Either `email` (an email
       * is sent directly to the customer), `manual` (a `source.mandate_notification` event is sent
       * to your webhooks endpoint and you should handle the notification) or `none` (the underlying
       * debit network does not require any notification).
       */
      public Builder setNotificationMethod(NotificationMethod notificationMethod) {
        this.notificationMethod = notificationMethod;
        return this;
      }
    }

    @Getter
    public static class Acceptance {
      /** The unix timestamp the mandate was accepted or refused at by the customer. */
      @SerializedName("date")
      Long date;

      /** The IP address from which the mandate was accepted or refused by the customer. */
      @SerializedName("ip")
      String ip;

      /**
       * The parameters required to store a mandate accepted offline. Should only be set if
       * `mandate[type]` is `offline`
       */
      @SerializedName("offline")
      Offline offline;

      /**
       * The parameters required to store a mandate accepted online. Should only be set if
       * `mandate[type]` is `online`
       */
      @SerializedName("online")
      Online online;

      /**
       * The status of the mandate acceptance. Either `accepted` (the mandate was accepted) or
       * `refused` (the mandate was refused).
       */
      @SerializedName("status")
      Status status;

      /**
       * The type of acceptance information included with the mandate. Either `online` or `offline`
       */
      @SerializedName("type")
      Type type;

      /**
       * The user agent of the browser from which the mandate was accepted or refused by the
       * customer.
       */
      @SerializedName("user_agent")
      String userAgent;

      private Acceptance(
          Long date,
          String ip,
          Offline offline,
          Online online,
          Status status,
          Type type,
          String userAgent) {
        this.date = date;
        this.ip = ip;
        this.offline = offline;
        this.online = online;
        this.status = status;
        this.type = type;
        this.userAgent = userAgent;
      }

      public static Builder builder() {
        return new com.stripe.param.SourceCreateParams.Mandate.Acceptance.Builder();
      }

      public static class Builder {
        private Long date;

        private String ip;

        private Offline offline;

        private Online online;

        private Status status;

        private Type type;

        private String userAgent;

        /** Finalize and obtain parameter instance from this builder. */
        public Acceptance build() {
          return new Acceptance(
              this.date,
              this.ip,
              this.offline,
              this.online,
              this.status,
              this.type,
              this.userAgent);
        }

        /** The unix timestamp the mandate was accepted or refused at by the customer. */
        public Builder setDate(Long date) {
          this.date = date;
          return this;
        }

        /** The IP address from which the mandate was accepted or refused by the customer. */
        public Builder setIp(String ip) {
          this.ip = ip;
          return this;
        }

        /**
         * The parameters required to store a mandate accepted offline. Should only be set if
         * `mandate[type]` is `offline`
         */
        public Builder setOffline(Offline offline) {
          this.offline = offline;
          return this;
        }

        /**
         * The parameters required to store a mandate accepted online. Should only be set if
         * `mandate[type]` is `online`
         */
        public Builder setOnline(Online online) {
          this.online = online;
          return this;
        }

        /**
         * The status of the mandate acceptance. Either `accepted` (the mandate was accepted) or
         * `refused` (the mandate was refused).
         */
        public Builder setStatus(Status status) {
          this.status = status;
          return this;
        }

        /**
         * The type of acceptance information included with the mandate. Either `online` or
         * `offline`
         */
        public Builder setType(Type type) {
          this.type = type;
          return this;
        }

        /**
         * The user agent of the browser from which the mandate was accepted or refused by the
         * customer.
         */
        public Builder setUserAgent(String userAgent) {
          this.userAgent = userAgent;
          return this;
        }
      }

      @Getter
      public static class Offline {
        /**
         * An email to contact you with if a copy of the mandate is requested, required if `type` is
         * `offline`.
         */
        @SerializedName("contact_email")
        String contactEmail;

        private Offline(String contactEmail) {
          this.contactEmail = contactEmail;
        }

        public static Builder builder() {
          return new com.stripe.param.SourceCreateParams.Mandate.Acceptance.Offline.Builder();
        }

        public static class Builder {
          private String contactEmail;

          /** Finalize and obtain parameter instance from this builder. */
          public Offline build() {
            return new Offline(this.contactEmail);
          }

          /**
           * An email to contact you with if a copy of the mandate is requested, required if `type`
           * is `offline`.
           */
          public Builder setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
            return this;
          }
        }
      }

      @Getter
      public static class Online {
        /** The unix timestamp the mandate was accepted or refused at by the customer. */
        @SerializedName("date")
        Long date;

        /** The IP address from which the mandate was accepted or refused by the customer. */
        @SerializedName("ip")
        String ip;

        /**
         * The user agent of the browser from which the mandate was accepted or refused by the
         * customer.
         */
        @SerializedName("user_agent")
        String userAgent;

        private Online(Long date, String ip, String userAgent) {
          this.date = date;
          this.ip = ip;
          this.userAgent = userAgent;
        }

        public static Builder builder() {
          return new com.stripe.param.SourceCreateParams.Mandate.Acceptance.Online.Builder();
        }

        public static class Builder {
          private Long date;

          private String ip;

          private String userAgent;

          /** Finalize and obtain parameter instance from this builder. */
          public Online build() {
            return new Online(this.date, this.ip, this.userAgent);
          }

          /** The unix timestamp the mandate was accepted or refused at by the customer. */
          public Builder setDate(Long date) {
            this.date = date;
            return this;
          }

          /** The IP address from which the mandate was accepted or refused by the customer. */
          public Builder setIp(String ip) {
            this.ip = ip;
            return this;
          }

          /**
           * The user agent of the browser from which the mandate was accepted or refused by the
           * customer.
           */
          public Builder setUserAgent(String userAgent) {
            this.userAgent = userAgent;
            return this;
          }
        }
      }

      public enum Status implements ApiRequestParams.Enum {
        @SerializedName("accepted")
        ACCEPTED("accepted"),

        @SerializedName("pending")
        PENDING("pending"),

        @SerializedName("refused")
        REFUSED("refused"),

        @SerializedName("revoked")
        REVOKED("revoked");

        @Getter private final String value;

        Status(String value) {
          this.value = value;
        }
      }

      public enum Type implements ApiRequestParams.Enum {
        @SerializedName("offline")
        OFFLINE("offline"),

        @SerializedName("online")
        ONLINE("online");

        @Getter private final String value;

        Type(String value) {
          this.value = value;
        }
      }
    }

    public enum Empty implements ApiRequestParams.Enum {
      @SerializedName("")
      EMPTY("");

      @Getter private final String value;

      Empty(String value) {
        this.value = value;
      }
    }

    public enum Interval implements ApiRequestParams.Enum {
      @SerializedName("one_time")
      ONE_TIME("one_time"),

      @SerializedName("scheduled")
      SCHEDULED("scheduled"),

      @SerializedName("variable")
      VARIABLE("variable");

      @Getter private final String value;

      Interval(String value) {
        this.value = value;
      }
    }

    public enum NotificationMethod implements ApiRequestParams.Enum {
      @SerializedName("deprecated_none")
      DEPRECATED_NONE("deprecated_none"),

      @SerializedName("email")
      EMAIL("email"),

      @SerializedName("manual")
      MANUAL("manual"),

      @SerializedName("none")
      NONE("none"),

      @SerializedName("stripe_email")
      STRIPE_EMAIL("stripe_email");

      @Getter private final String value;

      NotificationMethod(String value) {
        this.value = value;
      }
    }
  }

  @Getter
  public static class Owner {
    /** Owner's address. */
    @SerializedName("address")
    Address address;

    /** Owner's email address. */
    @SerializedName("email")
    String email;

    /** Owner's full name. */
    @SerializedName("name")
    String name;

    /** Owner's phone number. */
    @SerializedName("phone")
    String phone;

    private Owner(Address address, String email, String name, String phone) {
      this.address = address;
      this.email = email;
      this.name = name;
      this.phone = phone;
    }

    public static Builder builder() {
      return new com.stripe.param.SourceCreateParams.Owner.Builder();
    }

    public static class Builder {
      private Address address;

      private String email;

      private String name;

      private String phone;

      /** Finalize and obtain parameter instance from this builder. */
      public Owner build() {
        return new Owner(this.address, this.email, this.name, this.phone);
      }

      /** Owner's address. */
      public Builder setAddress(Address address) {
        this.address = address;
        return this;
      }

      /** Owner's email address. */
      public Builder setEmail(String email) {
        this.email = email;
        return this;
      }

      /** Owner's full name. */
      public Builder setName(String name) {
        this.name = name;
        return this;
      }

      /** Owner's phone number. */
      public Builder setPhone(String phone) {
        this.phone = phone;
        return this;
      }
    }

    @Getter
    public static class Address {
      @SerializedName("city")
      String city;

      @SerializedName("country")
      String country;

      @SerializedName("line1")
      String line1;

      @SerializedName("line2")
      String line2;

      @SerializedName("postal_code")
      String postalCode;

      @SerializedName("state")
      String state;

      private Address(
          String city,
          String country,
          String line1,
          String line2,
          String postalCode,
          String state) {
        this.city = city;
        this.country = country;
        this.line1 = line1;
        this.line2 = line2;
        this.postalCode = postalCode;
        this.state = state;
      }

      public static Builder builder() {
        return new com.stripe.param.SourceCreateParams.Owner.Address.Builder();
      }

      public static class Builder {
        private String city;

        private String country;

        private String line1;

        private String line2;

        private String postalCode;

        private String state;

        /** Finalize and obtain parameter instance from this builder. */
        public Address build() {
          return new Address(
              this.city, this.country, this.line1, this.line2, this.postalCode, this.state);
        }

        public Builder setCity(String city) {
          this.city = city;
          return this;
        }

        public Builder setCountry(String country) {
          this.country = country;
          return this;
        }

        public Builder setLine1(String line1) {
          this.line1 = line1;
          return this;
        }

        public Builder setLine2(String line2) {
          this.line2 = line2;
          return this;
        }

        public Builder setPostalCode(String postalCode) {
          this.postalCode = postalCode;
          return this;
        }

        public Builder setState(String state) {
          this.state = state;
          return this;
        }
      }
    }
  }

  @Getter
  public static class Receiver {
    /**
     * The method Stripe should use to request information needed to process a refund or mispayment.
     * Either `email` (an email is sent directly to the customer) or `manual` (a
     * `source.refund_attributes_required` event is sent to your webhooks endpoint). Refer to each
     * payment method's documentation to learn which refund attributes may be required.
     */
    @SerializedName("refund_attributes_method")
    RefundAttributesMethod refundAttributesMethod;

    private Receiver(RefundAttributesMethod refundAttributesMethod) {
      this.refundAttributesMethod = refundAttributesMethod;
    }

    public static Builder builder() {
      return new com.stripe.param.SourceCreateParams.Receiver.Builder();
    }

    public static class Builder {
      private RefundAttributesMethod refundAttributesMethod;

      /** Finalize and obtain parameter instance from this builder. */
      public Receiver build() {
        return new Receiver(this.refundAttributesMethod);
      }

      /**
       * The method Stripe should use to request information needed to process a refund or
       * mispayment. Either `email` (an email is sent directly to the customer) or `manual` (a
       * `source.refund_attributes_required` event is sent to your webhooks endpoint). Refer to each
       * payment method's documentation to learn which refund attributes may be required.
       */
      public Builder setRefundAttributesMethod(RefundAttributesMethod refundAttributesMethod) {
        this.refundAttributesMethod = refundAttributesMethod;
        return this;
      }
    }

    public enum RefundAttributesMethod implements ApiRequestParams.Enum {
      @SerializedName("email")
      EMAIL("email"),

      @SerializedName("manual")
      MANUAL("manual"),

      @SerializedName("none")
      NONE("none");

      @Getter private final String value;

      RefundAttributesMethod(String value) {
        this.value = value;
      }
    }
  }

  @Getter
  public static class Redirect {
    /**
     * The URL you provide to redirect the customer back to you after they authenticated their
     * payment. It can use your application URI scheme in the context of a mobile application.
     */
    @SerializedName("return_url")
    String returnUrl;

    private Redirect(String returnUrl) {
      this.returnUrl = returnUrl;
    }

    public static Builder builder() {
      return new com.stripe.param.SourceCreateParams.Redirect.Builder();
    }

    public static class Builder {
      private String returnUrl;

      /** Finalize and obtain parameter instance from this builder. */
      public Redirect build() {
        return new Redirect(this.returnUrl);
      }

      /**
       * The URL you provide to redirect the customer back to you after they authenticated their
       * payment. It can use your application URI scheme in the context of a mobile application.
       */
      public Builder setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
      }
    }
  }

  public enum Flow implements ApiRequestParams.Enum {
    @SerializedName("code_verification")
    CODE_VERIFICATION("code_verification"),

    @SerializedName("none")
    NONE("none"),

    @SerializedName("receiver")
    RECEIVER("receiver"),

    @SerializedName("redirect")
    REDIRECT("redirect");

    @Getter private final String value;

    Flow(String value) {
      this.value = value;
    }
  }

  public enum Usage implements ApiRequestParams.Enum {
    @SerializedName("reusable")
    REUSABLE("reusable"),

    @SerializedName("single_use")
    SINGLE_USE("single_use");

    @Getter private final String value;

    Usage(String value) {
      this.value = value;
    }
  }
}
