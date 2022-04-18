package kata.supermarket;

import kata.supermarket.offer.Offer;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Product {

    private final BigDecimal pricePerUnit;
    private final List<Class<?>> eligibleOffers;

    public Product(final BigDecimal pricePerUnit, Class<?>... eligibleOffers) {
        this.pricePerUnit = pricePerUnit;
        this.eligibleOffers = Arrays.asList(eligibleOffers);
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this);
    }

    public boolean isEligibleFor(Class<? extends Offer> offerClass) {
        return eligibleOffers.contains(offerClass);
    }
}
