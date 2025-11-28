package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;

public class DinnerConstructor {
    RandomizerDish randomDish = new RandomizerDish();
    HashMap<String, ArrayList<String>> dinnersByType = new HashMap<>();

    public void addNewDish(String dishType, String dishName) {
        ArrayList<String> dishesForType = new ArrayList<>();

        if (checkDishType(dishType)) {
            dishesForType = dinnersByType.get(dishType);
        } else {
            dinnersByType.put(dishType, dishesForType);
            System.out.println("Вы внесли новый тип блюда в меню.");
        }
        if (checkDishName(dishType, dishName)) {
            dishesForType.add(dishName);
            System.out.println("Вы внесли новое  наименование блюда  в меню.");
        } else {
            System.out.println("Такое наименование блюда уже существует, вы его вносили в меню ранее.");
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> generateCombos(int comboNumber, ArrayList<String> dishTypes) {
        ArrayList<ArrayList<String>> combos = new ArrayList<>();

        for (int i = 0; i < comboNumber; i++) {
            ArrayList<String> combo = generateCombo(dishTypes);
            combos.add(combo);
        }
        return combos;
    }

    private boolean checkDishName(String dishType, String dishName) {
        boolean isNoContains = true;
        ArrayList<String> name = dinnersByType.get(dishType);

        for (String dish : name) {
            if (dish.equals(dishName)) {
                isNoContains = false;
                break;
            }
        }
        return isNoContains;
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
