package kata.supermarket.offer;

import kata.supermarket.Basket;
import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BuyOneGetOneFreeOffer implements Offer {

    private static final BigDecimal NO_DISCOUNT = new BigDecimal("0.00");

    @Override
    public BigDecimal discountFor(Basket basket) {
        List<Item> items = basket.items();
        Map<Product, Long> countByProduct = items.stream()
                .filter(item -> item instanceof ItemByUnit)
                .map(item -> (ItemByUnit) item)
                .filter(item -> item.product().isEligibleFor(this.getClass()))
                .collect(Collectors.groupingBy(ItemByUnit::product, Collectors.counting()));

        return countByProduct.entrySet().stream()
                .map(entry -> entry.getKey().oneOf().price().multiply(BigDecimal.valueOf(entry.getValue() / 2L)))
                .map(BigDecimal::negate)
                .reduce(NO_DISCOUNT, BigDecimal::add);
    }
}
