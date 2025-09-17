package movies.strategy.persistence;

public interface LocalPersistenceStrategy<T> {
    void save(T data, String filePath, Class<?> classOfT);
    T load(String filePath, Class<?> classOfT);
}
