package com.library;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // adding sample books
        library.addBook(new Book("Java Programming", "Rock Paper", "1234"));
        library.addBook(new Book("Data Structures", "Scissor Water", "5678"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Books");
            System.out.println("2. Search Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Add Book");
            System.out.println("6. Exit and Save");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline


            switch (choice) {
                case 1:
                    library.loadFromFile();
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    library.searchBook(title);
                    break;
                case 3:
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    library.borrowBook(borrowIsbn);
                    break;
                case 4:
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    library.returnBook(returnIsbn);
                    break;
                case 5:
                    System.out.print("Enter book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String newAuthor = scanner.nextLine();
                    System.out.print("Enter ISBN: ");
                    String newIsbn = scanner.nextLine();
                    library.addBook(new Book(newTitle, newAuthor, newIsbn));
                    break;
                case 6:
                    library.saveToFile(); // save before exiting
                    System.out.println("Exiting... library data saved.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
