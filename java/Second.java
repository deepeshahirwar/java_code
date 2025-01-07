 class Calculator { 

    // Addition
    public void add(int a, int b) {
        System.out.println("addition is : " + (a + b));
    }  

    // Subtraction
    public void subtract(int a, int b) {
        System.out.println("subtraction is : " + (a - b));
    }  

    // Multiplication
    public void multiply(int a, int b) {
        System.out.println("multiplication is : " + (a * b));
    }  

    // Division
    public void divide(int a, int b) {
        if (b == 0) {
            System.out.println("Error: Division by zero is not allowed.");
            return;
        }
        System.out.println("division is : " + (a / b));
    }
}

public class Second extends Calculator {
    public static void main(String[] args) {
        Second c = new Second();
        c.add(1, 2);
        c.subtract(1, 2);
        c.multiply(1, 2);
        c.divide(1, 2);   
    }
}
