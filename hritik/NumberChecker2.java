

class NumberChecker2 {
    public static void main(String[] args) {
        int number = 153; // example number to check properties
        int[] digits = getDigits(number); // get digits of the number

        System.out.println("Count of Digits: " + digits.length);
        System.out.println("Is Duck Number: " + isDuckNumber(digits));
        System.out.println("Is Armstrong Number: " + isArmstrongNumber(number, digits));
        System.out.println("Largest Element: " + findLargest(digits));
        System.out.println("Smallest Element: " + findSmallest(digits));
    }

    // get digits of a number
    public static int[] getDigits(int number) {
        String numStr = Integer.toString(number);
        int[] digits = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = Character.getNumericValue(numStr.charAt(i)); // store each digit
        }
        return digits;
    }

    // check if the number is a duck number
    public static boolean isDuckNumber(int[] digits) {
        for (int digit : digits) {
            if (digit == 0) {
                return true; // contains '0'
            }
        }
        return false; // no '0'
    }

    // check if the number is an Armstrong number
    public static boolean isArmstrongNumber(int number, int[] digits) {
        int sum = 0;
        int power = digits.length; // number of digits
        for (int digit : digits) {
            sum += Math.pow(digit, power); // sum of digits raised to the power of number of digits
        }
        return sum == number; // check if sum equals the original number
    }

    // find the largest digit
    public static int findLargest(int[] digits) {
        int max = Integer.MIN_VALUE; // initialize to smallest integer
        for (int digit : digits) {
            if (digit > max) {
                max = digit; // update max
            }
        }
        return max; // return largest digit
    }

    // find the smallest digit
    public static int findSmallest(int[] digits) {
        int min = Integer.MAX_VALUE; // initialize to largest integer
        for (int digit : digits) {
            if (digit < min) {
                min = digit; // update min
            }
        }
        return min; // return smallest digit
    }
}
