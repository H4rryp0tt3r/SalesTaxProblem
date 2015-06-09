package com.twu.salestax;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class SalesTaxProblem {

    private final Items itemsData;

    public SalesTaxProblem(Items items) {
        this.itemsData = items;
    }

    public void printReceipt() {
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        double totalSalesTaxes = 0.0;
        double totalAmount = 0.0;
        while (stdin.hasNext()) {
            double itemPrice = 0.0;
            String item = stdin.nextLine();
            ArrayList<String> details = Util.parseString(item);
            String noOfItems = details.get(0);
            String itemName = details.get(1);
            double actualPrice = Double.parseDouble(details.get(2));
            itemPrice += actualPrice;
            if(itemsData.findTypeOf(itemName) == null) {
                double taxOfItem = Util.calculateTax(itemPrice,10);
                itemPrice += taxOfItem;
                totalSalesTaxes += taxOfItem;
            }
            if(Util.isImported(itemName)) {
                double importTaxOnItem = Util.calculateTax(actualPrice, 5);
                itemPrice += importTaxOnItem;
                totalSalesTaxes += importTaxOnItem;
            }
            totalAmount += itemPrice;
            System.out.println(noOfItems+" "+itemName+" : "+Math.round(itemPrice*100.0)/100.0);
        }
        System.out.println("Sales Taxes : "+Math.round(totalSalesTaxes*100.0)/100.0);
        System.out.println("Total : "+Math.round(totalAmount*100.0)/100.0);
    }
}
