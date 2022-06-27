package com.order.dto;

import com.order.Orders;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
@Data
@NoArgsConstructor
public class NewOrderRequest {

    @NotNull
    private Users buyer;
    @NotNull
    private String address;
    @NotNull
//    private List<OrderItems> orderItems;
    @NotNull
    private Orders.Status status;
    @NotNull
    private float total;


//    public Orders extractResource() {
//        return new Orders(buyer, address, orderItems, status, total);
//    }
    public Orders extractResource() {
        return new Orders(buyer, address, status, total);
    }
    @Override
    public String toString() {
        return "NewOrderRequest{" +
                "buyer=" + buyer +
                ", address='" + address + '\'' +
//                ", orderItems=" + orderItems +
                ", status=" + status +
                ", total=" + total +
                '}';
    }
}
