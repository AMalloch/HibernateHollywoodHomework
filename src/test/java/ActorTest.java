import db.DBHelper;
import models.Actor;
import models.Actor;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Table;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Film film;
    Film film2;
    Actor actor;
    Studio studio;

    @Before
    public void before(){
        studio = new Studio("Hollywood Studio", 20000000);
        DBHelper.saveOrUpdate(studio);
        film = new Film("Terminator", studio);
        DBHelper.saveOrUpdate(film);
        film2 = new Film("Frozen", studio);
        DBHelper.saveOrUpdate(film2);
        actor = new Actor("John Connor", 0, film, studio);
        DBHelper.saveOrUpdate(actor);
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
}
