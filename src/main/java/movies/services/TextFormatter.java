package movies.services;

import movies.domain.valueobjects.RentalCalculatorResult;
import movies.domain.valueobjects.RentalLineItem;

public class TextFormatter {
    public String formatStatement(String name, RentalCalculatorResult result) {
        StringBuilder statement = new StringBuilder();
        statement.append("Rental Record for ").append(name).append("\n");

        for (RentalLineItem item: result.getLineItems()) {
            statement.append("\t")
                .append(item.getMovieTitle())
                .append("\t")
                .append(item.getAmount())
                .append("\n");
        }

        statement.append("Amount owed is ")
            .append(result.getTotalAmount())
            .append( "\n")
            .append("You earned ")
            .append(result.getFrequentRenterPoints())
            .append(" frequent renter points");

        return statement.toString();
    }
}
