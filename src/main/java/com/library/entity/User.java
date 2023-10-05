package com.library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank
    @Size(min = 1, max = 15, message = "name must be between 1 and 15 symbols")
    @Column(name = "name")
    private String name;

    @NotBlank
    @Size(min = 1, max = 30, message = "name must be between 1 and 30 symbols")
    @Column(name = "surname")
    private String surname;

    @Pattern(regexp = "^\\+375-\\d{2}-\\d{3}-\\d{4}$", message = "phone number must be +375-__-__-____")
    @Column(name = "phone_number")
    private String phone;

    public User() {
    }

    public User(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
