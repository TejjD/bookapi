package com.absa.bookapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_items_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Order.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Order orderId;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Book.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "isbn13")
    private Book book;

    @Column(name = "quantity")
    private Integer quantity;

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Order getOrderId() {
        return orderId;
    }

    public void setOrderId(Order custOrder) {
        this.orderId = custOrder;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}