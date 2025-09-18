package movies.domain.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElementWrapper;
import movies.domain.valueobjects.RentalCalculatorResult;
import movies.services.RentalCalculator;
import movies.services.TextFormatter;

public class Customer {
    private final transient RentalCalculator calculator = new RentalCalculator();
    private final transient TextFormatter formatter = new TextFormatter();

    @XmlElement
    private String name;

    @XmlElementWrapper(name = "rentals")
    @XmlElement(name = "rental")
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer() { }

    public Customer(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid Customer Name");
        }
        this.name = name;
    }

    public void addRental(Rental newRental) {
        if (newRental == null) {
            throw new IllegalArgumentException("Invalid Rental");
        }
        rentals.add(newRental);
    }

    public String getName() {
        return name;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    public String statement() {
        RentalCalculatorResult result = calculator.calculateRentalsList(rentals);
        return formatter.formatStatement(name, result);
    }
}
