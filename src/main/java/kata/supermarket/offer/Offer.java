package kata.supermarket.offer;

import kata.supermarket.Basket;

import java.math.BigDecimal;

public interface Offer {
    BigDecimal discountFor(Basket basket);
}
