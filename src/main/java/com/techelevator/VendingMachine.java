package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class VendingMachine extends Inventory {


    private Food totalAvailable = new Food();


    public void runInventory() {


        super.runInventory();

        for (int i = 0; i < getItemListLocation().size(); i++) {

            System.out.println(getItemListLocation().get(i) + " " + getItemListName().get(i) + " " + getItemListCost().get(i));

        }

    }

}





