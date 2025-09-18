package movies.strategy.pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NewReleasePriceStrategyTest {
    private final double BASE_PRICE = 3;

    NewReleasePriceStrategy newReleasePriceStrategy;

    @BeforeEach
    void setup() {
        newReleasePriceStrategy = new NewReleasePriceStrategy();
    }

    @Test
    void testCalculateAmount() {
        int daysRented = 2;
        double expectedAmount = BASE_PRICE * daysRented;

        assertEquals(expectedAmount, newReleasePriceStrategy.calculateAmount(daysRented));
    }

    @Test
    void testCalculateFrequentRenterPointsWithOneDayRented() {
        int expectedRenterPoints = 1;

        assertEquals(expectedRenterPoints, newReleasePriceStrategy.calculateFrequentRenterPoints(1));
    }

    @Test
    void testCalculateFrequentRenterPointsWithMoreThanOneDay() {
        int expectedRenterPoints = 2;

        assertEquals(expectedRenterPoints, newReleasePriceStrategy.calculateFrequentRenterPoints(2));
    }

    @AfterEach
    void teardown() {
        newReleasePriceStrategy = null;
    }
}
