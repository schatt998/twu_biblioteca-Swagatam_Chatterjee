package com.twu.biblioteca;

import java.util.ArrayList;


public class Menu {
    private ArrayList menuOptions = new ArrayList<>();

    public Menu() {
        menuOptions.add(MenuOptions.LIST_OF_BOOKS);
        menuOptions.add(MenuOptions.CHECKOUT);
        menuOptions.add(MenuOptions.RETURN);
        menuOptions.add(MenuOptions.QUIT);
    }

    public String getMenu() {
        return "1." + menuOptions.get(0) + "\n" + "2." + menuOptions.get(1) + "\n" + "3." + menuOptions.get(2) + "\n" + "4." + menuOptions.get(3) + "\n";
    }
}
