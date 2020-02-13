package com.twu.biblioteca;

import java.util.Objects;

public class User{
    private String libraryId;
    private String password;
    private Boolean status;

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

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return libraryId.equals(user.libraryId) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryId, password, status);
    }
}
