package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    RandomizerDish randomDish = new RandomizerDish();
    HashMap<String, ArrayList<String>> dinnersByType = new HashMap<>();

    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishesForType;

        if (checkDishType(dishType)) {
            dishesForType = dinnersByType.get(dishType);
        } else {

            dishesForType = new ArrayList<>();

            dinnersByType.put(dishType, dishesForType);
        }
        dishesForType.add(dishName);
    }

    public ArrayList<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {

        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        for (int i = 0; i < comboNumber; i++) {
            ArrayList<String> combo = generateCombo(dishTypes);
            combos.add(combo);
        }
        return combos;
    }

    public boolean checkDishType(String checkType) {
        return dinnersByType.containsKey(checkType);
    }

    private ArrayList<String> generateCombo(ArrayList<String> dishTypes) {

        ArrayList<String> selectedDishes = new ArrayList<>();

        for (String dishType : dishTypes) {
            ArrayList<String> availableDishes = dinnersByType.get(dishType);

            String selectedDish = randomDish.getRandomDish(availableDishes);

            selectedDishes.add(selectedDish);
        }
        return selectedDishes;
    }
}
