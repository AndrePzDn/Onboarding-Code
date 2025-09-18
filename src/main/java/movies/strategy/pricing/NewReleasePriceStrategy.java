package movies.strategy.pricing;
public class NewReleasePriceStrategy implements PriceStrategy {
    private final double BASE_PRICE = 3;

    @Override
    public double calculateAmount(int daysRented) {
        return daysRented * BASE_PRICE;
    }

    @Override
    public int calculateFrequentRenterPoints(int daysRented) {
        if (daysRented > 1) {
            return 2;
        }
        return 1;
    }

}
