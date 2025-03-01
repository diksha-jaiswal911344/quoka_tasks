package com.library;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed;

    // constructor
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false;
    }

    // getters and setters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isBorrowed() { return isBorrowed; }

    // borrow book method
    public void borrowBook() { this.isBorrowed = true; }

    // return book method
    public void returnBook() { this.isBorrowed = false; }

    // display book details
    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn + ", Available: " + (!isBorrowed);
    }
}
