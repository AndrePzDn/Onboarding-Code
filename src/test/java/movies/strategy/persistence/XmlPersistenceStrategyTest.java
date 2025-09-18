package movies.strategy.persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import movies.domain.models.Movie;
import movies.domain.models.MovieType;

public class XmlPersistenceStrategyTest {
    String testFilePath = "./testMovie.xml";
    XmlPersistenceStrategy<Movie> xmlPersistenceStrategy;
    Movie testMovie;

    @BeforeEach
    void setup() {
        xmlPersistenceStrategy = new XmlPersistenceStrategy<>();
        testMovie = new Movie("Test", 0);
    }

    @Test
    void testSaveStoresTitle() throws Exception {
        xmlPersistenceStrategy.save(testMovie, testFilePath);
        String expectedResult = "Test";

        assertEquals(expectedResult,
                ((Movie) xmlPersistenceStrategy.load(testFilePath, Movie.class)).getTitle());
    }

    @Test
    void testSaveStoresPriceCode() throws Exception {
        xmlPersistenceStrategy.save(testMovie, testFilePath);

        assertEquals(MovieType.REGULAR,
                ((Movie) xmlPersistenceStrategy.load(testFilePath, Movie.class)).getPriceCode());
    }

    @Test
    void testSavesHaveCorrectFormatJSON() throws Exception {
        xmlPersistenceStrategy.save(testMovie, testFilePath);
        StringBuilder expectedResult = new StringBuilder();
        expectedResult.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("\n")
                .append("<movie>")
                .append("\n")
                .append("    <title>Test</title>")
                .append("\n")
                .append("    <priceCode>REGULAR</priceCode>")
                .append("\n")
                .append("</movie>")
                .append("\n");

        String result = new String(Files.readAllBytes(Paths.get(testFilePath)));

        assertEquals(expectedResult.toString(), result);
    }

    @Test
    void testLoadGetCorrectClassOfObject() {
        xmlPersistenceStrategy.save(testMovie, testFilePath);
        assertEquals(Movie.class, xmlPersistenceStrategy.load(testFilePath, Movie.class).getClass());
    }

    @Test
    void testLoadIfFileDoesNotExistsReturnsNull() {
        assertNull(xmlPersistenceStrategy.load("fakeFile.json", Movie.class));
    }

    @AfterEach
    void teardown() {
        xmlPersistenceStrategy = null;
        File file = new File(testFilePath);
        file.delete();
    }
}
