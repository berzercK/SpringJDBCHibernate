package com.netcracker.students.BatyrkinAndrew.dao.purchaseDAO;

import com.netcracker.students.BatyrkinAndrew.entity.Book;
import com.netcracker.students.BatyrkinAndrew.entity.Buyer;
import com.netcracker.students.BatyrkinAndrew.entity.Purchase;
import com.netcracker.students.BatyrkinAndrew.entity.Shop;

import java.util.Date;
import java.util.List;

public interface IPurchaseDAO {

    void savePurchase(Purchase entity);

    void updatePurchase(int idPurchase, Date date, Shop shop, Buyer buyer, Book book, int qty, double total);

    List findAllPurchase();

    Purchase findPurchaseById(int idPurchase);

    void deletePurchaseById(int idPurchase);

    long numberOfRow();

    List<Purchase> task2c();

    List<Purchase> task4a();

    List<Purchase> task4b();

    List<Purchase> task5a(double total);

    List<Purchase> task5b(int month);

    List<Purchase> task5c(String region, double fromDiscount, double toDiscount);

    List<Purchase> task5d();

}
