
import db.DBHelper;
import models.Actor;
import models.Director;
import models.Film;
import models.Studio;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class StudioTest {

    Studio studio;
    Studio studio2;
    Actor actor;
    Film film;

    @Before
    public void before(){
        actor = new Actor("John Connor", 0, film, studio);
        DBHelper.saveOrUpdate(actor);
        film = new Film("Terminator", studio, "Thriller");
        DBHelper.saveOrUpdate(film);
        studio = new Studio("Hollywood Studios", 20000000);
        DBHelper.saveOrUpdate(studio);
        studio2 = new Studio("Gorva Productions", 20000000);
        DBHelper.saveOrUpdate(studio2);
    }

    @After
    public void tearDown(){
        DBHelper.delete(studio);
        DBHelper.delete(studio2);
    }

    @Test
    public void getName() {
        assertEquals("Hollywood Studios", studio.getName());
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

    @Test
    public void canPayEmployee(){
        studio.payEmployeeViaStudio(actor, 100000);
        assertEquals(100000, actor.getCurrent_pay());
        assertEquals(19900000, studio.getBudget());
    }
}
