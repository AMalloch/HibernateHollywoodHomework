

import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    Studio studio;
    Film film;

    @Before
    public void before() {
        studio = new Studio("Hollywood Studios", 20000000);
        film = new Film("Terminator", studio);
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
