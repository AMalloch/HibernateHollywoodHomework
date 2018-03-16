

import models.Film;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    private Film film;

    @Before
    public void before() {
        film = new Film("Terminator");
    }

    @Test
    public void canGetName() {
        assertEquals("Terminator", film.getName());
    }

    @Test
    public void canSetName() {
        film.setName("Terminator Genesis");
        assertEquals("Terminator Genesis", film.getName());
    }
}
