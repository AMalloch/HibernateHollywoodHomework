package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="actors")
public class Actor extends Employee{

    public Actor(String name, int current_pay, Film assigned_film) {
        super(name, current_pay, assigned_film);
    }
}