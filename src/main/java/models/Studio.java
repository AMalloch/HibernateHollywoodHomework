package models;

import java.util.Set;

public class Studio {

    private String name;
    private Set<Employee> employees;
    private Set<Film> films;
    private int budget;

    public Studio() {
    }

    public Studio(String name, Set<Employee> employees, Set<Film> films, int budget) {
        this.name = name;
        this.employees = employees;
        this.films = films;
        this.budget = budget;
    }
}
