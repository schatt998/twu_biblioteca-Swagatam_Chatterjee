package com.twu.biblioteca;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;



class ConsoleTest {

    @Test
    void shouldTakeDesiredInput() throws IOException {
        String expectedInput = "1";
        Console console = new Console(System.out);
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Assertions.assertEquals(expectedInput,console.readLine());
    }



}