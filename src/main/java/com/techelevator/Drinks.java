package com.techelevator;

public class Drinks extends Food{

    @Override
    public String foodSound(){
        return "Glug Glug, Yum!";
    }
    public Drinks(String location,String name, Double cost,int stock){
        super(location,name,cost,stock);

    }

}
