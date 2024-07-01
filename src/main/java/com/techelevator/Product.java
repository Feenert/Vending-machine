package com.techelevator;

import java.math.BigDecimal;

public class Product {
    private String slot;
    private String name;
    private BigDecimal Price;
    private String type;
    private int amountInStock = 5;
    private boolean isSoldOut = false;

    public Product(String slot, String name, BigDecimal price, String type) {
        this.slot = slot;
        this.name = name;
        this.Price = price;
        this.type = type;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        this.Price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = type;
    }

    public int getAmountInStock() {
        return amountInStock;
    }

    public void setAmountInStock(int amountInStock) {
        this.amountInStock = amountInStock;
    }

    public boolean isSoldOut() {
        return isSoldOut;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSoldOut(boolean soldOut) {
        isSoldOut = soldOut;
    }

    //Takes the current amount in the machine
    public BigDecimal purchase(BigDecimal amount){
        BigDecimal newAmount = new BigDecimal(0.0);

        //Checks if purchase is valid and updates stock and new vending machine amount
        if (!isSoldOut && Price.doubleValue() < newAmount.doubleValue()){
            amountInStock -= 1;

                if (amountInStock == 0){
                    this.isSoldOut = true;
                }

            newAmount = Price.subtract(amount);
            System.out.println("Amount: " + newAmount);
            System.out.println("Name: " + this.name);
            System.out.println("Price: " + this.Price);

            // prints out message based off food type
            if (this.type.equals("Chip")){
                System.out.println("Crunch Crunch, Yum!");
            } else if (this .type.equals("Candy")) {
                System.out.println("Munch Munch, Yum!");
            } else if (this.type.equals("Drink")) {
                System.out.println("Glug Glug, Yum!");
            } else if (this.type.equals("Gum")) {
                System.out.println("Chew Chew, Yum!");
            }
        } else if (isSoldOut) {
            System.out.println("SOLD OUT");
            return amount;
        }
        return newAmount;
    }
}
