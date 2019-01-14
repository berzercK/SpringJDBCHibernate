package com.netcracker.students.BatyrkinAndrew.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchase")
public class Purchase {

    @Id
    @Column(name = "id_purchase")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPurchase;
    @Column(name = "date")
    private Date date;
    @ManyToOne
    @JoinColumn(name = "shop", referencedColumnName = "id_shop")
    private Shop shop;
    @ManyToOne
    @JoinColumn(name = "buyer", referencedColumnName = "id_buyer")
    private Buyer buyer;
    @ManyToOne
    @JoinColumn(name = "book", referencedColumnName = "id_book")
    private Book book;
    @Column(name = "qty")
    private int qty;
    @Column(name = "total")
    private double total;

    public Purchase() {
    }

    public Purchase(Date date, Shop shop, Buyer buyer, Book book, int qty, double total) {
        this.date = date;
        this.shop = shop;
        this.buyer = buyer;
        this.book = book;
        this.qty = qty;
        this.total = total;
    }

    public int getIdPurchase() {
        return idPurchase;
    }

    public void setIdPurchase(int idPurchase) {
        this.idPurchase = idPurchase;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "idPurchase=" + idPurchase +
                ", date=" + date +
                ", shop=" + shop +
                ", buyer=" + buyer +
                ", book=" + book +
                ", qty=" + qty +
                ", total=" + total +
                '}';
    }

}
