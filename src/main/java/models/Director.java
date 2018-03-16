package models;

import java.util.Set;

public class Director extends Employee {

    public Director(String name, int current_pay, Set<Film> assignedFilm) {
        super(name, current_pay, assignedFilm);
    }
}
