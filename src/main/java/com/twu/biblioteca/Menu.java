package com.twu.biblioteca;

import java.util.ArrayList;


public class Menu {
    private ArrayList menuOptions = new ArrayList<>();

    public Menu() {
        menuOptions.add(MenuOptions.LIST_OF_BOOKS);
        menuOptions.add(MenuOptions.CHECKOUT);

    }

    public ArrayList<MenuOptions> getOptions() {
        return menuOptions;
    }
}
