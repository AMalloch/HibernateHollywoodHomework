import db.DBHelper;
import models.Actor;
import models.Film;

public class Runner {

    public static void main(String[] args) {

        Film film = new Film("Terminator");
        DBHelper.saveOrUpdate(film);
        Actor actor = new Actor("John Connor", 0, film);
        DBHelper.saveOrUpdate(actor);

    }
}
