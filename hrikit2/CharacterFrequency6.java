
 import  java.util.*;
public class CharacterFrequency6 {
 
 // this our main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();
        
        String[] result = findCharacterFrequency(input);
        
        System.out.println("Character Frequencies:");
        for (String entry : result) {
            if (!entry.equals("0")) { 
                System.out.println(entry);
            }
        }
        
        sc.close();
    }

    public static String[] findCharacterFrequency(String text) {
        char[] characters = text.toCharArray();
        int[] frequency = new int[characters.length];
        
        // for counting frequency
        for (int i = 0; i < characters.length; i++) {
            if (frequency[i] == 0) { 
                frequency[i] = 1; 
                for (int j = i + 1; j < characters.length; j++) {
                    if (characters[i] == characters[j]) {
                        frequency[i]++;
                        frequency[j] = 0; 
                    }
                }
            }
        }
        
        // for storing results
        String[] result = new String[characters.length];
        for (int i = 0; i < characters.length; i++) {
            if (frequency[i] > 0) {
                result[i] = characters[i] + ": " + frequency[i];
            } else {
                result[i] = "0"; 
            }
        }
        
        return result;
    }
}