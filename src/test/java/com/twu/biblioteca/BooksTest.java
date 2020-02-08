package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BooksTest {

    @Test
    void shouldReturnNameOfTheBook() {
        Books book = new Books("Calculus Made Easy","Silvanus P.",2003);
        String expectedName="Calculus Made Easy\n";
        String actualName=book.getName();
        Assertions.assertEquals(expectedName,actualName);
    }
}