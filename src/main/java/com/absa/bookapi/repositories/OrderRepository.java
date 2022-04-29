package com.absa.bookapi.repositories;

import com.absa.bookapi.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT * FROM orders",
            nativeQuery = true)
    List<Order> getOrders();

    @Modifying
    @Query(value = "UPDATE orders SET total = ?2 WHERE order_id = ?1",
            nativeQuery = true)
    void updateOrderTotal(int orderId, float total);
}