package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Console {

        private PrintStream outputStream;
        public Console(PrintStream outputStream) {
            this.outputStream = outputStream;
        }
        public String readLine() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            return bufferedReader.readLine();
        }

}



