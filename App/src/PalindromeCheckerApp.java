import java.util.Scanner;
public class PalindromeCheckerApp {

    public static void main(String[] args) {


                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a string to check if it is a palindrome:");
                String input = scanner.nextLine();

                // Convert string to character array
                char[] characters = input.toCharArray();

                // Two pointer technique
                int start = 0;
                int end = characters.length - 1;

                boolean isPalindrome = true;

                while (start < end) {
                    if (characters[start] != characters[end]) {
                        isPalindrome = false;
                        break;
                    }
                    start++;
                    end--;
                }

                if (isPalindrome) {
                    System.out.println("The given string is a Palindrome.");
                } else {
                    System.out.println("The given string is NOT a Palindrome.");
                }

                scanner.close();

    }
}
