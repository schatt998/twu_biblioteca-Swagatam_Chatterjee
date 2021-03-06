package com.twu.biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Menu {
    private ArrayList<MenuOptions> menuOptions = new ArrayList<>();
    private Library bookLibrary = new Library();
    private Library movieLibrary = new Library();
    private Library library = new Library();
    private boolean flag = true;
    private Console console;
    private Movie movie;
    private Book book;
    private User currentUser;

    public Menu(Console console) {
        this.console = console;
        menuOptions.add(MenuOptions.LIST_OF_BOOKS);
        menuOptions.add(MenuOptions.CHECKOUT);
        menuOptions.add(MenuOptions.RETURN);
        menuOptions.add(MenuOptions.QUIT);
        menuOptions.add(MenuOptions.LIST_OF_MOVIES);
        menuOptions.add(MenuOptions.CHECK_OUT_MOVIES);
        menuOptions.add(MenuOptions.RETURN_MOVIES);
        menuOptions.add(MenuOptions.SEE_YOUR_PROFILE);

    }


    public String getMenu() {
        return "1." + menuOptions.get(0) + "\n" + "2." + menuOptions.get(1) + "\n" + "3." + menuOptions.get(2) + "\n" + "4." + menuOptions.get(3) + "\n5." + menuOptions.get(4) + "\n6." + menuOptions.get(5) + "\n7." + menuOptions.get(6) + "\n8." + menuOptions.get(7) + "\n";
    }

    private Book takeInput(Scanner stringScanner, Scanner integerScanner) throws IOException {
        String bookName = console.readLine();
        String authorName = console.readLine();
        int publicationYear = Integer.parseInt(console.readLine());
        return new Book(bookName, authorName, publicationYear);

    }

    private Movie takeInput3(Scanner stringScanner, Scanner integerScanner) throws IOException {
        String bookName = console.readLine();
        String authorName = console.readLine();
        String authorName2 = console.readLine();
        String authorName3 = console.readLine();

        return new Movie(bookName, authorName, authorName2, authorName3);

    }

    private void askAndGetUserCredentials() throws IOException {

        console.print("Enter Your Log-In ID and Password \n");

    }

    private boolean isValid(String userCredentials) {
        if (userCredentials.equals("xxx-xxxx|234"))
            return true;
        else
            return false;
    }

    public void action(Scanner stringScanner, Scanner integerScanner, User user) throws IOException {
        while (flag) {
            int choice = Integer.parseInt(console.readLine());
            switch (choice) {
                case 1:
                    console.print(getBookList());
                    break;
                case 2:
                    askAndGetUserCredentials();
                    currentUser = getUser();
                    if (library.logIn(user)) {
                        console.print("Logged In Successful");
                        console.print("Request Book Here");
                        Book requestedBook = takeInput(stringScanner, integerScanner);
                        console.print(checkoutBook(requestedBook, user));
                    }
                    break;
                case 3:
                    askAndGetUserCredentials();
                    currentUser = getUser();
                    if (library.logIn(user)) {
                        console.print("Logged In Successful");
                        console.print("Request Book Here");
                        Book requestedBook = takeInput(stringScanner, integerScanner);
                        console.print(returnItem(requestedBook, user));
                    }
                    break;
                case 4:
                    flag = exitApplication();
                    break;
                case 5:
                    console.print(getMovieList());
                    break;
                case 6:
                    Movie requestedMovie = takeInput3(stringScanner, integerScanner);
                    console.print(checkoutMovie(requestedMovie));
                    break;
                case 7:
                    Movie movie = takeInput3(stringScanner, integerScanner);
                    console.print(returnItem(movie));
                    break;
                case 8:
                    askAndGetUserCredentials();
                    currentUser = getUser();
                    if (library.logIn(user)) {
                        user.showProfile(console);
                    } else
                        console.print("Must Be Logged In To See Your Profile Details");
                    break;
                default:
                    console.print("Please Select a Valid Option!");
            }
        }
    }

    private User getUser() throws IOException {
        return new User(console.readLine(), console.readLine());
    }


    public String getInvalidChoiceNotification() {
        return "Please Select a Valid Option!";
    }


    public String returnItem(Book book, User user) {
        return library.returnBook(book, user);
    }

    public String returnItem(Movie movie) {
        return library.returnMovie(movie);
    }

    public String checkoutBook(Book book, User user) {
        return library.checkoutBook(book, user);


    }

    public String checkoutMovie(Movie book) {
        return library.checkoutMovie(book);


    }

    public boolean exitApplication() {
        return false;
    }

    public String getBookList() {
        return library.getBookList();
    }

    public String getMovieList() {
        return library.getMovieList();
    }
}
