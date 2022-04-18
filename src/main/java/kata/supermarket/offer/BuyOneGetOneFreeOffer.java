package kata.supermarket.offer;

import kata.supermarket.Basket;

import java.math.BigDecimal;

public class BuyOneGetOneFreeOffer implements Offer {
    @Override
    public BigDecimal discountFor(Basket basket) {
        return new BigDecimal("0.00");
    }
}
