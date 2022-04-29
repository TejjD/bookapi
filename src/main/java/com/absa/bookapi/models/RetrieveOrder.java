package com.absa.bookapi.models;

import java.time.LocalDate;
import java.util.List;

public class RetrieveOrder {

    private Integer id;

    private LocalDate orderDate;

    private Integer customerId;

    private float total;

    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setBooks(List<Book> books) {
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