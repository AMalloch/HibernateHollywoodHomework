
import models.Actress;
import models.Film;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ActressTest {

        Film film;
        Actress actress;

        @Before
        public void before() {
            film = new Film("Terminator");
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
}
