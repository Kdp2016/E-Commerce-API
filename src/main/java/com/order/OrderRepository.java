package com.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "select o.*, oi.quantity, p.seller_id \n" +
            "from orders o\n" +
            "join order_items oi \n" +
            "on o.order_id = oi.order_id\n" +
            "join products p \n" +
            "on oi.product_id = p.product_id\n" +
            "where p.seller_id = :id", nativeQuery = true)
    List<Orders> getOrdersBySellerId(int id);
}
