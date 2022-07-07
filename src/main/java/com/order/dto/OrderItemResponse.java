package com.order.dto;

import com.order.OrderItems;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderItemResponse {

    private int orderId;
    private int productId;
    private String productName;
    private String productImage;
    private double productPrice;
    private int sellerId;
    private int quantity;

    public OrderItemResponse(OrderItems orderItem) {
        this.orderId = orderItem.getPk().getOrder().getId();
        this.productId = orderItem.getPk().getProduct().getId();
        this.productName = orderItem.getPk().getProduct().getProductName();
        this.productImage = orderItem.getPk().getProduct().getProductImage();
        this.productPrice = orderItem.getPk().getProduct().getPrice();
        this.sellerId = orderItem.getPk().getProduct().getSeller().getId();
        this.quantity = orderItem.getQuantity();
    }

}
