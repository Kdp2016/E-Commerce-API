package com.entities;

import java.util.Objects;

public class Status {
    private int id;
    private String status_name;

    public Status() {
    }

    public Status(String status_name) {
        this.status_name = status_name;
    }

    public Status(int id, String status_name) {
        this.id = id;
        this.status_name = status_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus_name() {
        return status_name;
    }

    public void setStatus_name(String status_name) {
        this.status_name = status_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return id == status.id && Objects.equals(status_name, status.status_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status_name);
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", status_name='" + status_name + '\'' +
                '}';
    }
}
