import models.Actor;
import models.Film;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.Table;

import static junit.framework.Assert.assertEquals;

public class ActorTest {

    Film film;
    Actor actor;

    @Before
    public void before(){
        film = new Film("Terminator");
        actor = new Actor("John Connor", 0, film);
    }


    @Test
    public void canGetName(){
        assertEquals("John Connor", actor.getName());
    }



}
