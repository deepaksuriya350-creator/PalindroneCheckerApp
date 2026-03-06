import java.util.Scanner;

public class PalindromeCheckerApp {


        public static boolean isPalindrome(String str) {

            int start = 0;
            int end = str.length() - 1;

            while (start < end) {
                if (str.charAt(start) != str.charAt(end)) {
                    return false;
                }
                start++;
                end--;
            }

            return true;
        }

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter a string to check if it is a palindrome:");
            String input = scanner.nextLine();

            // Normalize the string
            String normalized = input.replaceAll("\\s+", "").toLowerCase();

            if (isPalindrome(normalized)) {
                System.out.println("The given string is a Palindrome (ignoring spaces and case).");
            } else {
                System.out.println("The given string is NOT a Palindrome.");
            }

            scanner.close();


    }
}