package ru.practicum.dinner;

import java.util.Scanner;

public class Main {
    static DinnerConstructor dc;
    static Scanner scanner;

    public static void main(String[] args) {
        dc = new DinnerConstructor();
        scanner = new Scanner(System.in);
        CreatorMenu creatorMenu = new CreatorMenu(scanner);

        System.out.println("~".repeat(40));
        System.out.println("            КОНСТРУКТОР ОБЕДОВ");
        System.out.println("~".repeat(40));

        while (true) {
            printMenu();

            String command = scanner.nextLine();

            switch (command) {
                case "1" -> creatorMenu.addNewDish();
                case "2" -> creatorMenu.generateDishCombo();
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
}
