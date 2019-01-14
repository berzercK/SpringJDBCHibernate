package com.netcracker.students.BatyrkinAndrew.dao.buyerDAO;

import com.netcracker.students.BatyrkinAndrew.entity.Buyer;

import java.util.List;

public interface IBuyerDAO {

    void deleteBuyerById(int idBuyer);

    void updateBuyer(int idBuyer, String name, String region, double sale);

    void saveBuyer(Buyer entity);

    List<Buyer> findAllBuyer();

    long numberOfRow();

    Buyer findBuyerById(int idBuyer);

    List<Buyer> task2b();

    List<Buyer> task3a(String region);

}
