import java.util.Scanner;

public class PalindromeChecker7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a text: ");
        String input = scanner.nextLine();

        // case1
        boolean isPalindrome1 = isPalindromeIterative(input);
        System.out.println("Using Iterative Method: " + (isPalindrome1 ? "Palindrome" : "Not a Palindrome"));

        // case2
        boolean isPalindrome2 = isPalindromeRecursive(input, 0, input.length() - 1);
        System.out.println("Using Recursive Method: " + (isPalindrome2 ? "Palindrome" : "Not a Palindrome"));

        // case3
        boolean isPalindrome3 = isPalindromeUsingArrays(input);
        System.out.println("Using Character Arrays: " + (isPalindrome3 ? "Palindrome" : "Not a Palindrome"));

        scanner.close();
    }

    // case 1: iterative method to check palindrome
    public static boolean isPalindromeIterative(String text) {
        int start = 0;
        int end = text.length() - 1;

        while (start < end) {
            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    // case 2: recursive method to check palindrome
    public static boolean isPalindromeRecursive(String text, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (text.charAt(start) != text.charAt(end)) {
            return false;
        }
        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // case 3: method to check palindrome using character arrays
    public static boolean isPalindromeUsingArrays(String text) {
        char[] originalArray = text.toCharArray();
        char[] reversedArray = new char[originalArray.length];

        // reverse the string
        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }

        // comparing original and reversed arrays
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] != reversedArray[i]) {
                return false;
            }
        }
        return true;
    }
}