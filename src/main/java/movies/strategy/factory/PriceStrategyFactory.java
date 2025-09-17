package movies.strategy.factory;

import movies.domain.models.MovieType;
import movies.strategy.pricing.ChildrenPriceStrategy;
import movies.strategy.pricing.NewReleasePriceStrategy;
import movies.strategy.pricing.PriceStrategy;
import movies.strategy.pricing.RegularPriceStrategy;

public class PriceStrategyFactory {
    public static PriceStrategy getStrategy(MovieType movieType) {
        switch (movieType) {
            case REGULAR:
                return new RegularPriceStrategy();
            case NEW_RELEASE:
                return new NewReleasePriceStrategy();
            case CHILDREN: 
                return new ChildrenPriceStrategy();
            default:
                throw new IllegalArgumentException();
        }
    }
}
