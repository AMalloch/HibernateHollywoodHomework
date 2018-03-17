
import db.DBHelper;
import models.Director;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    Studio studio;

    @Before
    public void before(){
        studio = new Studio("Hollywood Studios", 20000000);
        DBHelper.saveOrUpdate(studio);
    }

    @Test
    public void getName() {
        assertEquals("Amaranth Studios", studio.getName());
    }

    @Test
    public void getBudget() {
        assertEquals(20000000, studio.getBudget());
    }

    @Test
    public void canName() {
        studio.setName("Dolba Studios");
        assertEquals("Dolba Studios", studio.getName());
    }

    @Test
    public void canSetBudget() {
        studio.setBudget(21000000);
        assertEquals(21000000, studio.getBudget());
    }

    @Test
    public void canSave(){
        Studio foundStudio = DBHelper.find(Studio.class, studio.getId());
        assertEquals("Hollywood Studios", foundStudio.getName());
    }
}
