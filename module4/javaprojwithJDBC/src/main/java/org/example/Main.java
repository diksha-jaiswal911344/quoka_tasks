package org.example;

import service.UserService;
import service.UserInputHelper;

public class Main {
    private final UserService userService;
    private final UserInputHelper userInputHelper;

    public Main() {
        this.userService = new UserService();
        this.userInputHelper = new UserInputHelper();
    }

    public void run() {
        int choice;
        do {
            displayMenu();
            choice = userInputHelper.getChoice();

            switch (choice) {
                case 1:
                    insertUser();
                    break;
                case 2:
                    updateUser();
                    break;
                case 3:
                    deleteUser();
                    break;
                case 4:
                    userService.displayUsers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    userInputHelper.closeScanner();
                    break;
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        } while (choice != 5);
    }

    private void displayMenu() {
        System.out.println("\n1. Insert User");
        System.out.println("2. Update User");
        System.out.println("3. Delete User");
        System.out.println("4. Display Users");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private void insertUser() {
        String[] userDetails = userInputHelper.getUserDetails();
        userService.insertUser(userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
    }

    private void updateUser() {
        int userId = userInputHelper.getUserId("update");
        String[] userDetails = userInputHelper.getUserDetails();
        userService.updateUser(userId, userDetails[0], userDetails[1], userDetails[2], userDetails[3]);
    }

    private void deleteUser() {
        int userId = userInputHelper.getUserId("delete");
        userService.deleteUser(userId);
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.run();
    }
}
