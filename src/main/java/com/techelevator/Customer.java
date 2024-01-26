package com.techelevator;

public class Customer {

    //how much money they put in
    //change
    //selection
    private Double balance;
    private String selections;

    private Integer totalChange = 0;
    private Integer totalQuarters = 0;
    private Integer totalDimes = 0;
    private Integer totalNickles = 0;

    public Integer getTotalChange() {
        return totalChange;
    }

    public Integer getTotalQuarters() {
        return totalQuarters;
    }

    public Integer getTotalDimes() {
        return totalDimes;
    }

    public Integer getTotalNickles() {
        return totalNickles;
    }

    public Double getBalance() {
        return balance;
    }

    public String getSelections() {
        return selections;
    }

    public void setSelections(String selections) {
        this.selections = selections;
    }

    public Customer() {
        balance = 0.0;
    }

    public void addMoney(Double money) {
        balance += money;

    }

    public void makePurchase(Double cost) {
        if (balance >= cost) {
            balance -= cost;
        } else {
            System.out.println("You do not have enough money");
        }

    }

    public void resetBalance() {
        balance = 0.0;
    }

    public void makeChange(int change) {


        Double coinValue = balance * 100;
        while (coinValue >= 25) {
            coinValue -= 25;
            totalQuarters++;
        }
        while (coinValue >= 10) {

            coinValue -= 10;
            totalDimes++;

        }
        while (coinValue >= 5) {
            coinValue -= 5;
            totalNickles++;
        }


    }


}
