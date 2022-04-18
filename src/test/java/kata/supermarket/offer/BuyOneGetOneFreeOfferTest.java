package kata.supermarket.offer;

import kata.supermarket.Basket;
import kata.supermarket.Product;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyOneGetOneFreeOfferTest {

    private static final BigDecimal NO_DISCOUNT = new BigDecimal("0.00");

    @Test
    void doNotApplyOnEmptyBasket() {
        Basket basket = new Basket();

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer();
        BigDecimal discount = offer.discountFor(basket);
        assertEquals(NO_DISCOUNT, discount);
    }

    @Test
    void doNotApplyToSingleEligibleItem() {
        Basket basket = new Basket();
        BigDecimal pricePerUnit = new BigDecimal("2.49");
        Product product = new Product(pricePerUnit, BuyOneGetOneFreeOffer.class);
        basket.add(product.oneOf());

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer();
        BigDecimal discount = offer.discountFor(basket);
        assertEquals(NO_DISCOUNT, discount);
    }

    @Test
    void applyToTwoEligibleProducts() {
        Basket basket = new Basket();
        BigDecimal pricePerUnit = new BigDecimal("2.49");
        BigDecimal expectedDiscount = new BigDecimal("-2.49");
        Product product = new Product(pricePerUnit, BuyOneGetOneFreeOffer.class);
        basket.add(product.oneOf());
        basket.add(product.oneOf());

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer();
        BigDecimal discount = offer.discountFor(basket);
        assertEquals(expectedDiscount, discount);
    }

    @Test
    void applyToTwoNonEligibleProducts() {
        Basket basket = new Basket();
        BigDecimal pricePerUnit = new BigDecimal("2.49");
        Product product = new Product(pricePerUnit);
        basket.add(product.oneOf());
        basket.add(product.oneOf());

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer();
        BigDecimal discount = offer.discountFor(basket);
        assertEquals(NO_DISCOUNT, discount);
    }

    @Test
    void applyToOddNumberOfEligibleProducts() {
        Basket basket = new Basket();
        BigDecimal pricePerUnit = new BigDecimal("2.49");
        BigDecimal expectedDiscount = new BigDecimal("-2.49");
        Product product = new Product(pricePerUnit, BuyOneGetOneFreeOffer.class);
        basket.add(product.oneOf());
        basket.add(product.oneOf());
        basket.add(product.oneOf());

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer();
        BigDecimal discount = offer.discountFor(basket);
        assertEquals(expectedDiscount, discount);
    }

    @Test
    void applyToEvenNumberOfEligibleProducts() {
        Basket basket = new Basket();
        BigDecimal pricePerUnit = new BigDecimal("2.49");
        BigDecimal expectedDiscount = new BigDecimal("-4.98");
        Product product = new Product(pricePerUnit, BuyOneGetOneFreeOffer.class);
        basket.add(product.oneOf());
        basket.add(product.oneOf());
        basket.add(product.oneOf());
        basket.add(product.oneOf());

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer();
        BigDecimal discount = offer.discountFor(basket);
        assertEquals(expectedDiscount, discount);
    }

}