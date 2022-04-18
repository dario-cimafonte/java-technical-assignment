# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

I focussed on BOGOF being a simple candidate to implement offers at large.

I decided that discounts would be represented as negative values and added just like we add charges, rather
than maintaining a add/subtract duality that would increase complexity for no apparent gain.

I would consider decoupling the basket valuation logic (TotalCalculator) from the Basket itself,
so that the activeOffers would not be a concern of the Basket (which is a design smell) but of
the TotalCalculator instead, so that more flexibility can be given around which offers are 
enabled at a given time and for a given customer.

At that stage, we would separate model from services into appropriately named packages.

Also, ItemByUnit.product() would most likely be promoted to Item.product() when we get to implement
offers that apply to weighted products.
