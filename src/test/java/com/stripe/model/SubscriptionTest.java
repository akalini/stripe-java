package com.stripe.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.stripe.BaseStripeTest;
import com.stripe.net.ApiResource;

import java.math.BigDecimal;

import org.junit.Test;

public class SubscriptionTest extends BaseStripeTest {
  @Test
  public void testDeserialize() throws Exception {
    final String data = getFixture("/v1/subscriptions/sub_123");
    final Subscription subscription = ApiResource.GSON.fromJson(data, Subscription.class);
    assertNotNull(subscription);
    assertNotNull(subscription.getId());
    assertEquals("subscription", subscription.getObject());
  }

  @Test
  public void testDeserializeWithExpansions() throws Exception {
    // TODO: Add support for expanding "transfer_data.destination" when stripe-mock supports it.
    final String[] expansions = {
      "customer",
      "default_source",
    };
    final String data = getFixture("/v1/subscriptions/sub_123", expansions);
    final Subscription subscription = ApiResource.GSON.fromJson(data, Subscription.class);
    assertNotNull(subscription);

    final Customer customer = subscription.getCustomerObject();
    assertNotNull(customer);
    assertNotNull(customer.getId());
    assertEquals(subscription.getCustomer(), customer.getId());

    final ExternalAccount defaultSource = subscription.getDefaultSourceObject();
    assertNotNull(defaultSource);
    assertNotNull(defaultSource.getId());
    assertEquals(subscription.getDefaultSource(), defaultSource.getId());
  }

  @Test
  public void testDeserializeBigDecimal() {
    final String data = "{\"object\": \"subscription\", \"tax_percent\": 0.3}";
    final Subscription subscription = ApiResource.GSON.fromJson(data, Subscription.class);
    assertNotNull(subscription);
    assertNotNull(subscription.getTaxPercent());
    assertTrue(subscription.getTaxPercent().equals(new BigDecimal("0.3")));
  }
}
