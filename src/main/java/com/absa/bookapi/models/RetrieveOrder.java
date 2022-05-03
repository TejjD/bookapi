package com.absa.bookapi.models;

import java.util.Date;
import java.util.List;

public class RetrieveOrder {

    private Integer id;

    private Date orderDate;

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