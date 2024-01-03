package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerMenu = new HashMap<>();
    HashMap<Integer, ArrayList<String>> generatedMenu = new HashMap<>();
    ArrayList<String> contentOfType = new ArrayList<>();
    Random random = new Random();

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

            ArrayList<String> generatedList = generatedMenu.getOrDefault(i, new ArrayList<>());
            generatedList.add(randomDish);
            generatedMenu.put(i, generatedList);
        }
    }

    public void printCombos() {
        for (Map.Entry<Integer, ArrayList<String>> entry : generatedMenu.entrySet()) {
            int number = entry.getKey() + 1;
            System.out.println("Комбо # " + number);
            System.out.println(entry.getValue());
        }
        generatedMenu = new HashMap<>();
    }
}
