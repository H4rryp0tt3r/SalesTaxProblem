package com.twu.salestax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Items {
    private ArrayList<String> typesOfItems;
    private HashMap<String, String[]> itemList;

    public Items() {
        typesOfItems = new ArrayList<>();
        typesOfItems.add("book");
        typesOfItems.add("food");
        typesOfItems.add("medicine");
        itemList = new HashMap<>();
        itemList.put("book", new String[]{"book", "books"});
        itemList.put("food", new String[]{"food", "chocolates", "chocolate"});
        itemList.put("medicine", new String[]{"pill", "headache pills"});
    }

    public String findTypeOf(String givenItem) {
        for (int i = 0; i < typesOfItems.size(); i++) {
            String typeOfItem = typesOfItems.get(i);
            String[] itemsInThatType = itemList.get(typeOfItem);
            for (int j = 0; j < itemsInThatType.length; j++) {
                Pattern pattern = Pattern.compile(""+itemsInThatType[j]+"");
                Matcher matcher = pattern.matcher(givenItem);
                if(matcher.find())
                    return typeOfItem;
            }
        }
        return null;
    }
}
