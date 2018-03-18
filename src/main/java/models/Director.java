package models;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="directors")
public class Director extends Employee {

    public Director(String name, int current_pay, Film film, Studio studio) {
        super(name, current_pay, film, studio);
    }

    public Director() {
    }

    public int payEmployee(int amount) {
        setCurrent_pay(amount);
        getStudio().setBudget(getStudio().getBudget() - amount);
        return (getStudio().getBudget());
    }
}
