import java.util.Random; 

public class EmployeeBonus {
    public static void main(String[] args) {
        // create a 2D array to store employee data
        double[][] employeeData = new double[5][2];

        // generate random salary and years of service data
        generateEmployeeData(employeeData);

        // display original employee data
        System.out.println("Original Employee Data:");
        displayEmployeeData(employeeData);

        // calculate new salaries and bonuses
        double[][] updatedData = calculateNewSalariesAndBonuses(employeeData);

        // display updated employee data
        System.out.println("\nUpdated Employee Data:");
        displayEmployeeData(updatedData);

        // display total amounts
        displayTotalAmounts(updatedData);
    }

    // generate random salary and years of service
    public static void generateEmployeeData(double[][] employeeData) {
        Random rand = new Random();
        for (double[] row : employeeData) {
            row[0] = 50000 + rand.nextInt(50000); // random salary
            row[1] = 1 + rand.nextInt(20); // random years of service
        }
    }

    // calculate new salary and bonus
    public static double[][] calculateNewSalariesAndBonuses(double[][] employeeData) {
        double[][] updatedData = new double[employeeData.length][2]; // new salary and bonus
        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double yearsOfService = employeeData[i][1];
            double newSalary = oldSalary * (1 + (yearsOfService / 100)); // new salary
            double bonus = newSalary * 0.1; // bonus
            updatedData[i][0] = newSalary;
            updatedData[i][1] = bonus;
        }
        return updatedData;
    }

    // display employee data
    public static void displayEmployeeData(double[][] employeeData) {
        for (double[] row : employeeData) {
            System.out.printf("Salary: %.2f, Years of Service: %.2f\n", row[0], row[1]);
        }
    }

    // display total amounts
    public static void displayTotalAmounts(double[][] employeeData) {
        double totalOldSalary = 0;
        double totalNewSalary = 0;
        double totalBonus = 0;
        for (double[] row : employeeData) {
            totalOldSalary += row[0];
            totalNewSalary += row[0] * (1 + (row[1] / 100)); // new salary
            totalBonus += row[0] * 0.1; // bonus
        }
        System.out.printf("\nTotal Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus Amount: %.2f\n", totalBonus);
    }
}
