package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class CreatorMenu {
    public static final String NEXT_ITEM_NO_EMPTY = "-1";
    Scanner scanner;
    DinnerConstructor dc = new DinnerConstructor();

    CreatorMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addNewDish() {
        System.out.println("Введите тип блюда:");

        String dishType = scanner.nextLine();

        System.out.println("Введите название блюда:");

        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
    }

    public void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");

        int numberOfCombos = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку.");

        String nextItem = NEXT_ITEM_NO_EMPTY;
        ArrayList<String> selectedTypes = new ArrayList<>();

        while (!nextItem.isEmpty()) {
            nextItem = scanner.nextLine();
            if (dc.checkDishType(nextItem)) {
                selectedTypes.add(nextItem);
            } else if (!nextItem.equals("")) {
                System.out.println("Такой тип блюд мы еще не умеем готовить. Попробуйте что-нибудь другое!");
                System.out.println();
            }
        }
        ArrayList<ArrayList<String>> generatedCombos = dc.generateCombos(numberOfCombos, selectedTypes);
        for (int i = 0; i < numberOfCombos; i++) {
            System.out.println("Комбинация " + (i + 1));
            System.out.println(generatedCombos.get(i));
        }
    }
}
