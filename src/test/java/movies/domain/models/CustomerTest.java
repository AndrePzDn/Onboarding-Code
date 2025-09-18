package movies.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CustomerTest {
    private Customer customer;
    private Movie movie;
    private Rental rental;

    @BeforeEach
    public void setup() {
        customer = new Customer("Test");
        movie = new Movie("Test", 0);
        rental = new Rental(movie, 1);
    }

    @Test
    public void testAddRental() {
        customer.addRental(rental);

        List<Rental> expectedList = new ArrayList<>();
        expectedList.add(rental);

        assertIterableEquals(expectedList, customer.getRentals());
    }

    @Test
    public void testAddRentalThrowIllegalArgumentExceptionForInvalidRental() {

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> customer.addRental(null));

        assertEquals("Invalid Rental", thrown.getMessage());
    }

    @Test
    public void testGetName() {
        String expectedName = "Test";
        assertEquals(expectedName, customer.getName());
    }

    @Test
    public void testGetRentals() {
        customer.addRental(rental);
        customer.addRental(rental);
        customer.addRental(rental);

        List<Rental> expectedList = new ArrayList<>();

        expectedList.add(rental);
        expectedList.add(rental);
        expectedList.add(rental);

        assertIterableEquals(expectedList, customer.getRentals());
    }

    @Test
    public void testGetRentalsIfTheListIsEmpty() {
        assertTrue(customer.getRentals().isEmpty());
    }

    @Test
    public void testStatementWithoutItems() {
        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for Test")
                .append("\n")
                .append("Amount owed is 0.0")
                .append("\n")
                .append("You earned 0 frequent renter points");

        assertEquals(expectedStatement.toString(), customer.statement());
    }

    @Test
    public void testStatementWithItems() {
        customer.addRental(rental);

        StringBuilder expectedStatement = new StringBuilder();
        expectedStatement.append("Rental Record for Test")
                .append("\n")
                .append("\t")
                .append("Test")
                .append("\t")
                .append("2.0")
                .append("\n")
                .append("Amount owed is 2.0")
                .append("\n")
                .append("You earned 0 frequent renter points");

        assertEquals(expectedStatement.toString(), customer.statement());
    }

    @Test
    public void testIllegalArgumentExceptionIsThrowWithNullName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Customer(null));
        assertEquals("Invalid Customer Name", thrown.getMessage());
    }

    @Test
    public void testIllegalArgumentExceptionIsThrowWithEmptyName() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Customer(""));
        assertEquals("Invalid Customer Name", thrown.getMessage());
    }

    @AfterEach
    public void tearDown() {
        customer = null;
        movie = null;
        rental = null;
    }
}
