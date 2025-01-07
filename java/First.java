 
 public class First { 
    public static int add(int a, int b) {
        return a + b;
    } 
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static void main(String[] args) {
        System.out.println("Hello World");  
        int ans = add(1, 2); 
        int ans2 = subtract(1, 2);
        System.out.println("addition is: "+ans); 
        System.out.println("subtraction is : "+ans2);
    }
}