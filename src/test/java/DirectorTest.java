
import db.DBHelper;
import models.Actress;
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

        studio = new Studio("Hollywood Studio", 20000000);
        DBHelper.saveOrUpdate(studio);
        film = new Film("Terminator", studio);
        DBHelper.saveOrUpdate(film);
        film2 = new Film("Frozen", studio);
        DBHelper.saveOrUpdate(film2);
        director = new Director("Maven Gradle", 0, film, studio);
        DBHelper.saveOrUpdate(director);

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

    @Test
    public void canSave(){
        Director foundDirector = DBHelper.find(Director.class, director.getId());
        assertEquals("Maven Gradle", foundDirector.getName());
    }

}
