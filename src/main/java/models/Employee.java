package models;

import behaviours.IPay;

import java.util.Set;

public abstract class Employee implements IPay{

    private int id;
    private String name;
    private int current_pay;
    private Set<Film> assigned_films;

    public Employee() {
    }

    public Employee(String name, int current_pay, Set<Film> assigned_films) {
        this.name = name;
        this.current_pay = current_pay;
        this.assigned_films = assigned_films;
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

    public int getCurrent_pay() {
        return current_pay;
    }

    public void setCurrent_pay(int current_pay) {
        this.current_pay = current_pay;
    }

    public Set<Film> getAssigned_films() {
        return assigned_films;
    }

    public void setAssigned_films(Set<Film> assigned_films) {
        this.assigned_films = assigned_films;
    }
}
