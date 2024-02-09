package io.menglibay.realestateproject.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "surname",length = 100)
    private String surname;

    @Column(name = "iin", length = 100)
    private String iin;

    @Column(name = "number", length = 100)
    private String number;

    @Column(name = "rating", length = 65535,columnDefinition = "TEXT")
    private String rating;

    @Column(name = "additional", length = 65535,columnDefinition = "TEXT")
    private String additional;

    @Enumerated(EnumType.STRING)
    @Column(name = "role",length = 20)
    private UserRole role;


    public User(String name, String surname, String iin, String number, String rating, String additional,UserRole role) {
        this.name = name;
        this.surname = surname;
        this.iin = iin;
        this.number = number;
        this.rating = rating;
        this.additional = additional;
        this.role = role;
    }

    public User() {

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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getIin() {
        return iin;
    }

    public void setIin(String iin) {
        this.iin = iin;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
