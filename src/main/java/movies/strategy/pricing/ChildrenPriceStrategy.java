package movies.strategy.pricing;
public class ChildrenPriceStrategy implements PriceStrategy {
    private final double BASE_PRICE = 1.5;
    private final double ADDITIONAL_PRICE = 1.5;
    private final int FREE_DAYS = 3;

    @Override
    public double calculateAmount(int daysRented) {
        double amount = BASE_PRICE;
        if (daysRented > FREE_DAYS) {
            int additionalDays = daysRented - FREE_DAYS;
            amount = amount + (additionalDays * ADDITIONAL_PRICE);
        }
        return amount;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        return 1;
    }
    
}
