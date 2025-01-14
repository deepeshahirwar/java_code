import java.util.Scanner;

class CollinearPoints {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input coordinates for the points
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter x3: ");
        double x3 = scanner.nextDouble();
        System.out.print("Enter y3: ");
        double y3 = scanner.nextDouble();

        // check collinearity by slope
        boolean areCollinearBySlope = areCollinearBySlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Are the points collinear (by slope method)? " + areCollinearBySlope);

        // check collinearity by area
        boolean areCollinearByArea = areCollinearByArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Are the points collinear (by area method)? " + areCollinearByArea);
    }

    // check collinearity by slope
    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        // calculate slopes
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeAC = (y3 - y1) / (x3 - x1);
        return slopeAB == slopeAC; // slopes should be equal
    }

    // check collinearity by area
    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        // calculate area
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0; // area should be zero
    }
}
