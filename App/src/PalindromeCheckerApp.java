import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

// Strategy interface for palindrome algorithms
interface PalindromeStrategy {
    boolean check(String text);
}

// Stack-based palindrome checking strategy
class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char ch : normalized.toCharArray()) {
            stack.push(ch);
        }

        // Pop and compare
        for (char ch : normalized.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

// Deque-based palindrome checking strategy
class DequeStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();

        // Add characters to deque
        for (char ch : normalized.toCharArray()) {
            deque.addLast(ch);
        }

        // Compare front and rear
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }
        return true;
    }
}

// Context class that uses a strategy
class PalindromeCheckerContext {
    private PalindromeStrategy strategy;

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean checkPalindrome(String text) {
        if (strategy == null) {
            throw new IllegalStateException("No strategy selected!");
        }
        return strategy.check(text);
    }
}

// Main application class
public class PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to check if it is a palindrome:");
        String input = scanner.nextLine();

        System.out.println("Select strategy: 1 = Stack, 2 = Deque");
        int choice = scanner.nextInt();

        // Create context and inject strategy
        PalindromeCheckerContext context = new PalindromeCheckerContext();

        switch (choice) {
            case 1:
                context.setStrategy(new StackStrategy());
                break;
            case 2:
                context.setStrategy(new DequeStrategy());
                break;
            default:
                System.out.println("Invalid choice. Defaulting to StackStrategy.");
                context.setStrategy(new StackStrategy());
        }

        boolean result = context.checkPalindrome(input);

        if (result) {
            System.out.println("The given string is a Palindrome.");
        } else {
            System.out.println("The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}