package com.techelevator;

import org.w3c.dom.ls.LSOutput;

public class Chips extends Food {
    @Override
    public String foodSound(){
        return "Crunch Crunch, Yum!";
    }

    public Chips(String location,String name, Double cost, int stock){
        super(location,name,cost,stock);

    }
}
