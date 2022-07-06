package com.order;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.order.dto.NewOrderProductRequest;
import com.user.Users;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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

    @OneToMany(mappedBy = "pk.order")
    private List<OrderItems> orderItems;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "total", nullable = false)
    private double total;

    public Orders() {
    }

    public Orders(int id, Users buyer, String address, List<OrderItems> orderItems, Status status, double total) {
        this.id = id;
        this.buyer = buyer;
        this.address = address;
        this.orderItems = orderItems;
        this.status = status;
        this.total = total;
    }

    public Orders(Users buyer, String address, Status status, double total) {
        this.buyer = buyer;
        this.address = address;
        this.status = status;
        this.total = total;
    }

    public Orders(int id, Status status) {
        this.id = id;
        this.status = status;
    }

    public Orders(int orderId) {
        this.id = orderId;
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

    public void addOrderItems(OrderItems... orderItems) {
        if (this.orderItems == null) {
            this.orderItems = new ArrayList<>();
        }
        this.orderItems.addAll(Arrays.asList(orderItems));
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id && Double.compare(orders.total, total) == 0 && Objects.equals(buyer, orders.buyer) && Objects.equals(address, orders.address) && Objects.equals(orderItems, orders.orderItems) && status == orders.status;
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

