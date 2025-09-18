package movies.strategy.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

import movies.domain.models.Movie;

public class JsonPersistenceStrategyTest {
    JsonPersistenceStrategy<Movie> jsonPersistenceStrategy;
    Movie movie;
    String testFilePath = "./testMovie.json";
    Gson gson;

    @BeforeEach
    void setup() {
        jsonPersistenceStrategy = new JsonPersistenceStrategy<>();
        movie = new Movie("Test", 1);
        gson = new Gson();
    }

    @Test
    void testSaveStoresTitle() throws Exception {
        jsonPersistenceStrategy.save(movie, testFilePath);
        Reader reader = new FileReader(testFilePath);
        Movie result = gson.fromJson(reader, Movie.class);

        assertEquals(movie.getTitle(), result.getTitle());
    }

    @Test
    void testSaveStoresPriceCode() throws Exception {
        jsonPersistenceStrategy.save(movie, testFilePath);
        Reader reader = new FileReader(testFilePath);
        Movie result = gson.fromJson(reader, Movie.class);

        assertEquals(movie.getPriceCode(), result.getPriceCode());
    }

    @Test
    void testSavesHaveCorrectFormatJSON() throws Exception {
        jsonPersistenceStrategy.save(movie, testFilePath);
        // String expectedResult = "{\n\n\n}";
        StringBuilder expectedResult = new StringBuilder();
        expectedResult
                .append("{")
                .append("\n")
                .append("  \"title\": \"Test\",")
                .append("\n")
                .append("  \"priceCode\": \"NEW_RELEASE\"")
                .append("\n")
                .append("}");

        String result = new String(Files.readAllBytes(Paths.get(testFilePath)));

        assertEquals(expectedResult.toString(), result);
    }

    @Test
    void testLoadGetCorrectClassOfObject() {
        jsonPersistenceStrategy.save(movie, testFilePath);
        assertEquals(Movie.class, jsonPersistenceStrategy.load(testFilePath, Movie.class).getClass());
    }

    @Test
    void testLoadIfFileDoesNotExistsReturnsNull() {
        assertNull(jsonPersistenceStrategy.load("fakeFile.json", Movie.class));
    }

    @AfterEach
    void teardown() {
        jsonPersistenceStrategy = null;
        File file = new File(testFilePath);
        file.delete();
    }
}
