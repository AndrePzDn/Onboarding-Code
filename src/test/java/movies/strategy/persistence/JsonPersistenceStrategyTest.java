package movies.strategy.persistence;

import java.io.FileReader;
import java.io.Reader;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import movies.domain.models.Movie;

public class JsonPersistenceStrategyTest {
    JsonPersistenceStrategy<Movie> jsonPersistenceStrategy;
    Movie movie;
    String testFilePath = "./testMovie.json";

    @BeforeEach
    void setup() {
        jsonPersistenceStrategy = new JsonPersistenceStrategy<>();
        movie = new Movie("Test", 1);
    }

    @Test
    void testSave() {
        jsonPersistenceStrategy.save(movie, testFilePath);
        try (Reader reader = new FileReader(testFilePath)) {

        } catch (Exception e) {

        }
    }

    @Test
    void testLoad() {

    }

    @Test
    void testLoadIfFileDoesNotExistsThrowIOException() {

    }

    @AfterEach
    void teardown() {
        jsonPersistenceStrategy = null;
        // File file = new File(testFilePath);
        // file.delete();
    }
}
