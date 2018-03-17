
import models.Actress;
import models.Film;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActressTest {

    Studio studio;
    Film film;
    Film film2;
    Actress actress;

    @Before
    public void before() {
        studio = new Studio("Hollywood Studios", 20000000);
        film = new Film("Terminator", studio);
        film2 = new Film("Frozen", studio);
        actress = new Actress("Samantha Crinklecut", 0, film, studio);
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


}
