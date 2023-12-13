import java.util.Scanner;

public class MatrixMultiplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows for matrix A: ");
        int rowsA = scanner.nextInt();

        System.out.println("Enter the number of columns for matrix A / rows for matrix B: ");
        int columnsARowsB = scanner.nextInt();

        System.out.println("Enter the number of columns for matrix B: ");
        int columnsB = scanner.nextInt();

        int[][] matrixA = new int[rowsA][columnsARowsB];
        int[][] matrixB = new int[columnsARowsB][columnsB];

        System.out.println("Enter the elements of matrix A:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsARowsB; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of matrix B:");
        for (int i = 0; i < columnsARowsB; i++) {
            for (int j = 0; j < columnsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        int[][] result = multiplyMatrices(matrixA, matrixB);
        System.out.println("The result of matrix multiplication is:");
        printMatrix(result);
    }

    public static int[][] multiplyMatrices(int[][] matrixA, int[][] matrixB) {
        int rowsA = matrixA.length;
        int columnsARowsB = matrixA[0].length;
        int columnsB = matrixB[0].length;

        int[][] result = new int[rowsA][columnsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < columnsB; j++) {
                for (int k = 0; k < columnsARowsB; k++) {
                    result[i][j] += matrixA[i][k] * matrixB[k][j];
                }
            }
        }
        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
