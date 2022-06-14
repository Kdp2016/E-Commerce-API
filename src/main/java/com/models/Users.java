package com.models;

import java.util.Objects;

public class Users {
    private int id;
    private string firstName;
    private string lastName;
    private String email;
    private string paswords;
    private int role_id;


    public Orders() {
    }

    public Users(int id, string firstName, string lastName, String email, string paswords, int role_id) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.paswords = paswords;
        this.role_id = role_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public string getFirstName() {
        return firstName;
    }

    public void setFirstName(string firstName) {
        this.firstName = firstName;
    }

    public string getLastName() {
        return lastName;
    }

    public void setLastName(string lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public string getPaswords() {
        return paswords;
    }

    public void setPaswords(string paswords) {
        this.paswords = paswords;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Users users = (Users) object;
        return id == users.id && role_id == users.role_id && java.util.Objects.equals(firstName, users.firstName) && java.util.Objects.equals(lastName, users.lastName) && java.util.Objects.equals(email, users.email) && java.util.Objects.equals(paswords, users.paswords);
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), id, firstName, lastName, email, paswords, role_id);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", email='" + email + '\'' +
                ", paswords=" + paswords +
                ", role_id=" + role_id +
                '}';
    }
}

