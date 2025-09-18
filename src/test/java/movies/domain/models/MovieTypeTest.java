package movies.domain.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import movies.exceptions.InvalidPriceCodeException;

public class MovieTypeTest {
    @Test
    void testFromCodeGetMovieType() {
        assertEquals(MovieType.REGULAR, MovieType.fromCode(0));
    }

    @Test
    void testFromCodeMethodThrowsInvalidPriceCodeExceptionWithAnInvalidPriceCode() {
        InvalidPriceCodeException thrown = assertThrows(InvalidPriceCodeException.class, () -> MovieType.fromCode(99));

        assertEquals("Invalid Movie Code", thrown.getMessage());
    }
}
