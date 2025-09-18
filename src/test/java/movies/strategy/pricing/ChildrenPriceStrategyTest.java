package movies.strategy.pricing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ChildrenPriceStrategyTest {
    private final double BASE_PRICE = 1.5;
    private final double ADDITIONAL_PRICE = 1.5;
    private final int FREE_DAYS = 3;

    ChildrenPriceStrategy childrenPriceStrategy;

    @BeforeEach
    void setup() {
        childrenPriceStrategy = new ChildrenPriceStrategy();
    }

    @Test
    void testCalculateAmount() {
        double expectedAmount = BASE_PRICE;

        assertEquals(expectedAmount, childrenPriceStrategy.calculateAmount(2));
    }

    @Test
    void testCalculateAmountWithFreeDaysAsntedDays() {
        double expectedAmount = BASE_PRICE;

        assertEquals(expectedAmount, childrenPriceStrategy.calculateAmount(FREE_DAYS));
    }

    @Test
    void testCalculateAmountWithTwoMoreDaysThanFreeDaysRented() {
        double expectedAmount = BASE_PRICE + (ADDITIONAL_PRICE * 2);

        assertEquals(expectedAmount, childrenPriceStrategy.calculateAmount(FREE_DAYS + 2));
    }

    @Test
    void testCalculateFrequentRenterPoints() {
        int expectedRenterPoints = 1;

        assertEquals(expectedRenterPoints, childrenPriceStrategy.calculateFrequentRenterPoints(1));
    }

    @Test
    void testCalculateFrequentRenterPointsWithMoreThanFreeDays() {
        int expectedRenterPoints = 1;

        assertEquals(expectedRenterPoints, childrenPriceStrategy.calculateFrequentRenterPoints(FREE_DAYS));
    }

    @AfterEach
    void teardown() {
        childrenPriceStrategy = null;
    }
}
