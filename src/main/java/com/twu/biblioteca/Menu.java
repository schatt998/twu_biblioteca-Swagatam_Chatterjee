package com.twu.biblioteca;

import java.util.ArrayList;


public class Menu {
    private ArrayList menuOptions = new ArrayList<>();

    public Menu() {
        menuOptions.add(MenuOptions.LIST_OF_BOOKS);
        menuOptions.add(MenuOptions.CHECKOUT);
    }

    public String getMenu() {
        return "1."+menuOptions.get(0)+"\n"+"2."+menuOptions.get(1)+"\n";
    }
}
