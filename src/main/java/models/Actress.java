package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="actresses")
public class Actress extends Employee{

    public Actress(String name, int current_pay, Film film, Studio studio) {
        super(name, current_pay, film, studio);
    }

    public Actress() {
    }

    public int payEmployee(int amount) {
        setCurrent_pay(amount);
        getStudio().setBudget(getStudio().getBudget() - amount);
        return (getStudio().getBudget());
    }
}
