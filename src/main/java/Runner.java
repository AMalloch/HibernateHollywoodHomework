import db.DBHelper;
import models.*;

import java.util.Dictionary;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Studio studio= new Studio("Hollywood Studios", 20000000);
        DBHelper.saveOrUpdate(studio);
        Film film = new Film("Terminator", studio, "Thriller");
        DBHelper.saveOrUpdate(film);
        Actor actor = new Actor("John Connor", 0, film, studio);
        DBHelper.saveOrUpdate(actor);
        Actor actor2 = new Actor("Johnny Begood", 0, film, studio);
        DBHelper.saveOrUpdate(actor2);
        Actress actress = new Actress("Sarah Connor", 0, film, studio);
        DBHelper.saveOrUpdate(actress);
        Director director = new Director("Mike Serious", 0, film, studio);
        DBHelper.saveOrUpdate(director);

        List<Actor> actors = DBHelper.getAll(Actor.class);
        List<Actress> actresses = DBHelper.getAll(Actress.class);
        List<Director> directors = DBHelper.getAll(Director.class);
        List<Film> films = DBHelper.getAll(Film.class);
        List<Studio> studios = DBHelper.getAll(Studio.class);

        DBHelper.delete(actor2);


        Actress foundActress = DBHelper.find(Actress.class, actress.getId());

        List<Actor> actorByGenre = DBHelper.numberOfActorsByGenre("Thriller");

    }
}
