package com.twu.biblioteca;

public class Books {
    private String name;
    private String authorName;
    private int publicationYear;

    public Books(String name, String authorName, int publicationYear) {
        this.name = name;
        this.authorName = authorName;
        this.publicationYear = publicationYear;
    }

    public String getDetails() {
        return this.name + "|" + this.authorName + "|" + this.publicationYear + "\n";
    }
    public String getName(){
        return this.name+"\n";
    }

}
