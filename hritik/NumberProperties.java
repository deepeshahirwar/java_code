
import java.util.*;

class NumberProperties {
    public static void main(String[] args) {
        int number = 28; 
        int[] factors = findFactors(number); 

        System.out.println("Factors: " + Arrays.toString(factors)); 
        System.out.println("Greatest Factor: " + findGreatestFactor(factors)); 
        System.out.println("Sum of Factors: " + sumOfFactors(factors)); 
        System.out.println("Product of Factors: " + productOfFactors(factors)); 
        System.out.println("Product of Cubes of Factors: " + productOfCubes(factors)); 
        System.out.println("Is Perfect Number: " + isPerfectNumber(number)); 
        System.out.println("Is Abundant Number: " + isAbundantNumber(number)); 
        System.out.println("Is Deficient Number: " + isDeficientNumber(number)); 
        System.out.println("Is Strong Number: " + isStrongNumber(number)); 
    }

    // find all factors of a number
    public static int[] findFactors(int number) {
        List<Integer> factorList = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                factorList.add(i); 
            }
        }
        return factorList.stream().mapToInt(i -> i).toArray();
    }

    // find the greatest factor of a number
    public static int findGreatestFactor(int[] factors) {
        return factors[factors.length - 1]; 
    }

    // sum of all factors of a number
    public static int sumOfFactors(int[] factors) {
        int sum = 0;
        for (int factor : factors) {
            sum += factor; 
        }
        return sum;
    }

    // product of all factors of a number
    public static int productOfFactors(int[] factors) {
        int product = 1;
        for (int factor : factors) {
            product *= factor; 
        }
        return product;
    }

    // product of cubes of all factors
    public static double productOfCubes(int[] factors) {
        double product = 1;
        for (int factor : factors) {
            product *= Math.pow(factor, 3); 
        }
        return product;
    }

    // check if a number is a perfect number
    public static boolean isPerfectNumber(int number) {
        return sumOfFactors(findFactors(number)) - number == number; 
    }

    // check if a number is an abundant number
    public static boolean isAbundantNumber(int number) {
        return sumOfFactors(findFactors(number)) - number > number; 
    }

    // check if a number is a deficient number
    public static boolean isDeficientNumber(int number) {
        return sumOfFactors(findFactors(number)) - number < number; 
    }

    // check if a number is a strong number
    public static boolean isStrongNumber(int number) {
        int sum = 0;
        int temp = number;
        while (temp > 0) {
            int digit = temp % 10; // get last digit
            sum += factorial(digit); // add factorial of the digit
            temp /= 10; // remove last digit
        }
        return sum == number; // check if sum equals the number
    }

    // calculate factorial of a number
    public static int factorial(int n) {
        if (n == 0) return 1; 
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i; 
        }
        return result;
    }
}
