package com.absa.bookapi.controllers;

import com.absa.bookapi.models.CreateOrder;
import com.absa.bookapi.models.RetrieveOrder;
import com.absa.bookapi.services.OrderService;
import com.absa.bookapi.services.RetrieveOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class OrdersController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RetrieveOrdersService retrieveOrdersService;

    @GetMapping("booksapi/orders/getorderslist")
    public List<RetrieveOrder> getOrderItems() {
        return retrieveOrdersService.getAllOrders();
    }


    @PostMapping("booksapi/orders/placeorder")
    public ResponseEntity<CreateOrder> placeOrder(@RequestBody CreateOrder order) {
        try {
            return orderService.createOrder(order);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
    }
}
