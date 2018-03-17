package models;

import behaviours.IPay;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employees")
public abstract class Employee implements IPay {

    private int id;
    private String name;
    private int current_pay;
    private Film film;
    private Studio studio;

    public Employee() {
    }

    public Employee(String name, int current_pay, Film film) {
        this.name = name;
        this.current_pay = current_pay;
        this.film = film;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "current_pay")
    public int getCurrent_pay() {
        return current_pay;
    }

    public void setCurrent_pay(int current_pay) {
        this.current_pay = current_pay;
    }

    @ManyToOne
    @JoinColumn(name="film_id", nullable = false)
    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    @ManyToOne
    @JoinColumn(name = "studio_id", nullable = false)
    public Studio getStudio() {
        return studio;
    }

    public void setStudio(Studio studio) {
        this.studio = studio;
    }

}
