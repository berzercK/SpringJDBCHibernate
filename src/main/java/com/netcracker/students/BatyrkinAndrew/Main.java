package com.netcracker.students.BatyrkinAndrew;

import com.netcracker.students.BatyrkinAndrew.entity.Book;
import com.netcracker.students.BatyrkinAndrew.entity.Buyer;
import com.netcracker.students.BatyrkinAndrew.entity.Purchase;
import com.netcracker.students.BatyrkinAndrew.entity.Shop;
import com.netcracker.students.BatyrkinAndrew.session.BookSession;
import com.netcracker.students.BatyrkinAndrew.session.BuyerSession;
import com.netcracker.students.BatyrkinAndrew.session.PurchaseSession;
import com.netcracker.students.BatyrkinAndrew.session.ShopSession;

import java.util.Date;

public class Main {
    public static void main(final String[] args) {
//        Filling.fillDB();

        task1();
        task2();
        task3();
        task4();
        task5();
    }

    private static void task1() {
//        deleting(5);
//        updating();
//        adding();
        outputData();
        outputDataById(1);
        printNumberOfRows();
    }

    private static void deleting(int id) {
        BuyerSession.deleteBookById(id);
        ShopSession.deleteShopById(id);
        BookSession.deleteBookById(id);
        PurchaseSession.deletePurchaseById(id);
    }

    private static void updating() {
        BuyerSession.updateBuyer(4, "UPDATE", "up-te", 4);
        ShopSession.updateShop(4, "UPDATE", "up-te", 4);
        BookSession.updateBook(4, "UPDATE", 4, "up-te", 4);
        PurchaseSession.updatePurchase(4, new Date(4), null, null, new Book("UPDATE_BOOK", 4, "up-te", 4), 4, 4);

        BookSession.updateBook(4, ".NET for Windows", 4, "up-te", 4);
        BookSession.updateBook(4, "Windows", 4, "up-te", 4);
        BookSession.updateBook(8, "Book 7", 20_001, "up-te", 4);
    }

    private static void adding() {
        BuyerSession.addBuyer(new Buyer("ADD", "ADD_REG", 3));
        ShopSession.addShop(new Shop("ADD", "ADD_REG", 3));
        BookSession.addBook(new Book("ADD", 3, "ADD_REG", 3));
        PurchaseSession.addPurchase(new Purchase(new Date(), ShopSession.findShopById(3), BuyerSession.findBuyerById(3), BookSession.findBookById(3), 3, 3));
    }

    private static void outputData() {
        BuyerSession.findAllBuyer();
        ShopSession.findAllShop();
        BookSession.findAllBooks();
        PurchaseSession.findAllPurchase();
    }

    private static void outputDataById(int id) {
        BuyerSession.findBuyerById(id);
        ShopSession.findShopById(id);
        BookSession.findBookById(id);
        PurchaseSession.findPurchaseById(id);
    }

    private static void printNumberOfRows() {
        BuyerSession.numberOfRow();
        ShopSession.numberOfRow();
        BookSession.numberOfRow();
        PurchaseSession.numberOfRow();
    }

    private static void task2() {
        BookSession.task2a();
        BuyerSession.task2b();
        PurchaseSession.task2c();
    }

    private static void task3() {
        BuyerSession.task3a("Nizhny Novgorod");
        ShopSession.task3b(new String[]{"Sormovsky", "Soviet"});
        BookSession.task3c("Windows", 20_000);
    }

    private static void task4() {
        PurchaseSession.task4a();
        PurchaseSession.task4b();
    }

    private static void task5() {
        PurchaseSession.task5a(60000);
        PurchaseSession.task5b(3);
        PurchaseSession.task5c("Avtozavodsky", 10.0, 15.0);
        PurchaseSession.task5d();
    }
}