package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenu = new HashMap<>();
    ArrayList<String> contentOfType = new ArrayList<>();
    Random random = new Random();
    int randomNumb = random.nextInt();

    public void addNewDinner(String dishType, String dishName) {
        if (dinnerMenu.containsKey(dishType)) {
            contentOfType = dinnerMenu.get(dishType);
            contentOfType.add(dishName);
        } else {
            ArrayList<String> contentOfType = new ArrayList<>();
            contentOfType.add(dishName);
            dinnerMenu.put(dishType, contentOfType);
        }
        System.out.println(dinnerMenu);
    }

    public void generateDinner(String nextItem, int numberOfCombos) {
        for (int i = 0; i < numberOfCombos; i++) {
            contentOfType = dinnerMenu.get(nextItem);
            String randomDish = contentOfType.get(random.nextInt(contentOfType.size()));

            HashMap<String, ArrayList<String>> generatedMenu = new HashMap<>();
            ArrayList<String> generatedList = new ArrayList<>();

            generatedList.add(randomDish);
            generatedMenu.put(nextItem, generatedList);
            generatedList = generatedMenu.get(nextItem);
            System.out.println("Комбо " + (i + 1));
            System.out.println(generatedList);
        }
    }

}
