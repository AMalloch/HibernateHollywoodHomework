
import models.Director;
import models.Film;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {


    Film film;
    Film film2;
    Director director;

    @Before
    public void before() {
        film = new Film("Terminator");
        film2 = new Film("Frozen");
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

    @Test
    public void canSetName() {
        director.setName("Steven Spielberg");
        assertEquals("Steven Spielberg", director.getName());
    }

    @Test
    public void canSetCurrentPay() {
        director.setCurrent_pay(100000);
        assertEquals(100000, director.getCurrent_pay());
    }

    @Test
    public void canSetFilm() {
        director.setAssigned_films(film2);
        assertEquals(film2, director.getAssigned_films());
    }

}
