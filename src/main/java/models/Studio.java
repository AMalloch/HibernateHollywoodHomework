package models;

import java.util.Set;

public class Studio {

    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}
