package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void shouldReturnNameOfTheBook() {
        Book book = new Book("Calculus Made Easy", "Silvanus P.", 2003);
        String expectedName = "Calculus Made Easy\n";

        String actualName = book.getName();

        Assertions.assertEquals(expectedName, actualName);
    }
}