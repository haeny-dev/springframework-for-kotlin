package com.haeny.lec18.java;

public class Fruit {

    private Long id;
    private final String name;
    private int price;

    private Long factoryPrice;
    private Long currentPrice;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Fruit(Long id, String name, Long factoryPrice, Long currentPrice) {
        this.id = id;
        this.name = name;
        this.factoryPrice = factoryPrice;
        this.currentPrice = currentPrice;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Long getFactoryPrice() {
        return factoryPrice;
    }

    public Long getCurrentPrice() {
        return currentPrice;
    }

    public void nullOrValue() {}
}
