package com.order;

import org.springframework.beans.factory.annotation.Autowired;

public class OrderService {
    private final OrderRepository orderRepo;

    @Autowired
    public OrderService(OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<OrderResponse> fetchAllOrders() {

        return orderRepo.findAll()
                .stream()
                .map(orderResponse::new)
                .collect(Collectors.toList());
    }
    public OrderResponse fetchOrderById(String id) {
        return orderRepo.findById(id)
                .map(OrderResponse::new)
                .orElseThrow(ResourceNotFoundException::new);
    }

}
