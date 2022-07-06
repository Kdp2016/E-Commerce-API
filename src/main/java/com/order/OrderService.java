package com.order;

import com.common.EntitySearcher;
import com.common.utils.ResourceCreationResponse;
import com.common.utils.exceptions.ResourceNotFoundException;
import com.order.dto.NewOrderProductRequest;
import com.order.dto.NewOrderRequest;
import com.order.dto.OrderResponse;
import com.common.utils.exceptions.ResourcePersistenceException;
import com.order.dto.UpdateOrderRequest;
import com.product.ProductRepository;
import com.product.Products;
import com.product.dtos.ProductResponse;

import com.product.dtos.UpdateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    private final EntitySearcher entitySearcher;

    @Autowired
    public OrderService(OrderRepository orderRepository, OrderItemRepository orderItemRepository, EntitySearcher entitySearcher) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.entitySearcher = entitySearcher;
    }

    public List<OrderResponse> fetchAllOrders() {

        System.out.println(orderRepository.findAll().stream().filter(order -> order.getId() == 2).findFirst().orElse(null));

        return orderRepository.findAll()
                .stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }
    public OrderResponse getOrderById(int id) {
        return orderRepository.findById(id)
                .map(OrderResponse::new)
                .orElseThrow(ResourceNotFoundException::new);
    }


    /**
     * This function takes in a newOrderRequest, which will be persisted to the DB.
     *
     * @param newOrderRequest this param takes in a request of what a new Order looks like.
     * @return this method returns the Id of the order created
     * @throws ResourceNotFoundException, this will be thrown if a product is not found.
     * @throws ResourcePersistenceException, this will be thrown if there is an error persisting to the DB.
     */
    public ResourceCreationResponse createOrder(@Valid NewOrderRequest newOrderRequest) {

        Orders newOrder = newOrderRequest.extractResource(); // transient state (not associated with a DB record)

        orderRepository.save(newOrder); // after this line newOrder goes to the persistent state

        List<OrderItems> orderItems = newOrderRequest.getOrderItems().stream().map(item -> {
            return new OrderItems(newOrder.getId(), item.getProductId(), item.getQuantity());
        }).collect(Collectors.toList());

        orderItemRepository.saveAll(orderItems);

        newOrder.setOrderItems(orderItems);

        orderRepository.save(newOrder);

        return new ResourceCreationResponse(newOrder.getId());
    }

    public void deleteOrderById(int id) {
        orderRepository.deleteById(id);

    }

    public void updateOrder (@Valid UpdateOrderRequest updateOrderRequest) {

        Orders updatedOrder = updateOrderRequest.extractResource();
        Orders orderForUpdate = orderRepository.findById(updatedOrder.getId()).orElseThrow(ResourceNotFoundException::new);

        if (updatedOrder.getStatus() != null) {
            orderForUpdate.setStatus(updatedOrder.getStatus());
        }
        orderRepository.save(orderForUpdate);
    }

    public List<OrderResponse> search(Map<String, String> requestParamMap) {
        if (requestParamMap.isEmpty()) return fetchAllOrders();
        Set<Orders> matchingOrders = entitySearcher.searchForEntity(requestParamMap, Orders.class);
        if (matchingOrders.isEmpty()) throw new ResourceNotFoundException();
        return matchingOrders.stream()
                .map(OrderResponse::new)
                .collect(Collectors.toList());
    }
}
