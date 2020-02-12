package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private ArrayList menuOptions = new ArrayList<>();
    private Library library = new Library();
    private boolean flag=true;

    public Menu() {
        menuOptions.add(MenuOptions.LIST_OF_BOOKS);
        menuOptions.add(MenuOptions.CHECKOUT);
        menuOptions.add(MenuOptions.RETURN);
        menuOptions.add(MenuOptions.QUIT);

    }

    public String getMenu() {
        return "1." + menuOptions.get(0) + "\n" + "2." + menuOptions.get(1) + "\n" + "3." + menuOptions.get(2) + "\n" + "4." + menuOptions.get(3) + "\n";
    }
    private static  Book takeInput(Scanner stringScanner, Scanner integerScanner){
        String bookName = integerScanner.nextLine();
        String authorName = integerScanner.nextLine();
        int publicationYear = stringScanner.nextInt();
        return new Book(bookName, authorName, publicationYear);

    }

    public void action(Scanner stringScanner, Scanner integerScanner) {
        while (flag) {
            int choice = stringScanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(getBookList());
                    break;
                case 2:
                    Book requestedBook = takeInput(stringScanner, integerScanner);
                    System.out.println(checkout(requestedBook));
                    break;
                case 3:
                    Book checkedOutBook = takeInput(stringScanner, integerScanner);
                    System.out.println(returnBook(checkedOutBook));
                    break;
                case 4:
                    flag=exitApplication();
                    break;
                default:
                    System.out.println(getInvalidChoiceNotification());
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
    public boolean exitApplication(){
        return false;
    }

    public String getBookList() {
        return library.getBookList();
    }
}
