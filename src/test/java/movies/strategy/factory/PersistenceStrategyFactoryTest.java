package movies.strategy.factory;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import movies.domain.models.PersistenceType;
import movies.domain.valueobjects.CustomerRecord;
import movies.strategy.persistence.JsonPersistenceStrategy;
import movies.strategy.persistence.LocalPersistenceStrategy;
import movies.strategy.persistence.XmlPersistenceStrategy;

public class PersistenceStrategyFactoryTest {
    @Test
    void testGetStrategyForJsonStrategy() {
        PersistenceType JsonPersistenceType = PersistenceType.JSON;
        LocalPersistenceStrategy<CustomerRecord> expectedStrategy = new JsonPersistenceStrategy<>();

        assertEquals(expectedStrategy.getClass(),
                PersistenceStrategyFactory.getStrategy(JsonPersistenceType).getClass());
    }

    @Test
    void testGetStrategyForXmlStrategy() {
        PersistenceType XmlPersistenceType = PersistenceType.XML;
        LocalPersistenceStrategy<CustomerRecord> expectedStrategy = new XmlPersistenceStrategy<>();

        assertEquals(expectedStrategy.getClass(),
                PersistenceStrategyFactory.getStrategy(XmlPersistenceType).getClass());
    }
}
