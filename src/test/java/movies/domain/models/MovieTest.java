package movies.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MovieTest {
    private Movie movie;

    @BeforeEach
    void setup() {
        movie = new Movie("Test", 0);
    }

    @Test
    void testGetPriceCodeForRegularMovies() {
        assertEquals(MovieType.REGULAR, movie.getPriceCode());
    }

    @Test
    void testGetPriceCodeForNewReleaseMovies() {
        movie.setPriceCode(1);
        assertEquals(MovieType.NEW_RELEASE, movie.getPriceCode());
    }

    @Test
    void testGetPriceCodeForChildrenMovies() {
        movie.setPriceCode(2);
        assertEquals(MovieType.CHILDREN, movie.getPriceCode());
    }

    @Test
    void testGetTitle() {
        String expectedTitle = "Test";
        assertEquals(expectedTitle, movie.getTitle());
    }

    @Test
    void testSetPriceCode() {
        movie.setPriceCode(1);
        assertEquals(MovieType.NEW_RELEASE, movie.getPriceCode());
    }

    @Test
    void testIllegalArgumentExceptionIsThrowWhenInstantiateWithEmptyTitle() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Movie("", 0));

        assertEquals("Invalid Movie Name", thrown.getMessage());
    }

    @Test
    void testIllegalArgumentExceptionIsThrowWhenInstantiateWithNullTitle() {
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> new Movie(null, 0));

        assertEquals("Invalid Movie Name", thrown.getMessage());
    }

    @AfterEach
    void teardown() {
        movie = null;
    }
}
