package movies.domain.valueobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RentalLineItemTest {
    RentalLineItem rentalLineItem;

    @BeforeEach
    void setup() {
        rentalLineItem = new RentalLineItem("Test", 0);
    }

    @Test
    void testGetAmount() {
        assertEquals(0, rentalLineItem.getAmount());
    }

    @Test
    void testGetMovieTitle() {
        assertEquals("Test", rentalLineItem.getMovieTitle());
    }

    @Test
    void testIllegalArgumentExceptionThrowsIfMovieTitleIsEmpty() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new RentalLineItem("", 0));
        assertEquals("Invalid Movie Title", thrown.getMessage());
    }

    @Test
    void testIllegalArgumentExceptionThrowsIfMovieTitleIsNull() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new RentalLineItem(null, 0));
        assertEquals("Invalid Movie Title", thrown.getMessage());
    }

    @Test
    void testIllegalArgumentExceptionThrowsWhenAmountIsNegative() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new RentalLineItem("Test", -1));
        assertEquals("Invalid Amount", thrown.getMessage());
    }

    @AfterEach
    void teardown() {
        rentalLineItem = null;
    }
}
