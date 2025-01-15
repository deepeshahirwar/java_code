import java.util.Scanner;

public class AnagramChecker8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        try {
            System.out.print("Enter the first text: ");
            String text1 = scanner.nextLine();
            
            System.out.print("Enter the second text: ");
            String text2 = scanner.nextLine();
            
            boolean areAnagrams = checkAnagrams(text1, text2);
            
            if (areAnagrams) {
                System.out.println("The texts are anagrams.");
            } else {
                System.out.println("The texts are not anagrams.");
            }
        } finally {
            scanner.close();
        }
    }

    public static boolean checkAnagrams(String text1, String text2) {
        // check if lengths are equal
        if (text1.length() != text2.length()) {
            return false;
        }

        // create frequency arrays for both texts
        int[] frequency1 = new int[256]; 
        int[] frequency2 = new int[256];

        // count frequency of characters in both texts
        for (int i = 0; i < text1.length(); i++) {
            frequency1[text1.charAt(i)]++;
            frequency2[text2.charAt(i)]++;
        }

        // compare frequency arrays
        for (int i = 0; i < 256; i++) {
            if (frequency1[i] != frequency2[i]) {
                return false;
            }
        }

        return true;
    }
}
