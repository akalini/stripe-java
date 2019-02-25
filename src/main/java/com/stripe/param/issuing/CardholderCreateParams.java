// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.param.issuing;

import com.google.gson.annotations.SerializedName;
import com.stripe.net.ApiRequestParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;

@Getter
public class CardholderCreateParams extends ApiRequestParams {
  /** The cardholder's billing address. */
  @SerializedName("billing")
  Billing billing;

  /** The cardholder's email address. */
  @SerializedName("email")
  String email;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /** Specifies whether to set this as the default cardholder. */
  @SerializedName("is_default")
  Boolean isDefault;

  @SerializedName("metadata")
  Map<String, String> metadata;

  /** The cardholder's name. This will be printed on cards issued to them. */
  @SerializedName("name")
  String name;

  /**
   * The cardholder's phone number. This will be transformed to
   * [E.164](https://en.wikipedia.org/wiki/E.164) if it is not provided in that format already.
   */
  @SerializedName("phone_number")
  String phoneNumber;

  /**
   * Specifies whether to permit authorizations on this cardholder's cards. Possible values are
   * `active` or `inactive`.
   */
  @SerializedName("status")
  Status status;

  /** The type of cardholder. Possible values are `individual` or `business_entity`. */
  @SerializedName("type")
  Type type;

  private CardholderCreateParams(
      Billing billing,
      String email,
      List<String> expand,
      Boolean isDefault,
      Map<String, String> metadata,
      String name,
      String phoneNumber,
      Status status,
      Type type) {
    this.billing = billing;
    this.email = email;
    this.expand = expand;
    this.isDefault = isDefault;
    this.metadata = metadata;
    this.name = name;
    this.phoneNumber = phoneNumber;
    this.status = status;
    this.type = type;
  }

  public static Builder builder() {
    return new com.stripe.param.issuing.CardholderCreateParams.Builder();
  }

  public static class Builder {
    private Billing billing;

    private String email;

    private List<String> expand;

    private Boolean isDefault;

    private Map<String, String> metadata;

    private String name;

    private String phoneNumber;

    private Status status;

    private Type type;

    /** Finalize and obtain parameter instance from this builder. */
    public CardholderCreateParams build() {
      return new CardholderCreateParams(
          this.billing,
          this.email,
          this.expand,
          this.isDefault,
          this.metadata,
          this.name,
          this.phoneNumber,
          this.status,
          this.type);
    }

    /**
     * Add all elements to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * CardholderCreateParams#expand} for the field documentation.
     */
    public Builder addAllExpand(List<String> elements) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.addAll(elements);
      return this;
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first `add/addAll` call, and
     * subsequent calls adds additional elements to the original list. See {@link
     * CardholderCreateParams#expand} for the field documentation.
     */
    public Builder addExpand(String element) {
      if (this.expand == null) {
        this.expand = new ArrayList<>();
      }
      this.expand.add(element);
      return this;
    }

    /**
     * Add all map key/value pairs to `metadata` map. A map is initialized for the first
     * `put/putAll` call, and subsequent calls add additional key/value pairs to the original map.
     * See {@link CardholderCreateParams#metadata} for the field documentation.
     */
    public Builder putAllMetadata(Map<String, String> map) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.putAll(map);
      return this;
    }

    /**
     * Add a key/value pair to `metadata` map. A map is initialized for the first `put/putAll` call,
     * and subsequent calls add additional key/value pairs to the original map. See {@link
     * CardholderCreateParams#metadata} for the field documentation.
     */
    public Builder putMetadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.put(key, value);
      return this;
    }

    /** The cardholder's billing address. */
    public Builder setBilling(Billing billing) {
      this.billing = billing;
      return this;
    }

    /** The cardholder's email address. */
    public Builder setEmail(String email) {
      this.email = email;
      return this;
    }

    /** Specifies whether to set this as the default cardholder. */
    public Builder setIsDefault(Boolean isDefault) {
      this.isDefault = isDefault;
      return this;
    }

    /** The cardholder's name. This will be printed on cards issued to them. */
    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    /**
     * The cardholder's phone number. This will be transformed to
     * [E.164](https://en.wikipedia.org/wiki/E.164) if it is not provided in that format already.
     */
    public Builder setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }

    /**
     * Specifies whether to permit authorizations on this cardholder's cards. Possible values are
     * `active` or `inactive`.
     */
    public Builder setStatus(Status status) {
      this.status = status;
      return this;
    }

    /** The type of cardholder. Possible values are `individual` or `business_entity`. */
    public Builder setType(Type type) {
      this.type = type;
      return this;
    }
  }

  @Getter
  public static class Billing {
    @SerializedName("address")
    Address address;

    @SerializedName("name")
    String name;

    private Billing(Address address, String name) {
      this.address = address;
      this.name = name;
    }

    public static Builder builder() {
      return new com.stripe.param.issuing.CardholderCreateParams.Billing.Builder();
    }

    public static class Builder {
      private Address address;

      private String name;

      /** Finalize and obtain parameter instance from this builder. */
      public Billing build() {
        return new Billing(this.address, this.name);
      }

      public Builder setAddress(Address address) {
        this.address = address;
        return this;
      }

      public Builder setName(String name) {
        this.name = name;
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
        return new com.stripe.param.issuing.CardholderCreateParams.Billing.Address.Builder();
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

  public enum Status implements ApiRequestParams.Enum {
    @SerializedName("active")
    ACTIVE("active"),

    @SerializedName("inactive")
    INACTIVE("inactive");

    @Getter private final String value;

    Status(String value) {
      this.value = value;
    }
  }

  public enum Type implements ApiRequestParams.Enum {
    @SerializedName("business_entity")
    BUSINESS_ENTITY("business_entity"),

    @SerializedName("individual")
    INDIVIDUAL("individual");

    @Getter private final String value;

    Type(String value) {
      this.value = value;
    }
  }
}
