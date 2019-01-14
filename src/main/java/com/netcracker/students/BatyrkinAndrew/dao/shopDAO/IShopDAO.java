package com.netcracker.students.BatyrkinAndrew.dao.shopDAO;

import com.netcracker.students.BatyrkinAndrew.entity.Shop;

import java.util.List;

public interface IShopDAO {

    void deleteShopById(int idShop);

    void updateShop(int idShop, String name, String region, double commission);

    void saveShop(Shop entity);

    List<Shop> findAllShop();

    long numberOfRow();

    Shop findShopById(int idShop);

    List<Shop> task3b(String[] regions);

}
