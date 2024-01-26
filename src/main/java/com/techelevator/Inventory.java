package com.techelevator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {


    private Food totalAvailable = new Food();
    private String itemLocation;
    private String itemName;
    private String itemCost;
    private List<String> itemListLocation = new ArrayList<>();

    private List<Food> listFood = new ArrayList<>();
    private List<String> itemListCost = new ArrayList<>();
    private List<String> itemListName = new ArrayList<>();

    public List<String> getItemListLocation() {
        return itemListLocation;
    }

    public List<String> getItemListCost() {
        return itemListCost;
    }

    public List<String> getItemListName() {
        return itemListName;
    }


    private String[] inv;

    public String[] getInv() {
        return inv;
    }

    public String getItemLocation() {
        return itemLocation;
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemCost() {
        return itemCost;
    }

    public List<Food> getListFood() {
        return listFood;
    }

    String fileName = "vendingmachine.csv";

    File file = new File(fileName);


    public void runInventory() {

        try (Scanner fileReader = new Scanner(file)) {

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();

                inv = line.split("\\|");


                itemListLocation.add(inv[0]);
                itemListName.add(inv[1]);
                itemListCost.add(inv[2]);
                int defaultStock = 5;


                if (inv[3].equals("Chip")) {
                    listFood.add(new Chips(inv[0], inv[1], Double.parseDouble(inv[2]), defaultStock));
                } else if (inv[3].equals("Candy")) {
                    listFood.add(new Candy(inv[0], inv[1], Double.parseDouble(inv[2]), defaultStock));
                } else if (inv[3].equals("Drink")) {
                    listFood.add(new Drinks(inv[0], inv[1], Double.parseDouble(inv[2]), defaultStock));
                } else if (inv[3].equals("Gum")) {
                    listFood.add(new Gum(inv[0], inv[1], Double.parseDouble(inv[2]), defaultStock));
                }


                itemLocation = inv[0];
                itemName = inv[1];
                itemCost = inv[2];


            }


        } catch (Exception ex) {

            System.out.println("Unable to read file.");
        }


    }

    public Food findItem(String slotNum) {

        for (Food food : listFood) {
            if (food.getLocation().equals(slotNum)) {
                return food;
            }

        }
        Food notFound = new Food();
        notFound.setLocation("Invalid");

        return notFound;


    }

}
