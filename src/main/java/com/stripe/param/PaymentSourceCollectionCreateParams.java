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
public class PaymentSourceCollectionCreateParams extends ApiRequestParams {
  /**
   * A token returned by [Stripe.js](https://stripe.com/docs/stripe.js) representing the user’s
   * Alipay account details.
   */
  @SerializedName("alipay_account")
  Object alipayAccount;

  /**
   * Either a token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js), or a
   * dictionary containing a user's bank account details.
   */
  @SerializedName("bank_account")
  Object bankAccount;

  /** A token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js). */
  @SerializedName("card")
  Object card;

  /** Specifies which fields in the response should be expanded. */
  @SerializedName("expand")
  List<String> expand;

  /**
   * A set of key-value pairs that you can attach to a card object. It can be useful for storing
   * additional information about the card in a structured format.
   */
  @SerializedName("metadata")
  Map<String, String> metadata;

  /** This string to be replaced by DocSpecGenerator. */
  @SerializedName("source")
  Object source;

  private PaymentSourceCollectionCreateParams(
      Object alipayAccount,
      Object bankAccount,
      Object card,
      List<String> expand,
      Map<String, String> metadata,
      Object source) {
    this.alipayAccount = alipayAccount;
    this.bankAccount = bankAccount;
    this.card = card;
    this.expand = expand;
    this.metadata = metadata;
    this.source = source;
  }

  public static Builder builder() {
    return new com.stripe.param.PaymentSourceCollectionCreateParams.Builder();
  }

  public static class Builder {
    private Object alipayAccount;

    private Object bankAccount;

    private Object card;

    private List<String> expand;

    private Map<String, String> metadata;

    private Object source;

    /** Finalize and obtain parameter instance from this builder. */
    public PaymentSourceCollectionCreateParams build() {
      return new PaymentSourceCollectionCreateParams(
          this.alipayAccount, this.bankAccount, this.card, this.expand, this.metadata, this.source);
    }

    /**
     * Add an element to `expand` list. A list is initialized for the first call, and subsequent
     * calls adds additional elements to the original list. See {@link
     * PaymentSourceCollectionCreateParams#expand} for the field documentation.
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
     * PaymentSourceCollectionCreateParams#metadata} for the field documentation.
     */
    public Builder putMetadata(String key, String value) {
      if (this.metadata == null) {
        this.metadata = new HashMap<>();
      }
      this.metadata.put(key, value);
      return this;
    }

    /**
     * A token returned by [Stripe.js](https://stripe.com/docs/stripe.js) representing the user’s
     * Alipay account details.
     */
    public Builder setAlipayAccount(String alipayAccount) {
      this.alipayAccount = alipayAccount;
      return this;
    }

    /**
     * A token returned by [Stripe.js](https://stripe.com/docs/stripe.js) representing the user’s
     * Alipay account details.
     */
    public Builder setAlipayAccount(Map<String, Object> alipayAccount) {
      this.alipayAccount = alipayAccount;
      return this;
    }

    /**
     * Either a token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js), or
     * a dictionary containing a user's bank account details.
     */
    public Builder setBankAccount(String bankAccount) {
      this.bankAccount = bankAccount;
      return this;
    }

    /**
     * Either a token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js), or
     * a dictionary containing a user's bank account details.
     */
    public Builder setBankAccount(Map<String, Object> bankAccount) {
      this.bankAccount = bankAccount;
      return this;
    }

    /** A token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js). */
    public Builder setCard(String card) {
      this.card = card;
      return this;
    }

    /** A token, like the ones returned by [Stripe.js](https://stripe.com/docs/stripe.js). */
    public Builder setCard(Map<String, Object> card) {
      this.card = card;
      return this;
    }

    /** This string to be replaced by DocSpecGenerator. */
    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    /** This string to be replaced by DocSpecGenerator. */
    public Builder setSource(Map<String, Object> source) {
      this.source = source;
      return this;
    }
  }
}
