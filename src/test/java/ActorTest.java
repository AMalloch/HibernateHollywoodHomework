import models.Actor;
import models.Film;
import org.junit.Before;

public class ActorTest {

    Film film;
    Actor actor;

    @Before
    public void before(){
        Film film1 = new Film("Terminator");
        Actor actor1 = new Actor("Brangelina Folly", 0, film1);
    }
}
