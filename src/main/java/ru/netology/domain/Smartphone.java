package ru.netology.domain;

public class Smartphone extends Product {
    private String model;
    private String manufacturer;

    public Smartphone(int id, String name, int price, String model, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
        this.model = model;
    }
}
