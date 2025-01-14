import java.util.Random;

public class MatrixOperations {

    // method to create a random matrix
    public static int[][] createRandomMatrix(int rows, int cols) {
        Random rand = new Random();
        int[][] matrix = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = rand.nextInt(10); 
            }
        }
        return matrix;
    }

    // this mothod will display the matrix
    public static void displayMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int element : matrix[i]) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

   // this method for adding two matrices
    public static int[][] addMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] + mat2[i][j];
            }
        }
        return result;
    }
  
  // this method for subtracting two matrices
    public static int[][] subtractMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat1[0].length;
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = mat1[i][j] - mat2[i][j];
            }
        }
        return result;
    }

   // this method for multiplying two matrices
    public static int[][] multiplyMatrices(int[][] mat1, int[][] mat2) {
        int rows = mat1.length;
        int cols = mat2[0].length;
        int commonDimension = mat1[0].length;
        
        if (commonDimension != mat2.length) {
            throw new IllegalArgumentException("Matrix dimensions do not match for multiplication.");
        }
        
        int[][] result = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 0;
                for (int k = 0; k < commonDimension; k++) {
                    result[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        return result;
    }

    // this for transposing a matrix
    public static int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

    // this for calculating the determinant
    public static int determinant(int[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        } else if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        int det = 0;
        for (int i = 0; i < n; i++) {
            int[][] subMatrix = getSubMatrix(matrix, 0, i);
            det += matrix[0][i] * Math.pow(-1, i) * determinant(subMatrix);
        }
        return det;
    }

    // this for getting the submatrix
    public static int[][] getSubMatrix(int[][] matrix, int row, int col) {
        int size = matrix.length;
        int[][] subMatrix = new int[size - 1][size - 1];
        
        int r = 0;
        for (int i = 0; i < size; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < size; j++) {
                if (j == col) continue;
                subMatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return subMatrix;
    }

    // this for calculating the inverse
    public static double[][] inverseMatrix(int[][] matrix) {
        int det = determinant(matrix);
        if (det == 0) {
            System.out.println("Matrix is singular and cannot be inverted.");
            return null;
        }
        
        int n = matrix.length;
        double[][] adjoint = new double[n][n];
        double[][] inverse = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[][] subMatrix = getSubMatrix(matrix, i, j);
                adjoint[i][j] = Math.pow(-1, i + j) * determinant(subMatrix);
            }
        }

        // this for calculating the inverse
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                inverse[i][j] = adjoint[j][i] / det;
            }
        }
        return inverse;
    }

    public static void main(String[] args) {
        int rows = 3, cols = 3;
        
        // creatting two random matrices
        int[][] mat1 = createRandomMatrix(rows, cols);
        int[][] mat2 = createRandomMatrix(rows, cols);

        System.out.println("Matrix 1:");
        displayMatrix(mat1);

        System.out.println("Matrix 2:");
        displayMatrix(mat2);

       // matrix addition
        System.out.println("Matrix 1 + Matrix 2:");
        int[][] sum = addMatrices(mat1, mat2);
        displayMatrix(sum);

        // matrix subtraction
        System.out.println("Matrix 1 - Matrix 2:");
        int[][] diff = subtractMatrices(mat1, mat2);
        displayMatrix(diff);

        // matrix multiplication
        System.out.println("Matrix 1 * Matrix 2:");
        int[][] product = multiplyMatrices(mat1, mat2);
        displayMatrix(product);

        // transpose of Matrix 1
        System.out.println("Transpose of Matrix 1:");
        int[][] transpose = transposeMatrix(mat1);
        displayMatrix(transpose);

        // determinant of Matrix 1
        System.out.println("Determinant of Matrix 1: " + determinant(mat1));

        // inverse of Matrix 1
        System.out.println("Inverse of Matrix 1:");
        double[][] inverse = inverseMatrix(mat1);
        if (inverse != null) {
            for(int i = 0; i < inverse.length; i++) {
                for (int j = 0; j < inverse[i].length; j++) {
                    System.out.print(inverse[i][j] + "\t");
                }
                System.out.println();
            }
        }
    }
}
