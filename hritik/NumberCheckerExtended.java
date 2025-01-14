
import java.util.Arrays;

class NumberCheckerExtended {
    public static void main(String[] args) {
        int number = 21; 
        int[] digits = getDigits(number);
        // for displaying all the ouputs
        System.out.println("Count of Digits: " + digits.length);
        System.out.println("Sum of Digits: " + sumOfDigits(digits));
        System.out.println("Sum of Squares of Digits: " + sumOfSquares(digits));
        System.out.println("Is Harshad Number: " + isHarshadNumber(number, digits));
        System.out.println("Frequency of Digits: " + Arrays.deepToString(findFrequency(digits)));
    }

    public static int[] getDigits(int number) {
        String numStr = Integer.toString(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i));
        }
        return digits;
    }
 
 // this method for finding the sum of digits
    public static int sumOfDigits(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += digit;
        }
        return sum;
    }
 
 //this method for finding the sum of squares
    public static int sumOfSquares(int[] digits) {
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, 2);
        }
        return sum;
    }
 
 // this mothode for finding the harshad number
    public static boolean isHarshadNumber(int number, int[] digits) {
        int sum = sumOfDigits(digits);
        return number % sum == 0;
    }
 
 // this mothod for finding the frequency of each digit
    public static int[][] findFrequency(int[] digits) {
        int[][] frequency = new int[10][2];
        for (int i = 0; i < frequency.length; i++) {
            frequency[i][0] = i; 
            frequency[i][1] = 0; 
        }
        for (int digit : digits) {
            frequency[digit][1]++;
        }
        return frequency;
    }
}