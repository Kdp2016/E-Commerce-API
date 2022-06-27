package com.order;

import com.common.utils.ResourceCreationResponse;
import com.order.dto.NewOrderRequest;
import com.order.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping(produces = "application/json")
    public List<OrderResponse> getAllOrders() {

        return orderService.fetchAllOrders();
    }

    @GetMapping("/id/{orderId}")
    public OrderResponse getOrderById(@PathVariable int orderId) throws Exception {
        return orderService.getOrderById(orderId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResourceCreationResponse postNewOrder(@RequestBody NewOrderRequest newOrder) throws SQLException {
        return orderService.createOrder(newOrder);
    }

    @PostMapping("/delete/{orderId}")
    public void deleteOrderById(@PathVariable int orderId) {
        orderService.deleteOrderById(orderId);
    }
}
