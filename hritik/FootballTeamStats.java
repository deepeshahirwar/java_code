import java.util.Arrays;

public class FootballTeamStats {

    // for generating random heights
    public int[] generateHeights() {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = (int) (Math.random() * 101) + 150;
        }
        return heights;
    }

    // this method for calculate the sum of heights
    public int calculateSum(int[] heights) {
        int sum = 0;
        for (int height : heights) {
            sum += height;
        }
        return sum;
    }

    // this method for calculate the mean
    public double calculateMean(int[] heights) {
        return (double) calculateSum(heights) / heights.length;
    }

    // this for finding the shortest height
    public int findShortest(int[] heights) {
        int shortest = Integer.MAX_VALUE;
        for (int height : heights) {
            if (height < shortest) {
                shortest = height;
            }
        }
        return shortest;
    }

    // this for finding the tallest height
    public int findTallest(int[] heights) {
        int tallest = Integer.MIN_VALUE;
        for (int height : heights) {
            if (height > tallest) {
                tallest = height;
            }
        }
        return tallest;
    }
// this is our main function
    public static void main(String[] args) {
        FootballTeamStats stats = new FootballTeamStats();

        // generate random heights for the team
        int[] heights = stats.generateHeights();
        System.out.println("Player heights: " + Arrays.toString(heights));

        // calculate and display statistics
        System.out.println("Total height: " + stats.calculateSum(heights) + " cm");
        System.out.println("Mean height: " + stats.calculateMean(heights) + " cm");
        System.out.println("Shortest height: " + stats.findShortest(heights) + " cm");
        System.out.println("Tallest height: " + stats.findTallest(heights) + " cm");
    }
}
