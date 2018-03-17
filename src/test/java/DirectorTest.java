
import models.Director;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {

    Studio studio;
    Film film;
    Film film2;
    Director director;

    @Before
    public void before() {
        studio = new Studio("Hollywood Studios", 20000000);
        film = new Film("Terminator", studio);
        film2 = new Film("Frozen", studio);
        director = new Director("Maven Gradle", 0, film, studio);
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
        assertEquals(film, director.getFilm());
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
        director.setFilm(film2);
        assertEquals(film2, director.getFilm());
    }

}
