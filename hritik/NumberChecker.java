import java.util.Arrays;

public class NumberChecker {

    // count number of digits in a number
    public static int countDigits(int number) {
        int count = 0;
        while (number > 0) {
            count++;
            number /= 10;
        }
        return count;
    }

    // extract digits of a number into an array
    public static int[] getDigits(int number) {
        int count = countDigits(number);
        int[] digits = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            digits[i] = number % 10;
            number /= 10;
        }
        return digits;
    }

    // check if the number is a duck number
    public static boolean isDuckNumber(int number) {
        int[] digits = getDigits(number);
        for (int digit : digits) {
            if (digit == 0) {
                return true;
            }
        }
        return false;
    }

    // check if the number is an Armstrong number
    public static boolean isArmstrongNumber(int number) {
        int[] digits = getDigits(number);
        int power = digits.length;
        int sum = 0;
        for (int digit : digits) {
            sum += Math.pow(digit, power);
        }
        return sum == number;
    }

    // find the largest and second largest digits
    public static int[] findTwoLargestDigits(int[] digits) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int digit : digits) {
            if (digit > largest) {
                secondLargest = largest;
                largest = digit;
            } else if (digit > secondLargest) {
                secondLargest = digit;
            }
        }
        return new int[]{largest, secondLargest};
    }

    // find the smallest and second smallest digits
    public static int[] findTwoSmallestDigits(int[] digits) {
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        for (int digit : digits) {
            if (digit < smallest) {
                secondSmallest = smallest;
                smallest = digit;
            } else if (digit < secondSmallest) {
                secondSmallest = digit;
            }
        }
        return new int[]{smallest, secondSmallest};
    }

    public static void main(String[] args) {
        int number = 153; // example number
        System.out.println("Number: " + number);

        // get digits of the number
        int[] digits = getDigits(number);
        System.out.println("Digits: " + Arrays.toString(digits));

        // check if it's a duck number
        System.out.println("Is Duck Number: " + isDuckNumber(number));

        // check if it's an Armstrong number
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number));

        // find largest and second largest digits
        int[] largestDigits = findTwoLargestDigits(digits);
        System.out.println("Largest Digit: " + largestDigits[0] + ", Second Largest Digit: " + largestDigits[1]);

        // find smallest and second smallest digits
        int[] smallestDigits = findTwoSmallestDigits(digits);
        System.out.println("Smallest Digit: " + smallestDigits[0] + ", Second Smallest Digit: " + smallestDigits[1]);
    }
}
