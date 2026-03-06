import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;


public class PalindromeCheckerApp {

    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a string to check if it is a palindrome:");
                String input = scanner.nextLine();

                Deque<Character> deque = new ArrayDeque<>();

                // Insert characters into deque
                for (int i = 0; i < input.length(); i++) {
                    deque.addLast(input.charAt(i));
                }

                boolean isPalindrome = true;

                // Compare front and rear characters
                while (deque.size() > 1) {
                    char front = deque.removeFirst();
                    char rear = deque.removeLast();

                    if (front != rear) {
                        isPalindrome = false;
                        break;
                    }
                }

                if (isPalindrome) {
                    System.out.println("The given string is a Palindrome.");
                } else {
                    System.out.println("The given string is NOT a Palindrome.");
                }

                scanner.close();


        }
}
