package com.order;

import com.common.utils.ResourceCreationResponse;
import com.order.dto.NewOrderRequest;
import com.order.dto.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<OrderResponse> fetchAllOrders() {

        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }
    public OrderResponse getOrderById(int id) throws Exception{
        return orderRepository.findById(id)
                .map(OrderResponse::new)
                .orElseThrow(Exception::new);
    }

    public ResourceCreationResponse createOrder(@Valid NewOrderRequest newOrderRequest) {
        Orders newOrder = newOrderRequest.extractResource();

        orderRepository.save(newOrder);
        return new ResourceCreationResponse(newOrder.getId());
    }

    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);

    }

}
