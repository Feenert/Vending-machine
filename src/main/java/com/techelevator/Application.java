package com.techelevator;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Application {

	public static void main(String[] args) {
        // map to store product objects, can call and object using the slot value as the key
        // EX. productList.get("A1")
        Map<String, Product> productList = new HashMap<String, Product>();

        //Reads vendingmachine.csv and populates map productList map
		String productInfo = "";
        try (BufferedReader inventoryData = new BufferedReader(new FileReader("vendingmachine.csv"))) {
            while ((productInfo = inventoryData.readLine()) != null) {
                String[] productArray = productInfo.split("\\|");
                BigDecimal price = new BigDecimal(productArray[2]);
                productList.put(productArray[0], new Product(productArray[0], productArray[1],
                        price, productArray[3]));

            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        productList.get("A1").purchase(amount);
    }
}
