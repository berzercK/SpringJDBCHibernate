package com.netcracker.students.BatyrkinAndrew.session;

import com.netcracker.students.BatyrkinAndrew.config.SpringConfig;
import com.netcracker.students.BatyrkinAndrew.dao.shopDAO.IShopDAO;
import com.netcracker.students.BatyrkinAndrew.entity.Shop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class ShopSession {

    static AbstractApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    static IShopDAO service = (IShopDAO) context.getBean("shopDAO");

    public static void deleteShopById(int idBuyer) {
        service.deleteShopById(idBuyer);
    }

    public static Shop updateShop(int idShop, String name, String region, double commission) {
        System.out.println("ShopSession.updateShop");
        service.updateShop(idShop, name, region, commission);
        return findShopById(idShop);
    }

    public static Shop addShop(Shop entity) {
        System.out.println("ShopSession.addShop");
        service.saveShop(entity);
        return entity;
    }

    public static void findAllShop() {
        System.out.println("ShopSession.findAllShop:");
        System.out.println(service.findAllShop());
    }

    public static void numberOfRow() {
        System.out.println("ShopSession.numberOfRow:");
        System.out.println(service.numberOfRow());
    }

    public static Shop findShopById(int idShop) {
        System.out.println("ShopSession.findShopById:");
        System.out.println(service.findShopById(idShop));
        return service.findShopById(idShop);
    }

    public static void task3b(String[] regions) {
        System.out.println("ShopSession.task3b");
        System.out.println(service.task3b(regions));
    }

}
