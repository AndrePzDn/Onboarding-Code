package movies.strategy.pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegularPriceStrategyTest {
    private final double BASE_PRICE = 2;
    private final double ADDITIONAL_PRICE = 1.5;
    private final int FREE_DAYS = 2;

    RegularPriceStrategy regularPriceStrategy;

    @BeforeEach
    void setup() {
        regularPriceStrategy = new RegularPriceStrategy();
    }

    @Test
    void testCalculateAmount() {
        double expectedAmount = BASE_PRICE;

        assertEquals(expectedAmount, regularPriceStrategy.calculateAmount(2));
    }

    @Test
    void testCalculateAmountWithFreeDaysAsntedDays() {
        double expectedAmount = BASE_PRICE;

        assertEquals(expectedAmount, regularPriceStrategy.calculateAmount(FREE_DAYS));
    }

    @Test
    void testCalculateAmountWithTwoMoreDaysThanFreeDaysRented() {
        double expectedAmount = BASE_PRICE + (ADDITIONAL_PRICE * 2);

        assertEquals(expectedAmount, regularPriceStrategy.calculateAmount(FREE_DAYS + 2));
    }

    @Test
    void testCalculateFrequentRenterPoints() {
        int expectedRenterPoints = 0;

        assertEquals(expectedRenterPoints, regularPriceStrategy.calculateFrequentRenterPoints(1));
    }

    @Test
    void testCalculateFrequentRenterPointsWithMoreThanFreeDays() {
        int expectedRenterPoints = 0;

        assertEquals(expectedRenterPoints, regularPriceStrategy.calculateFrequentRenterPoints(FREE_DAYS));
    }

    @AfterEach
    void teardown() {
        regularPriceStrategy = null;
    }
}
