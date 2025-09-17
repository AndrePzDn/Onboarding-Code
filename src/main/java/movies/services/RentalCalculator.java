package movies.services;

import java.util.ArrayList;
import java.util.List;

import movies.domain.valueobjects.RentalCalculatorResult;
import movies.domain.valueobjects.RentalLineItem;
import movies.domain.models.MovieType;
import movies.domain.models.Rental;
import movies.strategy.factory.PriceStrategyFactory;
import movies.strategy.pricing.PriceStrategy;

public class RentalCalculator {
    public RentalCalculatorResult calculateRentalsList(List<Rental> rentals) {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        ArrayList<RentalLineItem> lineItems = new ArrayList<>();

        for (Rental rental: rentals) {
            MovieType moviePriceCode = rental.getMovie().getPriceCode();
            PriceStrategy strategy = PriceStrategyFactory.getStrategy(moviePriceCode);

            double amount = strategy.calculateAmount(rental.getDaysRented());
            int points = strategy.calculateFrequentRenterPoints(rental.getDaysRented());

            totalAmount += amount;
            frequentRenterPoints += points;

            lineItems.add(new RentalLineItem(rental.getMovie().getTitle(), amount));
        }

        return new RentalCalculatorResult(totalAmount, frequentRenterPoints, lineItems);
    }
}
