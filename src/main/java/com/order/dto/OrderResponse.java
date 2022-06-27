package com.order.dto;

import com.order.Orders;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class OrderResponse {

    private int id;
    private Users buyer;
    private String address;
//    private List<OrderItems> orderItems;
    private Orders.Status status;
    private float total;


    public OrderResponse(Orders order) {
        this.id = order.getId();
        this.buyer = order.getBuyer();
        this.address = order.getAddress();
//        this.orderItems = order.getOrderItems();
        this.status = order.getStatus();
        this.total = order.getTotal();
    }

}
