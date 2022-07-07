package com.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {

    @Query(value = "select o.* from orders o " +
            "join order_items oi on o.order_id = oi.order_id " +
            "join products p on oi.product_id = p.product_id " +
            "where p.seller_id = :id", nativeQuery = true)
    List<Orders> getOrdersBySellerId(int id);
}
