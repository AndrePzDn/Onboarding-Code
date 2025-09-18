package movies.strategy.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import movies.domain.models.MovieType;
import movies.strategy.pricing.ChildrenPriceStrategy;
import movies.strategy.pricing.NewReleasePriceStrategy;
import movies.strategy.pricing.PriceStrategy;
import movies.strategy.pricing.RegularPriceStrategy;

public class PriceStrategyFactoryTest {
    @Test
    void testGetStrategyForRegularPricing() {
        MovieType regularMovieType = MovieType.REGULAR;
        PriceStrategy expectedPricing = new RegularPriceStrategy();

        assertEquals(expectedPricing.getClass(), PriceStrategyFactory.getStrategy(regularMovieType).getClass());
    }

    @Test
    void testGetStrategyForNewReleasePricing() {
        MovieType regularMovieType = MovieType.NEW_RELEASE;
        PriceStrategy expectedPricing = new NewReleasePriceStrategy();

        assertEquals(expectedPricing.getClass(), PriceStrategyFactory.getStrategy(regularMovieType).getClass());
    }

    @Test
    void testGetStrategyForChildrenPricing() {
        MovieType regularMovieType = MovieType.CHILDREN;
        PriceStrategy expectedPricing = new ChildrenPriceStrategy();

        assertEquals(expectedPricing.getClass(), PriceStrategyFactory.getStrategy(regularMovieType).getClass());
    }
}
