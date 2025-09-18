package movies.strategy.factory;

import movies.domain.models.PersistenceType;
import movies.strategy.persistence.JsonPersistenceStrategy;
import movies.strategy.persistence.LocalPersistenceStrategy;
import movies.strategy.persistence.XmlPersistenceStrategy;

public class PersistenceStrategyFactory {
    public static <T> LocalPersistenceStrategy<T> getStrategy(PersistenceType persistenceType) {
        switch (persistenceType) {
            case JSON:
                return new JsonPersistenceStrategy<>();
            case XML:
                return new XmlPersistenceStrategy<>();
            default:
                throw new IllegalArgumentException();
        }
    }
}
