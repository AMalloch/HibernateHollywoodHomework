
import db.DBHelper;
import models.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class DirectorTest {

    Studio studio;
    Film film;
    Film film2;
    Director director;
    Director director2;
    Director director3;

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
        director2 = new Director("Karl Pilkington", 0, film, studio);
        director3 = new Director("Paul Sapphire", 0, film, studio);
        DBHelper.saveOrUpdate(director2);
        DBHelper.saveOrUpdate(director3);

    }

    @After
    public void tearDown(){
        DBHelper.delete(studio);
        DBHelper.delete(film);
        DBHelper.delete(film2);
        DBHelper.delete(director);
        DBHelper.delete(director2);
        DBHelper.delete(director3);
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

    @Test
    public void canDelete(){
        DBHelper.delete(director3);
        java.util.List<Object> directorList = DBHelper.getAll(Director.class);
        assertEquals(2, directorList.size());
    }

    @Test
    public void canPay(){
        director.payEmployee(500000);
        assertEquals(500000, director.getCurrent_pay());
        assertEquals(19500000, studio.getBudget());
    }

}
