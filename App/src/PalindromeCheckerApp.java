public class PalindromeCheckerApp {

    public static void main(String[] args) {

        String word = "madam";
        String reversedWord = "";
        boolean isPalindrome = true;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                isPalindrome=false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("The word \"" + word + "\" is a palindrome.");
        } else {
            System.out.println("The word \"" + word + "\" is not a palindrome.");
        }
    }
}
