package com.library;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Library {
    private List<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Add book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            books.forEach(System.out::println); // Using Streams to display books
        }
    }

    // Search for books by title
    public void searchBook(String title) {
        List<Book> foundBooks = books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());

        if (foundBooks.isEmpty()) {
            System.out.println("No books found with title: " + title);
        } else {
            foundBooks.forEach(System.out::println);
        }
    }

    // Borrow a book
    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isBorrowed()) {
                book.borrowBook();
                System.out.println("You borrowed: " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available or does not exist.");
    }

    // Return a book
    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isBorrowed()) {
                book.returnBook();
                System.out.println("You returned: " + book.getTitle());
                return;
            }
        }
        System.out.println("Invalid return. Book is not borrowed.");
    }

    public void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("library.txt"))) {
            for (Book book : books) {
                writer.println(book.getTitle() + "," + book.getAuthor() + "," + book.getIsbn() + "," + book.isBorrowed());
            }
            System.out.println("Library data saved to file.");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        books.clear(); // Clear the list before loading to prevent duplicates
        try (BufferedReader reader = new BufferedReader(new FileReader("library.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {  // Ensure correct format
                    Book book = new Book(parts[0], parts[1], parts[2]);
                    if (Boolean.parseBoolean(parts[3])) {
                        book.borrowBook();
                    }
                    books.add(book);
                }
            }
            System.out.println("Library data loaded from file.");
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }
}