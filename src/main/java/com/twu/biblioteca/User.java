package com.twu.biblioteca;

public class User{
    private String libraryId;
    private String password;
    private Boolean status;
    private Library library=new Library();

    public User(String libraryId, String password) {
        this.libraryId = libraryId;
        this.password = password;
    }

    public void logIn()
    {
           status=true;
    }
    public boolean getStatus(){
        return status;
    }
}
