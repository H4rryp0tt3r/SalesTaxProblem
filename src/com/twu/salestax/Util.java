package com.twu.salestax;

public class Util {

    public static double calculateTax(double amount, int taxPercentage) {
        double taxValue = (amount/100.0)*taxPercentage;
        double totalValue = amount + taxValue;
        return Math.round(totalValue*100.0)/100.0;
    }
}
