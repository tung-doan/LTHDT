package datastructure;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainMenu {

    private String[] options = { "1. Stack", "2. List", "3. Queue", "4. Exit" };
    private Scanner scanner = new Scanner(System.in);

    // Hiển thị menu chính
    public void displayMenu() {
        System.out.println("_____ Main Menu _____");
        for (String option : options) {
            System.out.println(option);
        }
        System.out.println("_____________________");
    }

    // Xử lý tùy chọn của người dùng
    public void handleUserInput() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.print("Please select an option (1-4): ");
            try {
                int choice = scanner.nextInt(); // Đọc lựa chọn của người dùng
                switch (choice) {
                    case 1:
                        handleStackMenu();
                        break;
                    case 2:
                        handleListMenu();
                        break;
                    case 3:
                        handleQueueMenu();
                        break;
                    case 4:
                        System.out.println("Exiting the application. Goodbye!");
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); 
            }
        }
    }

    // Stack
    private void handleStackMenu() {
        Stack stack = new Stack(10);
        stack.create();

        boolean stackMenuRunning = true;
        while (stackMenuRunning) {
            System.out.println("\n_____ Stack Menu _____");
            System.out.println("1. Push an element");
            System.out.println("2. Pop an element");
            System.out.println("3. Peek at the top element");
            System.out.println("4. Display stack");
            System.out.println("5. Go back to Main Menu");
            System.out.print("Please select an option (1-5): ");

            try {
                int stackChoice = scanner.nextInt();
                switch (stackChoice) {
                    case 1:
                        System.out.print("Enter an element to push: ");
                        int element = scanner.nextInt();
                        stack.push(element);
                        System.out.println("Element pushed successfully.");
                        break;
                    case 2:
                        stack.pop();
                        System.out.println("Element popped successfully.");
                        break;
                    case 3:
                        System.out.println("Top element: " + stack.peek());
                        break;
                    case 4:
                        System.out.println("Stack contents:");
                        stack.display();
                        break;
                    case 5:
                        stackMenuRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // List
    private void handleListMenu() {
        List list = new List(10);
        list.create();

        boolean listMenuRunning = true;
        while (listMenuRunning) {
            System.out.println("\n_____ List Menu _____");
            System.out.println("1. Insert an element");
            System.out.println("2. Delete an element");
            System.out.println("3. Display the list");
            System.out.println("4. Sort the list");
            System.out.println("5. Go back to Main Menu");
            System.out.print("Please select an option (1-5): ");

            try {
                int listChoice = scanner.nextInt();
                switch (listChoice) {
                    case 1:
                        System.out.print("Enter an element to insert: ");
                        int element = scanner.nextInt();
                        list.insert(element);
                        System.out.println("Element inserted successfully.");
                        break;
                    case 2:
                        System.out.print("Enter an element to delete: ");
                        int deleteElement = scanner.nextInt();
                        list.delete(deleteElement);
                        System.out.println("Element deleted successfully.");
                        break;
                    case 3:
                        System.out.println("List contents:");
                        list.display();
                        break;
                    case 4:
                        list.sort();
                        System.out.println("List sorted successfully.");
                        break;
                    case 5:
                        listMenuRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose between 1 and 5.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    // Queue (bổ sung sau)
    private void handleQueueMenu() {
        boolean queueMenuRunning = true;
        while (queueMenuRunning) {
            System.out.println("\n_____ Queue Menu _____");
            System.out.println("1. Go back to Main Menu");
            System.out.print("Please select an option (1): ");

            try {
                int queueChoice = scanner.nextInt();
                switch (queueChoice) {
                    case 1:
                        queueMenuRunning = false;
                        break;
                    default:
                        System.out.println("Invalid option. Please choose 1 to go back to Main Menu.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
    }

    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        mainMenu.handleUserInput();
    }
}
