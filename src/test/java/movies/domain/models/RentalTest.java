package movies.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RentalTest {
    public Movie movie;
    public Rental rental;

    @BeforeEach
    void setup() {
        movie = new Movie("Test Movie", 0);
        rental = new Rental(movie, 1);
    }

    @Test
    void testGetDaysRented() {
        int expectedDaysRented = 1;
        assertEquals(expectedDaysRented, rental.getDaysRented());
    }

    @Test
    void testGetMovie() {
        assertEquals(movie, rental.getMovie());
    }

    @Test
    void testIllegalArgumentExceptionIsThrowWithZeroDaysRented() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Rental(movie, 0));
        assertEquals("Invalid rented days", thrown.getMessage());
    }

    @Test
    void testIllegalArgumentExceptionIsThrowWithNegativeDaysRented() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Rental(movie, -1));
        assertEquals("Invalid rented days", thrown.getMessage());
    }

    @Test
    void testIllegalArgumentExceptionIsThrowWithNullMovie() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Rental(null, 1));
        assertEquals("Invalid Movie", thrown.getMessage());
    }

    @AfterEach
    void teardown() {
        rental = null;
        movie = null;
    }
}
