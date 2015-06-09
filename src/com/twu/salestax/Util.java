package com.twu.salestax;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    public static double calculateTax(double amount, int taxPercentage) {
        double taxValue = (amount / 100.0) * taxPercentage;
        double totalValue = amount + taxValue;
        return Math.round(totalValue * 100.0) / 100.0;
    }

    public static ArrayList<String> parseString(String line) {
        ArrayList<String> result = new ArrayList<>();
        String[] data = line.split(" at ");
        String[] anotherData = data[0].split(" ");
        result.add(anotherData[0]);
        result.add(arrayToString(anotherData));
        result.add(data[1]);
        return result;
    }

    private static String arrayToString(String[] anotherData) {
        String result = "";
        for (int i = 1; i < anotherData.length; i++) {
            result += anotherData[i] + " ";
        }
        return result.replaceAll("\\s+$", "");
    }

    public static Boolean isImported(String itemName) {
        Pattern pattern = Pattern.compile("imported");
        Matcher matcher = pattern.matcher(itemName);
        return (matcher.find())?true:false;
    }
}
