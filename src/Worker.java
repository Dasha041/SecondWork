import java.util.Scanner;

public class Worker {
    private final Scanner scanner;

    public Worker() {
        this.scanner = new Scanner(System.in);
    }

    public int[][] createMatrix() {
        System.out.print("Введите кол-во столбцов: ");
        int colum = scanner.nextInt();
        System.out.print("Введите кол-во строк: ");
        int rows = scanner.nextInt();
        int [][] matrix = new int[rows][colum];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colum; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        return matrix;
    }

    public void printMatrix(int [][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.print("\n");
        }
    }

    public int[][] deleteRowNumber(int number, int[][] matrix) {
        int[][] newMatrix = new int[matrix.length - 1][matrix[0].length];
        for (int i = 0, newRow = 0; i < matrix.length; i++) {
            if (i != number) {
                System.arraycopy(matrix[i], 0, newMatrix[newRow], 0, matrix[i].length);
                newRow++;
            }
        }
        return newMatrix;
    }

    public int[][] transposeMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposedMatrix = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }
}
