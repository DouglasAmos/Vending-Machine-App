package com.techelevator;

public class Food {

    private int stock = 5;
    private String makeSound;

    private String location;
    private String name;
    private Double cost;
    private double totalSale;
    private int stockSold;

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public int getStockSold() {
        return stockSold;
    }

    public void setStockSold(int stockSold) {
        this.stockSold = stockSold;
    }

    public String getMakeSound() {
        return makeSound;
    }

    public int getStock() {
        return stock;
    }

    public String foodSound() {
        return "Make a Sound";
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setMakeSound(String makeSound) {
        this.makeSound = makeSound;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Food() {

    }

    public Food(String location, String name, Double cost, int stock) {
        this.location = location;
        this.name = name;
        this.cost = cost;
        this.stock = stock;
        this.totalSale = 0;
        this.stockSold = 0;
    }

//list array of all of the food items - location, price, amount left, name


}
