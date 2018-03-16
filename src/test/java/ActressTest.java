
import models.Actress;
import models.Film;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActressTest {

    Film film;
    Film film2;
    Actress actress;

    @Before
    public void before() {
        film = new Film("Terminator");
        film2 = new Film("Frozen");
        actress = new Actress("Samantha Crinklecut", 0, film);
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
        assertEquals(film, actress.getAssigned_films());
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
        actress.setAssigned_films(film2);
        assertEquals(film2, actress.getAssigned_films());
    }


}
