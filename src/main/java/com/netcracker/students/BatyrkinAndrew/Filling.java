package com.netcracker.students.BatyrkinAndrew;

import com.netcracker.students.BatyrkinAndrew.entity.Book;
import com.netcracker.students.BatyrkinAndrew.entity.Buyer;
import com.netcracker.students.BatyrkinAndrew.entity.Purchase;
import com.netcracker.students.BatyrkinAndrew.entity.Shop;
import com.netcracker.students.BatyrkinAndrew.session.BookSession;
import com.netcracker.students.BatyrkinAndrew.session.BuyerSession;
import com.netcracker.students.BatyrkinAndrew.session.PurchaseSession;
import com.netcracker.students.BatyrkinAndrew.session.ShopSession;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;

public class Filling {

    public static void fillDB() {
        System.out.println("Filling database:");
        fillBuyers();
        fillShops();
        fillBooks();
        fillPurchase();
    }

    private static void fillBuyers() {
        System.out.println("Add buyers...");
        BuyerSession.addBuyer(new Buyer("b0", "Avtozavodsky", 2.5));
        BuyerSession.addBuyer(new Buyer("b1", "Kanavinsky", 10));
        BuyerSession.addBuyer(new Buyer("b2", "Leninist", 15));
        BuyerSession.addBuyer(new Buyer("b3", "Moscow", 7.5));
        BuyerSession.addBuyer(new Buyer("b4", "Nizhny Novgorod", 2.5));
        BuyerSession.addBuyer(new Buyer("b5", "Prioksky", 5));
        BuyerSession.addBuyer(new Buyer("b6", "Soviet", 5));
        BuyerSession.addBuyer(new Buyer("b7", "Sormovsky", 7.5));
        BuyerSession.addBuyer(new Buyer("b8", "Soviet", 15));
        BuyerSession.addBuyer(new Buyer("b9", "Kanavinsky", 2.5));
        System.out.println("Complete.");
    }

    private static void fillShops() {
        System.out.println("Add shops...");
        ShopSession.addShop(new Shop("Shop 0", "Sormovsky", 10));
        ShopSession.addShop(new Shop("Shop 1", "Moscow", 12));
        ShopSession.addShop(new Shop("Shop 2", "Prioksky", 10));
        ShopSession.addShop(new Shop("Shop 3", "Kanavinsky", 15));
        ShopSession.addShop(new Shop("Shop 4", "Sormovsky", 10));
        ShopSession.addShop(new Shop("Shop 5", "Soviet", 18));
        ShopSession.addShop(new Shop("Shop 6", "Soviet", 15));
        ShopSession.addShop(new Shop("Shop 7", "Leninist", 10));
        ShopSession.addShop(new Shop("Shop 8", "Nizhny Novgorod", 12));
        ShopSession.addShop(new Shop("Shop 9", "Avtozavodsky", 15));
        System.out.println("Complete.");
    }

    private static void fillBooks() {
        System.out.println("Add books...");
        BookSession.addBook(new Book("Book 0", 5000, "Nizhny Novgorod", 10));
        BookSession.addBook(new Book("Book 1", 2500, "Leninist", 100));
        BookSession.addBook(new Book("Book 2", 50_000, "Avtozavodsky", 5));
        BookSession.addBook(new Book("Book 3", 30_000, "Soviet", 1));
        BookSession.addBook(new Book("Book 4", 1000, "Soviet", 20));
        BookSession.addBook(new Book("Book 5", 3000, "Sormovsky", 200));
        BookSession.addBook(new Book("Book 6", 1599, "Kanavinsky", 3));
        BookSession.addBook(new Book("Book 7", 2000, "Prioksky", 1));
        BookSession.addBook(new Book("Book 8", 500, "Avtozavodsky", 30));
        BookSession.addBook(new Book("Book 9", 3000, "Moscow", 10));
        System.out.println("Complete.");
    }

    private static void fillPurchase() {
        System.out.println("Add purchases...");
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-12-01", new ParsePosition(0)), ShopSession.findShopById(10), BuyerSession.findBuyerById(1), BookSession.findBookById(3), 2, 8300));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2019-01-02", new ParsePosition(0)), ShopSession.findShopById(1), BuyerSession.findBuyerById(2), BookSession.findBookById(1), 200, 140_000));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-11-15", new ParsePosition(0)), ShopSession.findShopById(9), BuyerSession.findBuyerById(3), BookSession.findBookById(1), 13, 3500));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-02-05", new ParsePosition(0)), ShopSession.findShopById(2), BuyerSession.findBuyerById(4), BookSession.findBookById(3), 1, 2100));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-01-18", new ParsePosition(0)), ShopSession.findShopById(8), BuyerSession.findBuyerById(6), BookSession.findBookById(8), 40, 80_000));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-09-11", new ParsePosition(0)), ShopSession.findShopById(3), BuyerSession.findBuyerById(5), BookSession.findBookById(4), 2, 60_000));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-08-27", new ParsePosition(0)), ShopSession.findShopById(2), BuyerSession.findBuyerById(8), BookSession.findBookById(9), 4, 4500));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-03-01", new ParsePosition(0)), ShopSession.findShopById(4), BuyerSession.findBuyerById(7), BookSession.findBookById(0), 90, 65_000));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-03", new ParsePosition(0)), ShopSession.findShopById(5), BuyerSession.findBuyerById(0), BookSession.findBookById(8), 1, 2540));
        PurchaseSession.addPurchase(new Purchase(new SimpleDateFormat("yyyy-MM-dd").parse("2018-06-30", new ParsePosition(0)), ShopSession.findShopById(6), BuyerSession.findBuyerById(9), BookSession.findBookById(6), 1, 800));
        System.out.println("Complete.");
    }

}
