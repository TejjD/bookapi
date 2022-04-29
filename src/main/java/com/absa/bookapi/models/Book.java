package com.absa.bookapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Integer id;

    @Column(name = "title", length = 400)
    private String title;

    @Column(name = "isbn13", length = 13)
    private String isbn13;

    @Column(name = "num_pages")
    private Integer numPages;

    @Column(name = "publication_date")
    private LocalDate publicationDate;

    @Column(name = "price")
    private float price;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Publisher.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public Integer getNumPages() {
        return numPages;
    }

    public void setNumPages(Integer numPages) {
        this.numPages = numPages;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

}