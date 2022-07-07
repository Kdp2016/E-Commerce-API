package com.order;

import com.common.utils.ResourceCreationResponse;
import com.order.dto.*;
import com.product.dtos.ProductResponse;
import com.product.dtos.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/seller/{sellerId}")
    public List<NewOrderResponse> getAllOrdersBySeller(@PathVariable int sellerId){
        return orderService.getOrderBySellerId(sellerId);
    }

    @GetMapping("/id/{orderId}")
    public OrderResponse getOrderById(@PathVariable int orderId) {
        return orderService.getOrderById(orderId);
    }


    @GetMapping("/id/{orderId}/items")
    public List<ProductResponse> getItemsInOrderWithId(@PathVariable int orderId) {
        return orderService.getOrderById(orderId).getOrderItems();
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


    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(consumes = "application/json")
    public void updateOrderInfo(@RequestBody UpdateOrderRequest updateOrderInfo) {
        orderService.updateOrder(updateOrderInfo);
    }

    @GetMapping("/search")
    public List<OrderResponse> findBy(@RequestParam Map<String, String> params) {
        return orderService.search(params);
    }


}
