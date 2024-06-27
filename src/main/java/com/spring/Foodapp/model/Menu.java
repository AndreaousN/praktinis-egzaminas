package com.spring.Foodapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public Menu() {
    }
    public Menu(String name) {
        this.name = name;
    }

    public Menu(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
