package com.twu.biblioteca;


import java.util.Scanner;


public class BibliotecaApp {


    private Library library;

    private Menu menu;
    Scanner stringScanner = new Scanner(System.in);
    Scanner integerScanner = new Scanner(System.in);


    public BibliotecaApp() {
        this.library = new Library();
        this.menu = new Menu();
    }

    public void start() {
        System.out.println(showWelcomeMessage());
        System.out.println(showMenu());

        while (true) {
            int choice = stringScanner.nextInt();
            switch (choice) {
                case 1:
                    getBookList();
                    break;
                case 2:
                    String bookName = integerScanner.nextLine();
                    String authorName = integerScanner.nextLine();
                    int publicationYear = stringScanner.nextInt();
                    Book requestedBook = new Book(bookName, authorName, publicationYear);
                    System.out.println(checkout(requestedBook));
                    break;
                case 3:
                    String bookName1 = integerScanner.nextLine();
                    String authorName1 = integerScanner.nextLine();
                    int publicationYear1 = stringScanner.nextInt();
                    Book checkedOutBook = new Book(bookName1, authorName1, publicationYear1);
                    System.out.println(returnBook(checkedOutBook));
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println(getInvalidChoiceNotification());
            }
        }
    }

    public String showWelcomeMessage() {
        return "Welcome To Biblioteca.Your one-stop-shop for great book titles in Bangalore";
    }


    public String showMenu() {
        return menu.getMenu();
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

    public String getBookList() {
        return library.getBookList();
    }



}
