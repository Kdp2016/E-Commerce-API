package com.order.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderResponse {

    private String id;
    private String firstName;
    private String lastName;
    private String username;
    private String role;

    private List<OrderResponse> createdOrder;

    public UserResponse(Order order) {
        this.id = order.getId();
        this.firstName = order.getFirstName();
        this.lastName = order.getLastName();
        this.username = order.getUsername();
        this.role = order.getRole().toString();
        this.createdTasks = order.getCreatedTasks().stream().map(TaskResponse::new).collect(Collectors.toList());
    }

}
