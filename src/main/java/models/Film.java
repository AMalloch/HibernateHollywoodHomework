package models;

import java.util.Set;

public class Film {

    private String name;
    private Set<Employee> employees;

    public Film() {
    }

    public Film(String name, Set<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }
}
