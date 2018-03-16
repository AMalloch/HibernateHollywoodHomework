package models;

import behaviours.IPay;

import java.util.Set;

public abstract class Employee implements IPay{

    private String name;
    private int current_pay;
    private Set<Film> assignedFilm;

    public Employee() {
    }

    public Employee(String name, int current_pay, Set<Film> assignedFilm) {
        this.name = name;
        this.current_pay = current_pay;
        this.assignedFilm = assignedFilm;
    }
}
