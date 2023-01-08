/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author huynguyen
 */
public class BookRevenue {
    private String bookTitle;
    private int quantity;
    private int totalPrice;

    public BookRevenue() {
    }

    public BookRevenue(String title, int quantity, int totalPrice) {
        this.bookTitle = title;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getTitle() {
        return bookTitle;
    }

    public void setTitle(String title) {
        this.bookTitle = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
}
