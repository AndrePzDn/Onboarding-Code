package movies.domain.valueobjects;

import java.util.ArrayList;
import java.util.List;

public class RentalCalculatorResult {
    private double totalAmount;
    private int frequentRenterPoints;
    private List<RentalLineItem> lineItems;

    public RentalCalculatorResult(double totalAmount, int frequentRenterPoints, List<RentalLineItem> lineItems) {
        this.totalAmount = totalAmount;
        this.frequentRenterPoints = frequentRenterPoints;
        this.lineItems = new ArrayList<>(lineItems);
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public int getFrequentRenterPoints() {
        return frequentRenterPoints;
    }

    public List<RentalLineItem> getLineItems() {
        return lineItems;
    }
}
