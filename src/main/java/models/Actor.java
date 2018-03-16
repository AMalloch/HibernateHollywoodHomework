package models;

import java.util.Set;

public class Actor extends Employee{

    public Actor(String name, int current_pay, Set<Film> assignedFilm) {
        super(name, current_pay, assignedFilm);
    }
}
