
import db.DBHelper;
import models.Actor;
import models.Actress;
import models.Film;
import models.Studio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActressTest {

    Studio studio;
    Film film;
    Film film2;
    Actress actress;
    Actress actress2;
    Actress actress3;

    @Before
    public void before() {
        studio = new Studio("Hollywood Studio", 20000000);
        DBHelper.saveOrUpdate(studio);
        film = new Film("Terminator", studio, "Thriller");
        DBHelper.saveOrUpdate(film);
        film2 = new Film("Frozen", studio, "Horror");
        DBHelper.saveOrUpdate(film2);
        actress = new Actress("Samantha Crinklecut", 0, film, studio);
        DBHelper.saveOrUpdate(actress);
        actress2 = new Actress("Anna Kell", 0, film, studio);
        DBHelper.saveOrUpdate(actress2);
        actress3 = new Actress("Losi McPol", 0, film, studio);
        DBHelper.saveOrUpdate(actress3);
    }

    @After
    public void tearDown(){
        DBHelper.delete(actress);
        DBHelper.delete(actress2);
        DBHelper.delete(actress3);
        DBHelper.delete(film);
        DBHelper.delete(film2);
        DBHelper.delete(studio);
    }


    @Test
    public void canGetName() {
        assertEquals("Samantha Crinklecut", actress.getName());
    }

    @Test
    public void canGetCurrentPay() {
        assertEquals(0, actress.getCurrent_pay());
    }

    @Test
    public void canGetAssignedFilms() {
        assertEquals(film, actress.getFilm());
    }

    @Test
    public void canSetName() {
        actress.setName("Sarah Milo");
        assertEquals("Sarah Milo", actress.getName());
    }

    @Test
    public void canSetCurrentPay() {
        actress.setCurrent_pay(100000);
        assertEquals(100000, actress.getCurrent_pay());
    }

    @Test
    public void canSetFilm() {
        actress.setFilm(film2);
        assertEquals(film2, actress.getFilm());
    }

    @Test
    public void canSave(){
        Actress foundActress = DBHelper.find(Actress.class, actress.getId());
        assertEquals("Samantha Crinklecut", foundActress.getName());
    }

    @Test
    public void canDelete(){
        DBHelper.delete(actress2);
        java.util.List<Object> actressList = DBHelper.getAll(Actress.class);
        assertEquals(2, actressList.size());
    }

}
