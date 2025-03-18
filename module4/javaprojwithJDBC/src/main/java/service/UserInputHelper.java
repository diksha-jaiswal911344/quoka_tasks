package service;

import java.util.Scanner;

public class UserInputHelper {
    private Scanner scanner;

    public UserInputHelper() {
        this.scanner = new Scanner(System.in);
    }

    public int getChoice() {
        while (!scanner.hasNextInt()) {
            System.out.println("❌ Invalid input! Please enter a number.");
            scanner.next(); // Clear invalid input
        }
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        return choice;
    }

    public String[] getUserDetails() {
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Contact: ");
        String contact = scanner.nextLine();
        return new String[]{firstName, lastName, address, contact};
    }

    public int getUserId(String action) {
        System.out.print("Enter User ID to " + action + ": ");
        return getChoice();
    }

    public void closeScanner() {
        scanner.close();
    }
}
