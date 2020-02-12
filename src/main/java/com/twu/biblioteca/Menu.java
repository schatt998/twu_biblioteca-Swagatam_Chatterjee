package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;



public class Menu {
    private ArrayList<MenuOptions> menuOptions = new ArrayList<>();
    private Library library = new Library();
    private boolean flag = true;
    private Console console;

    public Menu(Console console) {
        this.console = console;
        menuOptions.add(MenuOptions.LIST_OF_BOOKS);
        menuOptions.add(MenuOptions.CHECKOUT);
        menuOptions.add(MenuOptions.RETURN);
        menuOptions.add(MenuOptions.QUIT);

    }

    public String getMenu() {
        return "1." + menuOptions.get(0) + "\n" + "2." + menuOptions.get(1) + "\n" + "3." + menuOptions.get(2) + "\n" + "4." + menuOptions.get(3) + "\n";
    }

    private Book takeInput(Scanner stringScanner, Scanner integerScanner) throws IOException {
        String bookName = console.readLine();
        String authorName = console.readLine();
        int publicationYear = Integer.parseInt(console.readLine());
        return new Book(bookName, authorName, publicationYear);

    }

    public void action(Scanner stringScanner, Scanner integerScanner) throws IOException {
        while (flag) {
            int choice = Integer.parseInt(console.readLine());
            switch (choice) {
                case 1:
                    console.print(getBookList());
                    break;
                case 2:
                    Book requestedBook = takeInput(stringScanner, integerScanner);
                    console.print(checkout(requestedBook));
                    break;
                case 3:
                    Book checkedOutBook = takeInput(stringScanner, integerScanner);
                    console.print(returnBook(checkedOutBook));
                    break;
                case 4:
                    flag = exitApplication();
                    break;
                default:
                    console.print("Please Select a Valid Option!");
            }
        }
    }

    public String getBooksDetails() {

        return library.getBookDetails();

    }


    public String getInvalidChoiceNotification() {
        return "Please Select a Valid Option!";
    }


    public String returnBook(Book book) {
        return library.returnBook(book);
    }

    public String checkout(Book book) {
        return library.checkout(book);


    }

    public boolean exitApplication() {
        return false;
    }

    public String getBookList() {
        return library.getBookList();
    }
}
