package com.netcracker.students.BatyrkinAndrew.session;

import com.netcracker.students.BatyrkinAndrew.config.SpringConfig;
import com.netcracker.students.BatyrkinAndrew.dao.purchaseDAO.IPurchaseDAO;
import com.netcracker.students.BatyrkinAndrew.entity.Book;
import com.netcracker.students.BatyrkinAndrew.entity.Buyer;
import com.netcracker.students.BatyrkinAndrew.entity.Purchase;
import com.netcracker.students.BatyrkinAndrew.entity.Shop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.Date;
import java.util.List;

public class PurchaseSession {

    static AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static IPurchaseDAO service = (IPurchaseDAO) context.getBean("purchaseDAO");

    public static void deletePurchaseById(int idPurchase) {
        System.out.println("PurchaseSession.deletePurchaseById");
        service.deletePurchaseById(idPurchase);
    }

    public static void updatePurchase(int idPurchase, Date date, Shop shop, Buyer buyer, Book book, int qty, double total) {
        System.out.println("PurchaseSession.updatePurchase");
        service.updatePurchase(idPurchase, date, shop, buyer, book, qty, total);
    }

    public static void addPurchase(Purchase entity) {
        service.savePurchase(entity);
    }

    public static void findAllPurchase() {
        System.out.println("PurchaseSession.findAllPurchase:");
        System.out.println(service.findAllPurchase());
    }

    public static void numberOfRow() {
        System.out.println("PurchaseSession.numberOfRow:");
        System.out.println(service.numberOfRow());
    }

    public static void findPurchaseById(int idPurchase) {
        System.out.println("PurchaseSession.findPurchaseById");
        System.out.println(service.findPurchaseById(idPurchase));
    }

    public static void task2c() {
        System.out.println("PurchaseSession.task2c");
        System.out.println(service.task2c());
    }

    public static void task4a() {
        System.out.println("PurchaseSession.task4a");
        System.out.println(service.task4a());
    }

    public static void task4b() {
        System.out.println("PurchaseSession.task4b");
        System.out.println(service.task4b());
    }

    public static void task5a(double total) {
        System.out.println("PurchaseSession.task5a");
        List<Purchase> list = service.task5a(total);
        for (Purchase p :
                list) {
            System.out.println("Purchase: " + p.getIdPurchase() +
                    " Buyer: " + p.getBuyer().getName()
                    + " DatePurchase: " + p.getDate());
        }
    }

    public static void task5b(int month) {
        System.out.println("PurchaseSession.task5b");
        List<Purchase> list = service.task5b(month);
        for (Purchase purchase :
                list) {
            System.out.println("Buyer: " + purchase.getBuyer().getName()
                    + " ShopName: " + purchase.getShop().getName()
                    + " DatePurchase: " + purchase.getDate());
        }
    }

    public static void task5c(String region, double fromDiscount, double toDiscount) {
        System.out.println("PurchaseSession.task5c");
        List<Purchase> list = service.task5c(region, fromDiscount, toDiscount);
        for (Purchase purchase :
                list) {
            System.out.println("ShopName: " + purchase.getShop().getName());
        }
    }

    public static void task5d() {
        System.out.println("PurchaseSession.task5d");
        List<Purchase> list = service.task5d();
        for (Purchase purchase :
                list) {
            System.out.println("BookName: " + purchase.getBook().getName()
                    + " RegionStorage: " + purchase.getBook().getRegion()
                    + " CountBooks: " + purchase.getQty()
                    + " BookPricePerBook: " + purchase.getBook().getPrice()
                    + " TotalPRice: " + purchase.getTotal());
        }
    }

}
