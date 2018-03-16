
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    Studio studio;

    @Before
    public void before(){
        studio = new Studio("Amaranth Studios", 20000000);
    }

    @Test
    public void getName() {
        assertEquals("Amaranth Studios", studio.getName());
    }

    @Test
    public void getBudget() {
        assertEquals(20000000, studio.getBudget());
    }
}
