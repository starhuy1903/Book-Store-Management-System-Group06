/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.time.*;
import enumeration.*;
/**
 *
 * @author Huy
 */
public class Book {
    private Long id;
    private String title;
    private String isbn13;
    private BookLanguage bookLanguage;
    private int numPages;
    private Publisher publisher;
    private Category category;
    private Author author;
    private LocalDate publishedDate;
    private int stock;
    private BookStatus status;
    private double price;

    public Book() {
    }
    

    public Book(Long id, String title, String isbn13, BookLanguage bookLanguage, int numPages, Publisher publisher, Category category, Author author, LocalDate publishedDate, int stock, BookStatus status, double price) {
        this.id = id;
        this.title = title;
        this.isbn13 = isbn13;
        this.bookLanguage = bookLanguage;
        this.numPages = numPages;
        this.publisher = publisher;
        this.category = category;
        this.author = author;
        this.publishedDate = publishedDate;
        this.stock = stock;
        this.status = status;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public void setIsbn13(String isbn13) {
        this.isbn13 = isbn13;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(BookLanguage bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public int getNumPages() {
        return numPages;
    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
