package com.order.dto;

import com.order.Orders;
import com.user.Users;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
public class UpdateOrderRequest {

    private int id;

//    private Users buyer;
//
//    private String address;
//
//    private List<NewOrderProductRequest> orderItems;
//
    private Orders.Status status;

    public Orders extractResource() {
        return new Orders(id, status);
    }
}
