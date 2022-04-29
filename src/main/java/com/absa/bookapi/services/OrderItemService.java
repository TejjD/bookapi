package com.absa.bookapi.services;

import com.absa.bookapi.models.OrderItem;
import com.absa.bookapi.repositories.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public void saveOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

}
