package com.twu.biblioteca;

import java.util.Iterator;
import java.util.Objects;

public class Book implements Item {
    private String name;
    private String authorName;
    private int publicationYear;

    public Book(String name, String authorName, int publicationYear) {
        this.name = name;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
    }

    public String getDetails() {
        return this.name + "|" + this.authorName + "|" + this.publicationYear + "\n";
    }

    public String getName() {
        return this.name + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return publicationYear == book.publicationYear &&
                name.equals(book.name) &&
                authorName.equals(book.authorName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorName, publicationYear);
    }
}
