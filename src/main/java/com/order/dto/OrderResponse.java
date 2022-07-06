package com.order.dto;

import com.order.Orders;
import com.product.dtos.ProductResponse;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class OrderResponse {

    private int id;
    private Users buyer;
    private String address;
    private List<ProductResponse> orderItems;
    private Orders.Status status;
    private double total;


    public OrderResponse(Orders order) {
        this.id = order.getId();
        this.buyer = order.getBuyer();
        this.address = order.getAddress();
        this.orderItems = order.getOrderItems().stream().map(ProductResponse::new).collect(Collectors.toList());
        this.status = order.getStatus();
        this.total = order.getTotal();
    }

}
