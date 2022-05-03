package com.absa.bookapi.models;

import java.util.Date;
import java.util.Map;

public class CreateOrder {
    private Integer id;

    private Date orderDate;

    private Integer customerId;

    private Map<String, Integer> books;

    public Map<String, Integer> getBooks() {
        return books;
    }

    public void setBooks(Map<String, Integer> books) {
        this.books = books;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

}