package models;

import db.DBHelper;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="actors")
public class Actor extends Employee{

    public Actor(String name, int current_pay, Film film, Studio studio) {
        super(name, current_pay, film, studio);
    }

    public Actor() {
    }

    public int payEmployee(int amount) {
        setCurrent_pay(amount);
        getStudio().setBudget(getStudio().getBudget() - amount);
        return (getStudio().getBudget());
    }

    // refactor by making a getAll by class separate function ?
    public int numberOfActorsByGenre(String genre) {
        java.util.List<Actor> actorList = DBHelper.getAll(Actor.class);
        java.util.List<Actor> actorByGenreList = new ArrayList<Actor>();
        for (Actor actor : actorList) {
            if (genre.equals (actor.getFilm().getGenre())) {
                actorByGenreList.add(actor);
            }
        }return actorByGenreList.size();
    }
}
