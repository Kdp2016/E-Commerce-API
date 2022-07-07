package com.order.dto;

import com.order.OrderItems;
import com.order.Orders;
import com.product.dtos.ProductResponse;

import java.util.List;
import java.util.stream.Collectors;

public class NewOrderResponse {
    private int orderId;
    private String address;
    private Orders.Status status;
    private double total;
    private List<ProductResponse> orderItems;
    private int customer_id;
    private int quantity;
    private int seller_id;

    public NewOrderResponse(Orders order) {
        this.orderId = order.getId();
        this.address = order.getAddress();
        this.status = order.getStatus();
        this.total = order.getTotal();
        this.orderItems = order.getOrderItems().stream().map(ProductResponse::new).collect(Collectors.toList());;
        this.customer_id = order.getBuyer().getId();
//        this.quantity = order.getOrderItems().;
//        this.seller_id = order.getOrderItems().;
    }
}
