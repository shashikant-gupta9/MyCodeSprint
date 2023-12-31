import java.util.Arrays;

class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.data = new double[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void setElement(int i, int j, double value) {
        data[i][j] = value;
    }

    public double getElement(int i, int j) {
        return data[i][j];
    }

    public Matrix add(Matrix other) {
        if (rows != other.getRows() || cols != other.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions must match for addition.");
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, data[i][j] + other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        if (rows != other.getRows() || cols != other.getCols()) {
            throw new IllegalArgumentException("Matrix dimensions must match for subtraction.");
        }

        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.setElement(i, j, data[i][j] - other.getElement(i, j));
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (cols != other.getRows()) {
            throw new IllegalArgumentException("Number of columns in first matrix must match number of rows in second matrix for multiplication.");
        }

        Matrix result = new Matrix(rows, other.getCols());
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++) {
                    sum += data[i][k] * other.getElement(k, j);
                }
                result.setElement(i, j, sum);
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                result.setElement(i, j, data[j][i]);
            }
        }
        return result;
    }

    public double determinant() {
        if (rows != cols) {
            throw new IllegalArgumentException("Determinant can be calculated only for square matrices.");
        }
        if (rows == 1) {
            return data[0][0];
        }
        if (rows == 2) {
            return data[0][0] * data[1][1] - data[0][1] * data[1][0];
        }

        double determinant = 0;
        for (int i = 0; i < cols; i++) {
            determinant += data[0][i] * cofactor(0, i);
        }
        return determinant;
    }

    private double cofactor(int row, int col) {
        int sign = (row + col) % 2 == 0 ? 1 : -1;
        return sign * minorMatrix(row, col).determinant();
    }

    private Matrix minorMatrix(int row, int col) {
        Matrix minor = new Matrix(rows - 1, cols - 1);
        for (int i = 0, r = 0; i < rows; i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0, c = 0; j < cols; j++) {
                if (j == col) {
                    continue;
                }
                minor.setElement(r, c, data[i][j]);
                c++;
            }
            r++;
        }
        return minor;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : data) {
            sb.append(Arrays.toString(row)).append("\n");
        }
        return sb.toString();
    }
}

public class MatrixOperations {
    public static void main(String[] args) {
        Matrix matrix1 = new Matrix(3, 3);
        matrix1.setElement(0, 0, 1);
        matrix1.setElement(0, 1, 2);
        matrix1.setElement(0, 2, 3);
        matrix1.setElement(1, 0, 4);
        matrix1.setElement(1, 1, 5);
        matrix1.setElement(1, 2, 6);
        matrix1.setElement(2, 0, 7);
        matrix1.setElement(2, 1, 8);
        matrix1.setElement(2, 2, 9);

        Matrix matrix2 = new Matrix(3, 3);
        matrix2.setElement(0, 0, 9);
        matrix2.setElement(0, 1, 8);
        matrix2.setElement(0, 2, 7);
        matrix2.setElement(1, 0, 6);
        matrix2.setElement(1, 1, 5);
        matrix2.setElement(1, 2, 4);
        matrix2.setElement(2, 0, 3);
        matrix2.setElement(2, 1, 2);
        matrix2.setElement(2, 2, 1);

        System.out.println("Matrix 1:\n" + matrix1);
        System.out.println("Matrix 2:\n" + matrix2);

        System.out.println("Addition:\n" + matrix1.add(matrix2));
        System.out.println("Subtraction:\n" + matrix1.subtract(matrix2));
        System.out.println("Multiplication:\n" + matrix1.multiply(matrix2));
        System.out.println("Transpose of Matrix 1:\n" + matrix1.transpose());
        System.out.println("Determinant of Matrix 1: " + matrix1.determinant());
    }
}
