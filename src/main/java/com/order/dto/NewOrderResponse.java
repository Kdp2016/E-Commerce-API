package com.order.dto;

import com.order.Orders;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class NewOrderResponse {
    private int orderId;
    private String address;
    private Orders.Status status;
    private double total;
    private List<OrderItemResponse> orderItems;
    private int customer_id;

    public NewOrderResponse(Orders order) {
        this.orderId = order.getId();
        this.address = order.getAddress();
        this.status = order.getStatus();
        this.total = order.getTotal();
        this.orderItems = order.getOrderItems().stream().map(OrderItemResponse::new).collect(Collectors.toList());;
        this.customer_id = order.getBuyer().getId();
    }
}
