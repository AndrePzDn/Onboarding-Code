package movies.domain.valueobjects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RentalCalculatorResultTest {
    List<RentalLineItem> rentalLineItemsList;
    RentalLineItem rentalLineItem;
    RentalCalculatorResult rentalCalculatorResult;

    @BeforeEach
    void setup() {
        rentalLineItemsList = new ArrayList<>();
        rentalLineItem = new RentalLineItem("Test", 10);
        rentalLineItemsList.add(rentalLineItem);
        rentalCalculatorResult = new RentalCalculatorResult(0, 0, rentalLineItemsList);
    }

    @Test
    void testGetFrequentRenterPoints() {
        assertEquals(0, rentalCalculatorResult.getFrequentRenterPoints());
    }

    @Test
    void testGetTotalAmount() {
        assertEquals(0, rentalCalculatorResult.getTotalAmount());
    }

    @Test
    void testGetTotalAmountWithDecimals() {
        rentalCalculatorResult = new RentalCalculatorResult(5.21, 0, rentalLineItemsList);
        assertEquals(5.21, rentalCalculatorResult.getTotalAmount());
    }

    @Test
    void testGetLineItems() {
        List<RentalLineItem> expectedList = new ArrayList<>();
        expectedList.add(rentalLineItem);

        assertIterableEquals(expectedList, rentalCalculatorResult.getLineItems());
    }

    @AfterEach
    void teardown() {

    }
}
