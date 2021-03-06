import db.DBHelper;
import models.Film;
import models.Studio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class FilmTest {

    Studio studio;
    Film film;
    Film film1;

    @Before
    public void before() {
        studio = new Studio("Hollywood Studios", 20000000);
        DBHelper.saveOrUpdate(studio);
        film = new Film("Terminator", studio, "Thriller");
        DBHelper.saveOrUpdate(film);
        film1 = new Film("Doomsday", studio, "Comedy");
        DBHelper.saveOrUpdate(film1);
    }

    @After
    public void tearDown(){
        DBHelper.delete(film);
        DBHelper.delete(film1);
        DBHelper.delete(studio);
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

    @Test
    public void canSave(){
        Film foundFilm = DBHelper.find(Film.class, film.getId());
        assertEquals("Terminator", foundFilm.getName());
    }

    @Test
    public void canDelete(){
        DBHelper.delete(film1);
        java.util.List<Object> filmList = DBHelper.getAll(Film.class);
        assertEquals(1, filmList.size());
    }
}
