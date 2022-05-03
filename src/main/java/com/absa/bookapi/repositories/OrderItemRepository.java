package com.absa.bookapi.repositories;

import com.absa.bookapi.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
    @Query(value = "SELECT isbn13 FROM order_items WHERE order_id = ?1",
            nativeQuery = true)
    List<String> getBooksForOrderId(int orderId);
}