package movies.services;

import movies.domain.models.PersistenceType;
import movies.strategy.factory.PersistenceStrategyFactory;
import movies.strategy.persistence.LocalPersistenceStrategy;

public class DataManager<T> {
    private LocalPersistenceStrategy<T> strategy;
    private String filePath;
    private Class<?> classOfT;

    public DataManager(PersistenceType persistenceType, String filePath, Class<?> classOfT) {
        this.strategy = PersistenceStrategyFactory.getStrategy(persistenceType);
        this.filePath = filePath;
        this.classOfT = classOfT;
    }

    public void save(T data) {
        this.strategy.save(data, filePath);
    }

    public T load() {
        return this.strategy.load(filePath, classOfT);
    }
}
