
import java.util.Random;
import java.util.Scanner;

class StudentScores { 
    // this is our main function
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the number of students: ");
        int numberOfStudents = scanner.nextInt();
      
        int[][] scores = generateRandomScores(numberOfStudents);
        double[][] results = calculateResults(scores);
        displayScorecard(results);
    }

   // this for generating random scores
    public static int[][] generateRandomScores(int numberOfStudents) {
        Random rand = new Random();
        int[][] scores = new int[numberOfStudents][3]; 

        for (int i = 0; i < numberOfStudents; i++) {
            scores[i][0] = rand.nextInt(101); 
            scores[i][1] = rand.nextInt(101); 
            scores[i][2] = rand.nextInt(101); 
        }
        return scores;
    }

     
     // this for calculating results
    public static double[][] calculateResults(int[][] scores) {
        double[][] results = new double[scores.length][4]; 

        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2]; 
            double average = total / 3.0; 
            double percentage = (total / 300.0) * 100; 

            results[i][0] = total; 
            results[i][1] = average; 
            results[i][2] = percentage; 
            results[i][3] = scores[i][0]; 
            results[i][4] = scores[i][1]; 
            results[i][5] = scores[i][2]; 
        }
        return results;
    }

    // this for displaying scorecard
    public static void displayScorecard(double[][] results) {
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", "Physics", "Chemistry", "Math", "Total", "Average", "Percentage");
        for (double[] result : results) {
            System.out.printf("%-10.0f %-10.0f %-10.0f %-10.0f %-10.2f %-10.2f\n", result[3], result[4], result[5], result[0], result[1], result[2]);
        }
    }
}