// Generated by com.stripe.generator.entity.SdkBuilder

package com.stripe.model.terminal;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Address;
import com.stripe.model.HasId;
import com.stripe.net.ApiResource;
import com.stripe.net.RequestOptions;
import java.util.Map;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Location extends ApiResource implements HasId {
  Address address;

  /** Always true for a deleted object. */
  Boolean deleted;

  /** The display name of the location. */
  String displayName;

  /** Unique identifier for the object. */
  @Getter(onMethod = @__({@Override}))
  String id;

  /** String representing the object's type. Objects of the same type share the same value. */
  String object;

  /** Retrieves a <code>Location</code> object. */
  public static Location retrieve(String location) throws StripeException {
    return retrieve(location, (Map<String, Object>) null, (RequestOptions) null);
  }

  /** Retrieves a <code>Location</code> object. */
  public static Location retrieve(String location, RequestOptions options) throws StripeException {
    return retrieve(location, (Map<String, Object>) null, options);
  }

  /** Retrieves a <code>Location</code> object. */
  public static Location retrieve(
      String location, Map<String, Object> params, RequestOptions options) throws StripeException {
    String url =
        String.format(
            "%s%s", Stripe.getApiBase(), String.format("/v1/terminal/locations/%s", location));
    return request(ApiResource.RequestMethod.GET, url, params, Location.class, options);
  }

  /** Creates a new <code>Location</code> object. */
  public static Location create(Map<String, Object> params) throws StripeException {
    return create(params, (RequestOptions) null);
  }

  /** Creates a new <code>Location</code> object. */
  public static Location create(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/terminal/locations");
    return request(ApiResource.RequestMethod.POST, url, params, Location.class, options);
  }

  /**
   * Updates a <code>Location</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged.
   */
  public Location update(Map<String, Object> params) throws StripeException {
    return update(params, (RequestOptions) null);
  }

  /**
   * Updates a <code>Location</code> object by setting the values of the parameters passed. Any
   * parameters not provided will be left unchanged.
   */
  public Location update(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url =
        String.format(
            "%s%s", Stripe.getApiBase(), String.format("/v1/terminal/locations/%s", this.getId()));
    return request(ApiResource.RequestMethod.POST, url, params, Location.class, options);
  }

  /** Returns a list of <code>Location</code> objects. */
  public static LocationCollection list(Map<String, Object> params) throws StripeException {
    return list(params, (RequestOptions) null);
  }

  /** Returns a list of <code>Location</code> objects. */
  public static LocationCollection list(Map<String, Object> params, RequestOptions options)
      throws StripeException {
    String url = String.format("%s%s", Stripe.getApiBase(), "/v1/terminal/locations");
    return requestCollection(url, params, LocationCollection.class, options);
  }
}