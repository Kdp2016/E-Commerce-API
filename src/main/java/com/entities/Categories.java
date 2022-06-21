package com.entities;

import java.util.Objects;

public class Categories {
    private int id;
    private String category_name;

    public Categories() {
    }

    public Categories(String category_name) {
        this.category_name = category_name;
    }

    public Categories(int id, String category_name) {
        this.id = id;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categories category = (Categories) o;
        return id == category.id && Objects.equals(category_name, category.category_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category_name);
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
