package com.spring.Foodapp.model;

import jakarta.persistence.*;

@Entity
@Table(name = "catering")
public class Catering {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;
    @Column(name = "address")
    private String address;

    public Catering() {
    }

    public Catering(String name, String code, String address) {
        this.name = name;
        this.code = code;
        this.address = address;
    }

    public Catering(int id, String name, String code, String address) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.address = address;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
