package com.techelevator;

public class Gum extends Food {
    @Override
    public String foodSound(){
        return "Chew Chew, Yum!";
    }
    public Gum(String location,String name, Double cost,int stock){
        super(location,name,cost,stock);

    }

}
