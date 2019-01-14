package com.netcracker.students.BatyrkinAndrew.entity;

import javax.persistence.*;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @Column(name = "id_shop")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShop;
    @Column(name = "name")
    private String name;
    @Column(name = "region")
    private String region;
    @Column(name = "commission")
    private double commission;

    public Shop() {
    }

    public Shop(String name, String region, int commission) {
        this.name = name;
        this.region = region;
        this.commission = commission;
    }

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
        this.idShop = idShop;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "idShop=" + idShop +
                ", name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", commission=" + commission +
                '}';
    }

}
