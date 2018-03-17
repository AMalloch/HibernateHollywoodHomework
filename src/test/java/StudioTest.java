
import db.DBHelper;
import models.Actor;
import models.Director;
import models.Studio;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    Studio studio;
    Studio studio2;

    @Before
    public void before(){
        studio = new Studio("Hollywood Studios", 20000000);
        DBHelper.saveOrUpdate(studio);
        studio2 = new Studio("Gorva Productions", 20000000);
        DBHelper.saveOrUpdate(studio2);
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

    @Test
    public void canDelete(){
        DBHelper.delete(studio2);
        java.util.List<Object> studioList = DBHelper.getAll(Studio.class);
        assertEquals(1, studioList.size());
    }
}
