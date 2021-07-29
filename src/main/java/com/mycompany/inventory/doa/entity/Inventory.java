package com.mycompany.inventory.doa.entity;

public class Inventory {

    private int id;
    private String item;
    private int bought;
    private int sold;

    public Inventory(String item, int bought, int sold) {
        this.item = item;
        this.bought = bought;
        this.sold = sold;
    }

    public Inventory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getBought() {
        return bought;
    }

    public void setBought(int bougth) {
        this.bought = bougth;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    
    @Override
    public String toString() {
        return "Inventory{" + "id=" + id + ", item=" + item + ", bougth=" + bought + ", sold=" + sold + '}';
    }

}
