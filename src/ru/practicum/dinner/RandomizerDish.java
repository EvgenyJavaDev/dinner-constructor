package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Random;

public class RandomizerDish {
    Random random = new Random();

    public String getRandomDish(ArrayList<String> availableDishes) {
        int numberOfDishesForType = availableDishes.size();
        int dishIndex = random.nextInt(numberOfDishesForType);
        String selectedDish = availableDishes.get(dishIndex);

        return selectedDish;
    }
}
