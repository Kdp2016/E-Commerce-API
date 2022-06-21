package com.entities;

import java.util.Objects;

public class UserRoles {
    private int id;
    private String role_name;

    public UserRoles() {
    }

    public UserRoles(String role_name) {
        this.role_name = role_name;
    }

    public UserRoles(int id, String role_name) {
        this.id = id;
        this.role_name = role_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRoles userRoles = (UserRoles) o;
        return id == userRoles.id && Objects.equals(role_name, userRoles.role_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role_name);
    }

    @Override
    public String toString() {
        return "UserRoles{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                '}';
    }
}
