package kata.supermarket.offer;

import kata.supermarket.Basket;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuyOneGetOneFreeOfferTest {

    @Test
    void buysOneGetsOneFreeDoesNotApplyOnEmptyBasket() {
        Basket basket = new Basket();

        BuyOneGetOneFreeOffer offer = new BuyOneGetOneFreeOffer();
        BigDecimal discount = offer.discountFor(basket);
        assertEquals(new BigDecimal("0.00"), discount);
    }

}