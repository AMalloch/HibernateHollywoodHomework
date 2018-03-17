import db.DBHelper;
import models.Actor;
import models.Film;
import models.Studio;

public class Runner {

    public static void main(String[] args) {

        Studio studio= new Studio("Hollywood Studios", 20000000);
        DBHelper.saveOrUpdate(studio);
        Film film = new Film("Terminator");
        DBHelper.saveOrUpdate(film);
        Actor actor = new Actor("John Connor", 0, film);
        DBHelper.saveOrUpdate(actor);

    }
}
