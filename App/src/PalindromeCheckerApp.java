import java.util.Scanner;

public class PalindromeCheckerApp {


        static class PalindromeChecker {

            private String text;

            // Constructor to initialize the string
            public PalindromeChecker(String text) {
                this.text = text;
            }

            // Method to check if the string is a palindrome
            public boolean checkPalindrome() {
                if (text == null) {
                    return false;
                }

                // Normalize string (optional: ignore spaces & case)
                String normalized = text.replaceAll("\\s+", "").toLowerCase();

                int start = 0;
                int end = normalized.length() - 1;

                while (start < end) {
                    if (normalized.charAt(start) != normalized.charAt(end)) {
                        return false;
                    }
                    start++;
                    end--;
                }

                return true;
            }
        }

        // Main method
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a string to check if it is a palindrome:");
            String input = scanner.nextLine();

            // Use PalindromeChecker class
            PalindromeChecker checker = new PalindromeChecker(input);
            boolean result = checker.checkPalindrome();

            if (result) {
                System.out.println("The given string is a Palindrome.");
            } else {
                System.out.println("The given string is NOT a Palindrome.");
            }

            scanner.close();


    }
}