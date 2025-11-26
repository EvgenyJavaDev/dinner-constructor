package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final String NEXT_ITEM_NO_EMPTY = "-1";
    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);

        System.out.println("~".repeat(40));
        System.out.println("            КОНСТРУКТОР ОБЕДОВ");
        System.out.println("~".repeat(40));

        while (true) {
            printMenu();

            String command = scanner.nextLine();

            switch (command) {
                case "1" -> addNewDish();
                case "2" -> generateDishCombo();
                case "3" -> {
                    System.out.println("Программа завершена по команде пользователя.\n"
                            + "Благодарим за использование нашего приложения.");
                    return;
                }
                default -> System.out.println("Извините, такой команды нет. Повторите ввод команды.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("=".repeat(35));
        System.out.println("Выберите команду:");
        System.out.println("1 - Добавить новое блюдо");
        System.out.println("2 - Сгенерировать комбинации блюд");
        System.out.println("3 - Выход");
        System.out.println("=".repeat(35));
        System.out.println();
    }

    private static void addNewDish() {
        System.out.println("Введите тип блюда:");

        String dishType = scanner.nextLine();

        System.out.println("Введите название блюда:");

        String dishName = scanner.nextLine();

        dc.addNewDish(dishType, dishName);
    }

    public static void generateDishCombo() {
        System.out.println("Начинаем конструировать обед...");
        System.out.println("Введите количество наборов, которые нужно сгенерировать:");

        int numberOfCombos = scanner.nextInt();

        scanner.nextLine();
        System.out.println("Вводите типы блюда, разделяя символом переноса строки (enter). Для завершения ввода введите пустую строку");

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
