
import models.Director;
import models.Film;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {


    Film film;
    Director director;

    @Before
    public void before() {
        film = new Film("Terminator");
        director = new Director("Maven Gradle", 0, film);
    }


    @Test
    public void canGetName() {
        assertEquals("Maven Gradle", director.getName());
    }

    @Test
    public void canGetCurrentPay() {
        assertEquals(0, director.getCurrent_pay());
    }

    @Test
    public void canGetAssignedFilms() {
        assertEquals(film, director.getAssigned_films());
    }
}
