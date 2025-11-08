package Utilities;

import java.util.Scanner;

/**
 * Utility
 * ---------------------------------------------------------
 * Provides reusable utility methods for UCMS CLI applications,
 * such as menu display and input prompts.
 *
 * Responsibilities:
 *  - Print formatted menus with borders and centered titles.
 *  - Collect user input for menu selections.
 *  - Provide consistent input prompt formatting.
 */
public class Utility {

    /**
     * Prints a formatted menu with a title and a list of options.
     * Prompts the user to select an option by entering a number.
     *
     * @param title   the menu title to display at the top
     * @param options the array of menu options to display
     * @return the user's selected menu option as an integer
     */
    public static int printMenu(String title, String[] options) {
        int menuWidth = 60; // Total width of menu border

        // Print top border
        System.out.println("=".repeat(menuWidth));

        // Center and print the title
        int padding = (menuWidth - title.length()) / 2;
        System.out.printf("%" + padding + "s%s%n", "", title.toUpperCase());

        // Print bottom border
        System.out.println("=".repeat(menuWidth));

        // Print menu options numbered starting from 1
        for (int i = 0; i < options.length; i++) {
            System.out.printf("    %d. %s%n", i + 1, options[i]);
        }

        // Print bottom border again for separation
        System.out.println("*".repeat(menuWidth));

        // Prompt the user for input
        System.out.print("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
//        int choice = scanner.nextInt(); // Assumes valid integer input
//        return choice;
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println("Please enter a number.");
                continue;
            }

            try {
                int choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= options.length) {
                    return choice;
                } else {
                    System.out.printf("Please enter a number between 1 and %d.%n", options.length);
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid selection. Please enter a valid number (e.g., 1, 2, 3).");
            }
        }


    }

    /**
     * Prints a formatted input prompt with a title.
     * Useful for sections where the user needs to provide input.
     *
     * @param title     the title to display in the prompt
     * @param menuWidth the width of the menu border
     */
    public static void printInputPromptMenu(String title, int menuWidth) {
        // Print top border
        System.out.println("=".repeat(menuWidth));

        // Center and print the title
        int padding = (menuWidth - title.length()) / 2;
        System.out.printf("%" + padding + "s%s%n", "", title.toUpperCase());

        // Print bottom border
        System.out.println("=".repeat(menuWidth));
    }

    /**
     * input validation
     */
     //  Generic line reader (no blank lines allowed)
     public static String readNonEmptyLine(String prompt) {
     java.util.Scanner sc = new java.util.Scanner(System.in);
     while (true) {
     System.out.print(prompt);
     String s = sc.nextLine().trim();
     if (!s.isEmpty()) return s;
     System.out.println("Input cannot be empty. Please try again.");
     }
     }

     //  Letters-only (for First/Last names)
     public static String readAlpha(String prompt) {
     java.util.Scanner sc = new java.util.Scanner(System.in);
     while (true) {
     System.out.print(prompt);
     String s = sc.nextLine().trim();
     if (s.isEmpty()) {
     System.out.println("Input cannot be empty. Please try again.");
     continue;
     }
     // allow spaces/hyphens/apostrophes common in names, but no digits
     if (s.matches("[A-Za-z'\\-\\s]+")) return s;
     System.out.println("Please use letters, spaces, hyphens, or apostrophes only.");
     }
     }

     //  Simple email validator (very basic '@' & '.' )
     public static String readEmail(String prompt) {
     java.util.Scanner sc = new java.util.Scanner(System.in);
     while (true) {
     System.out.print(prompt);
     String s = sc.nextLine().trim();
     if (s.isEmpty()) {
     System.out.println("Email cannot be empty.");
     continue;
     }
     // very light validation; lets your User.setEmail do stricter checks if needed
     if (s.matches("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$")) return s;
     System.out.println("Please enter a valid email address (e.g., name@example.com).");
     }
     }

     // Simple phone validator: digits, spaces, +, -, or ()
     public static String readPhone(String prompt) {
     java.util.Scanner sc = new java.util.Scanner(System.in);
     while (true) {
     System.out.print(prompt);
     String s = sc.nextLine().trim();
     if (s.isEmpty()) {
     System.out.println("Phone cannot be empty.");
     continue;
     }
     if (s.matches("[0-9+()\\-\\s]+")) return s;
     System.out.println("Phone should contain digits and standard symbols (+ - ( ) space).");
     }
     }

     // Password reader: not empty - no complexity check (yet)
     public static String readPassword(String prompt) {
     java.util.Scanner sc = new java.util.Scanner(System.in);
     while (true) {
     System.out.print(prompt);
     String s = sc.nextLine();
     if (!s.trim().isEmpty()) return s;
     System.out.println("Password cannot be empty.");
     }
     }

    public static int readIntInRange(String s, int i, int size) {
         Scanner sc = new Scanner(System.in);
         while (true) {
             System.out.print(s);
             int choice = sc.nextInt();
             if (choice >= i && choice < i + size) {
                 return choice;
             } else {
                 System.out.println("Please enter a number between " + i + " and " + (i + size - 1));
             }
         }
    }
}
