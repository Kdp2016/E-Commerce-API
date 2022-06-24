package com.order;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.user.Users;

import javax.persistence.*;
import javax.validation.Valid;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false, unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Users buyer;
    @Column(name = "address", nullable = false)
    private String address;
    @JsonManagedReference
    @OneToMany(mappedBy = "pk.order")
    @Valid
    private List<OrderItems> orderItems;
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;
    @Column(name = "total", nullable = false)
    private float total;

    public Orders() {
    }

    public Orders(int id, Users buyer, String address, List<OrderItems> orderItems, Status status, float total) {
        this.id = id;
        this.buyer = buyer;
        this.address = address;
        this.orderItems = orderItems;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Users getBuyer() {
        return buyer;
    }

    public void setBuyer(Users buyer) {
        this.buyer = buyer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<OrderItems> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItems> orderItems) {
        this.orderItems = orderItems;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Float.compare(orders.total, total) == 0 && Objects.equals(buyer, orders.buyer) && Objects.equals(address, orders.address) && Objects.equals(orderItems, orders.orderItems) && status == orders.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyer, address, orderItems, status, total);
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", buyer=" + buyer +
                ", address='" + address + '\'' +
                ", orderItems=" + orderItems +
                ", status=" + status +
                ", total=" + total +
                '}';
    }

    public enum Status {
        ORDERED, DELIVERED, CANCELLED;
    }
}

