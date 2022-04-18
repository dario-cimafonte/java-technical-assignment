package kata.supermarket;

import kata.supermarket.offer.Offer;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void singleItemHasExpectedUnitPriceFromProduct() {
        final BigDecimal price = new BigDecimal("2.49");
        assertEquals(price, new Product(price).oneOf().price());
    }

    @Test
    void singleItemIsEligibleForGivenOffer() {
        final BigDecimal price = new BigDecimal("2.49");
        assertTrue(new Product(price, TestOffer1.class).isEligibleFor(TestOffer1.class));
    }

    @Test
    void singleItemIsEligibleForTwoOffers() {
        final BigDecimal price = new BigDecimal("2.49");
        Product product = new Product(price, TestOffer1.class, TestOffer2.class);
        assertTrue(product.isEligibleFor(TestOffer1.class));
        assertTrue(product.isEligibleFor(TestOffer2.class));
    }

    @Test
    void singleItemIsEligibleForDifferentOffer() {
        final BigDecimal price = new BigDecimal("2.49");
        assertFalse(new Product(price, TestOffer1.class).isEligibleFor(TestOffer2.class));
    }

    @Test
    void singleItemIsNotEligibleForAnyOffer() {
        final BigDecimal price = new BigDecimal("2.49");
        assertFalse(new Product(price).isEligibleFor(TestOffer2.class));
    }

    private static class TestOffer1 implements Offer {
        @Override
        public BigDecimal discountFor(Basket basket) {
            return new BigDecimal("1.00");
        }
    }

    private static class TestOffer2 implements Offer {
        @Override
        public BigDecimal discountFor(Basket basket) {
            return new BigDecimal("2.00");
        }
    }
}