package movies.domain.valueobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import movies.domain.models.Customer;
import movies.domain.models.Movie;
import movies.domain.models.Rental;

public class CustomerRecordTest {
    CustomerRecord customerRecord;
    Customer customer;
    Rental rental;
    Movie movie;

    @BeforeEach
    void setup() {
        customerRecord = CustomerRecord.getInstance();
        customer = new Customer("Test Customer");
        movie = new Movie("Test Movie", 0);
        rental = new Rental(movie, 1);
    }

    @Test
    void testAddCustomer() {
        customerRecord.add(customer);

        List<Customer> expectedList = new ArrayList<>();
        expectedList.add(customer);

        assertIterableEquals(expectedList, customerRecord.customers);
    }

    @Test
    void testAddCustomerWithRentals() {
        customer.addRental(rental);
        customerRecord.add(customer);

        List<Customer> expectedList = new ArrayList<>();
        expectedList.add(customer);

        assertIterableEquals(expectedList, customerRecord.customers);
    }

    @Test
    void testAddCustomerTwiceShouldInsertOne() {
        customerRecord.add(customer);
        customerRecord.add(customer);

        List<Customer> expectedList = new ArrayList<>();
        expectedList.add(customer);

        assertIterableEquals(expectedList, customerRecord.customers);
    }

    @Test
    void testAddCustomersWithDifferentNamesAndRentals() {
        customer.addRental(rental);
        customerRecord.add(customer);

        Customer newCustomer = new Customer("Test Customer 2");
        newCustomer.addRental(rental);
        customerRecord.add(newCustomer);

        List<Customer> expectedList = new ArrayList<>();
        Customer expectedCustomer = new Customer("Test Customer");
        expectedCustomer.addRental(rental);
        expectedList.add(expectedCustomer);
        expectedList.add(customer);

        assertEquals(expectedList.size(), customerRecord.customers.size());
    }

    @Test
    void testAddCustomersWithSameNameAndRentals() {
        customer.addRental(rental);
        customerRecord.add(customer);

        Customer newCustomer = new Customer("Test Customer");
        newCustomer.addRental(rental);
        customerRecord.add(newCustomer);

        List<Customer> expectedList = new ArrayList<>();
        Customer expectedCustomer = new Customer("Test Customer");
        expectedCustomer.addRental(rental);
        expectedCustomer.addRental(rental);
        expectedList.add(expectedCustomer);

        assertEquals(expectedList.size(), customerRecord.customers.size());
    }

    @Test
    void testGeneralStatement() {
        customerRecord.add(customer);

        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for Test Customer")
                .append("\n")
                .append("Amount owed is 0.0")
                .append("\n")
                .append("You earned 0 frequent renter points")
                .append("\n")
                .append("==========================================")
                .append("\n");

        assertEquals(expectedStatement.toString(), customerRecord.generalStatement());
    }

    @AfterEach
    void teardown() {
        customerRecord.customers.clear();
        customer = null;
        movie = null;
        rental = null;
    }
}
