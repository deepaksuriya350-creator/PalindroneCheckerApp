import java.util.Scanner;
import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    // Approach 1: Two-pointer on char array
    public static boolean charArrayPalindrome(String text) {
        char[] chars = text.toCharArray();
        int start = 0, end = chars.length - 1;
        while (start < end) {
            if (chars[start] != chars[end]) return false;
            start++;
            end--;
        }
        return true;
    }

    // Approach 2: Stack-based
    public static boolean stackPalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Stack<Character> stack = new Stack<>();
        for (char ch : normalized.toCharArray()) stack.push(ch);
        for (char ch : normalized.toCharArray()) if (ch != stack.pop()) return false;
        return true;
    }

    // Approach 3: Deque-based
    public static boolean dequePalindrome(String text) {
        String normalized = text.replaceAll("\\s+", "").toLowerCase();
        Deque<Character> deque = new ArrayDeque<>();
        for (char ch : normalized.toCharArray()) deque.addLast(ch);
        while (deque.size() > 1) if (deque.removeFirst() != deque.removeLast()) return false;
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a string to test palindrome algorithms:");
        String input = scanner.nextLine();

        // Char array approach
        long startTime = System.nanoTime();
        boolean result1 = charArrayPalindrome(input);
        long endTime = System.nanoTime();
        long duration1 = endTime - startTime;

        // Stack approach
        startTime = System.nanoTime();
        boolean result2 = stackPalindrome(input);
        endTime = System.nanoTime();
        long duration2 = endTime - startTime;

        // Deque approach
        startTime = System.nanoTime();
        boolean result3 = dequePalindrome(input);
        endTime = System.nanoTime();
        long duration3 = endTime - startTime;

        // Display results
        System.out.println("\nPalindrome Check Results:");
        System.out.printf("Char Array Approach: %b, Time: %d ns%n", result1, duration1);
        System.out.printf("Stack Approach:      %b, Time: %d ns%n", result2, duration2);
        System.out.printf("Deque Approach:      %b, Time: %d ns%n", result3, duration3);

        scanner.close();
    }
}