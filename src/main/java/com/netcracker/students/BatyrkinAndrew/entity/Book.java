package com.netcracker.students.BatyrkinAndrew.entity;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @Column(name = "id_book")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idBook;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private double price;
    @Column(name = "region")
    private String region;
    @Column(name = "qty")
    private int qty;

    public Book() {
    }

    public Book(String name, double price, String region, int qty) {
        this.name = name;
        this.price = price;
        this.region = region;
        this.qty = qty;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Book{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", region='" + region + '\'' +
                ", qty=" + qty +
                '}';
    }

}
