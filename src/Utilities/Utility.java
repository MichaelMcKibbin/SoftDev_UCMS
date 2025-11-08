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
}
