import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

public class PalindromeCheckerApp {

    public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter a string to check if it is a palindrome:");
                String input = scanner.nextLine();

                Stack<Character> stack = new Stack<>();
                Queue<Character> queue = new LinkedList<>();

                // Push into stack and enqueue into queue
                for (int i = 0; i < input.length(); i++) {
                    char ch = input.charAt(i);
                    stack.push(ch);
                    queue.add(ch);
                }

                boolean isPalindrome = true;

                // Compare dequeue from queue and pop from stack
                while (!stack.isEmpty() && !queue.isEmpty()) {
                    if (stack.pop() != queue.remove()) {
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
