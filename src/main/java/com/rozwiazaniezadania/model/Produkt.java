package com.rozwiazaniezadania.model;

public class Produkt {
    private final String name;
    private final Double price;

    public Produkt(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
}
