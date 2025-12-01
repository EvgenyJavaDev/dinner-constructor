package ru.practicum.dinner;

public class Main {

    public static void main(String[] args) {
        CreatorMenu creatorMenu = new CreatorMenu();

        System.out.println("~".repeat(40));
        System.out.println("            КОНСТРУКТОР ОБЕДОВ");
        System.out.println("~".repeat(40));
        creatorMenu.chooseCommand();
    }
}
