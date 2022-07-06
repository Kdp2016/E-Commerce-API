package com.order.dto;

import com.order.OrderItems;
import com.order.OrderItemsPK;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemsRequest {
    private OrderItemsPK orderItemsPK;
    private int quantity;


    public OrderItems extractResource() {
        return new OrderItems(orderItemsPK, quantity);
    }
}
