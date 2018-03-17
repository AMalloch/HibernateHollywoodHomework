import db.DBHelper;
import models.Actor;
import models.Actor;
import models.Film;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Table;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Film film;
    Film film2;
    Actor actor;

    @Before
    public void before(){
        film = new Film("Terminator");
        film2 = new Film("Frozen");
        actor = new Actor("John Connor", 0, film);
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
