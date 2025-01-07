 // run time polymorphism
 public class Program1 { 
   static int add(int a,int b){
        return a+b;
    } 
    static int add(int a,int b,int c){
        return a+b+c;
    } 
    static double add(double a,double b){
        return a+b;
    }
    public static void main(String[] args) {
      //  Program1 obj = new Program1(); 
        int add1 = add(1,2); 
        int add2 = add(1,2,3); 
        double add3 = add(1.0,2.0);
        System.out.println("add1 function answer: "+add1);
        System.out.println("add2 function answer: "+add2); 
        System.out.println("add3 function answer: "+add3);
    }
}