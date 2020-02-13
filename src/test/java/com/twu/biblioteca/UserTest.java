package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void shouldReturnTrueIfUserIsLoggedIn() {
        User user = new User("222-3333","Jiko");

        user.logIn();

        Assertions.assertTrue(user.getStatus());

    }
}