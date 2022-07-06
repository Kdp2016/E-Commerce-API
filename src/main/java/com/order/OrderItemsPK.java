package com.order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.product.Products;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemsPK implements Serializable {

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id")
    private Orders order;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id")
    private Products product;

    public OrderItemsPK() {
    }

    public OrderItemsPK(Orders order, Products product) {
        this.order = order;
        this.product = product;
    }

    public OrderItemsPK(int orderId, int productId) {
        this.order = new Orders(orderId);
        this.product = new Products(productId);
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemsPK that = (OrderItemsPK) o;
        return Objects.equals(order, that.order) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, product);
    }

}