package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

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
}
