/*
 * SPDX-License-Identifier: MIT
 * Author: Matthieu Perrin  
 */

package concurrence.utils;

import javax.swing.JOptionPane;

/**
 * Utility tool to read from an arguments list, or asks the user via a small dialog box if the argument is missing.
 */
public final class ParseArgs {

    private ParseArgs() { /* utility class */ }

    /**
     * Reads an integer from args[index], or asks the user via a small dialog box.
     * @param args   command-line arguments (usually from main)
     * @param index  index of the argument to read
     * @param prompt message shown if no argument is provided
     * @param defaultValue value prefilled in the dialog box
     * @return parsed integer
     */
    public static int getInt(String[] args, int index, String prompt, int defaultValue) {
        if (args != null && args.length > index) {
            try {
                return Integer.parseInt(args[index]);
            } catch (NumberFormatException e) {
                System.err.println("Invalid integer argument: " + args[index]);
            }
        }

        // Ask the user interactively
        String input = JOptionPane.showInputDialog(
                null,
                prompt,
                Integer.toString(defaultValue)
        );
        if (input == null) { // cancel
            System.out.println("Cancelled.");
            System.exit(0);
        }
        return Integer.parseInt(input.trim());
    }

    /**
     * Simpler overload with a generic prompt and default=0.
     */
    public static int getInt(String[] args, int index) {
        return getInt(args, index, "Enter an integer value:", 0);
    }
}
