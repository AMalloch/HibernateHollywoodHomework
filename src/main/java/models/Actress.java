package models;

import java.util.Set;

public class Actress extends Employee{

    public Actress(String name, int current_pay, Set<Film> assignedFilm) {
        super(name, current_pay, assignedFilm);
    }
}
