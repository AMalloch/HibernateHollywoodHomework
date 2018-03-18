import com.sun.tools.javac.util.List;
import db.DBHelper;
import models.*;
import models.Actor;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Table;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Film film;
    Film film2;
    Actor actor;
    Actor actor2;
    Actor actor3;
    Studio studio;

    @Before
    public void before(){
        studio = new Studio("Hollywood Studio", 20000000);
        DBHelper.saveOrUpdate(studio);
        film = new Film("Terminator", studio, "Thriller");
        DBHelper.saveOrUpdate(film);
        film2 = new Film("Frozen", studio, "Horror");
        DBHelper.saveOrUpdate(film2);
        actor = new Actor("John Connor", 0, film, studio);
        DBHelper.saveOrUpdate(actor);
        actor2 = new Actor("Meriss Till", 0, film, studio);
        DBHelper.saveOrUpdate(actor2);
        actor3 = new Actor("Darren Middles", 0, film, studio);
        DBHelper.saveOrUpdate(actor3);
    }

    @After
    public void tearDown(){
        DBHelper.delete(studio);
        DBHelper.delete(film);
        DBHelper.delete(film2);
        DBHelper.delete(actor);
        DBHelper.delete(actor2);
        DBHelper.delete(actor3);
    }


    @Test
    public void canGetName(){
        assertEquals("John Connor", actor.getName());
    }

    @Test
    public void canGetCurrentPay(){
        assertEquals(0, actor.getCurrent_pay());
    }

    @Test
    public void canGetAssignedFilms(){
        assertEquals(film, actor.getFilm());
    }

    @Test
    public void canSetName() {
        actor.setName("Arnie Swarszasomething");
        assertEquals("Arnie Swarszasomething", actor.getName());
    }

    @Test
    public void canSetCurrentPay() {
        actor.setCurrent_pay(100000);
        assertEquals(100000, actor.getCurrent_pay());
    }

    @Test
    public void canSetFilm() {
        actor.setFilm(film2);
        assertEquals(film2, actor.getFilm());
    }

    @Test
    public void canSave(){
        Actor foundActor = DBHelper.find(Actor.class, actor.getId());
        assertEquals("John Connor", foundActor.getName());
    }

    @Test
    public void canDelete(){
        DBHelper.delete(actor3);
        java.util.List<Object> actorList = DBHelper.getAll(Actor.class);
        assertEquals(2, actorList.size());
    }

    @Test
    public void canPay(){
        actor.payEmployee(100000);
        assertEquals(100000, actor.getCurrent_pay());
        assertEquals(19900000, studio.getBudget());
    }

    @Test
    public void numberOfActorsByGenreTest(){
        DBHelper.getAll(Actor.class);
        assertEquals(3, actor.numberOfActorsByGenre("Thriller"));
    }
}
