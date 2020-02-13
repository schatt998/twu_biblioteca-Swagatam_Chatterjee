package com.twu.biblioteca;

import java.io.IOException;

public class DriverClass {

    public static void main(String[] args) throws IOException {
        User user = new User("222-3333","233");
        BibliotecaApp bibliotecaApp = new BibliotecaApp(user);
        bibliotecaApp.start();
    }
}
