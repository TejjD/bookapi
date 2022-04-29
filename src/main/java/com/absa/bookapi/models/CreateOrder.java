package com.absa.bookapi.models;

import java.time.LocalDate;
import java.util.Map;

public class CreateOrder {
    private Integer id;

    private LocalDate orderDate;

    private Integer customerId;

    private Map<Integer, Integer> books;

    public Map<Integer, Integer> getBooks() {
        return books;
    }

    public void setBooks(Map<Integer, Integer> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}