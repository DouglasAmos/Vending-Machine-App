package com.techelevator;

import com.techelevator.view.Menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class PurchaseMenu {

    private static final String PURCHASE_MENU_FEED_MONEY = "Feed money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select product";

    private static final String PURCHASE_FINISH_TRANSACTION = "Finish transaction";
    private static final String[] MAIN_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_FINISH_TRANSACTION};

    private VendingMachine purchaseVending = new VendingMachine();
    private Integer moneyInputTotal = 0;
    private final Scanner userInput = new Scanner(System.in);
    private Menu menu = new Menu(System.in, System.out);
    private Food food = new Food();
    private Inventory invList;

    private VendingMachine vm = new VendingMachine();
    private Customer customer = new Customer();
    private Date currentDate = new Date();


    String log = "Log.txt";
    private File logFile = new File(log);
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
    String formattedDate = dateFormat.format(currentDate);


    //public PurchaseMenu(Menu menu) {
    //  this.menu = menu;
    //}

    public void runInventory() {

    }

    public PurchaseMenu(Inventory inv){
        this.invList = inv;
    }

    public void runPurchase() {


        invList.runInventory();
        while (true) {
            String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (choice.equals(PURCHASE_MENU_FEED_MONEY)) {
                // display vending machine items
                System.out.println("Please enter your money.  Bills only please.");

                String moneyInput = userInput.nextLine();
                Double moneyInputDouble = Double.parseDouble(moneyInput);

                if(moneyInputDouble > 10){
                    System.out.println("Please enter $10 or less at a time.");
                }

               else if (moneyInputDouble == 1 || ((moneyInputDouble % 2 == 0)) || ((moneyInputDouble % 3 == 0) || ((moneyInputDouble % 5 == 0)) || ((moneyInputDouble % 7 == 0)))) {


                    Double moneyInputNumber = Double.parseDouble(moneyInput);
                    customer.addMoney(moneyInputNumber);


                    try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile))) {
                        writer.println(formattedDate + " FEED MONEY: $" + moneyInputNumber + " $" + customer.getBalance());
                        // writer.println("Customer change back: " + customer.getBalance());
                    } catch (Exception ex) {
                        System.out.println("Error printing to log.");
                    }


                    System.out.println("Current available funds: " + customer.getBalance());


                } else if (!(moneyInputDouble == 1) || !((moneyInputDouble % 2 == 0)) || !((moneyInputDouble % 3 == 0))) {
                    System.out.println("Please enter whole dollar amounts.");
                }


            } else if (choice.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
                vm.runInventory();

                System.out.println("Please enter item number: ");
                String userSelection = userInput.nextLine();


                Food item = invList.findItem(userSelection);
                while ("Invalid".equals(item.getLocation()) || item.getLocation() == null) {

                    if ("Invalid".equals(item.getLocation())) {
                        System.out.println("Not valid input");
                        System.out.println("Please enter item number: ");
                        userSelection = userInput.nextLine();
                        item = invList.findItem(userSelection);

                    }

                }


                if (item.getStock() > 0) {
                    if (customer.getBalance() >= item.getCost()) {
                        System.out.println(item.foodSound());
                        item.setStock(item.getStock() - 1);
                        item.setStockSold(item.getStockSold() + 1);
                        item.setTotalSale(item.getTotalSale() + item.getCost());
                        System.out.println("You received " + item.getName() + " for " + item.getCost());
                        System.out.println("There is: " + item.getStock() + " left in stock");
                        customer.makePurchase(item.getCost());
                        System.out.println("New balance: " + customer.getBalance());
                    } else {
                        System.out.println("Insufficient funds");
                    }
                } else {
                    System.out.println("Item is out of stock");
                    System.out.println("New balance: " + customer.getBalance());
                }
                try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
                    // writer.println("Customer input: " + moneyInputNumber);
                    writer.println(formattedDate + " " + item.getName() + " " + userSelection + " " + item.getCost() + " " + customer.getBalance());
                } catch (Exception ex) {
                    System.out.println("Error printing to log.");
                }


                if (userSelection.equals(purchaseVending.getItemLocation())) {

                    System.out.println("You have selected: " + purchaseVending.getItemLocation());

                }


                // do purchase
            } else if (choice.equals(PURCHASE_FINISH_TRANSACTION)) {
                int changeToInt = customer.getBalance().intValue();
                customer.makeChange(changeToInt);
                System.out.println("Here is your change total: " + customer.getBalance());
                System.out.println("Here is your change in quarters: " + customer.getTotalQuarters() + " in dimes: " + customer.getTotalDimes() + " in nickles: " + customer.getTotalNickles());

                try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
                    // writer.println("Customer input: " + moneyInputNumber);
                    writer.print(formattedDate + " GIVE CHANGE $" + customer.getBalance());
                } catch (Exception ex) {
                    System.out.println("Error printing to log.");
                }
                customer.resetBalance();

                try (PrintWriter writer = new PrintWriter(new FileOutputStream(logFile, true))) {
                    // writer.println("Customer input: " + moneyInputNumber);
                    writer.print(" $" + customer.getBalance());
                } catch (Exception ex) {
                    System.out.print("Error printing to log.");
                }


                /*
                try(PrintWriter writer = new PrintWriter("Log.txt")){
                    writer.println(moneyInputTotal);
                    writer.println(customer.getBalance());
                } catch(Exception ex){
                    System.out.println("Error printing to log.");
                }

                 */
                break;
            }
        }
    }
}

// if(customer.getBalance()



