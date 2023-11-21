import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Worker {
    private final String separator = File.separator;
    protected final Path path = Paths.get("src" + separator + "files");
    protected final Path absPath = path.toAbsolutePath();
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

    public int[][] deleteDia(int[][] matrix) {
        int size = matrix.length;
        for (int i = 0; i < size; i++) {
            matrix[i][size - 1 - i] = 0;
        }
        return matrix;
    }

    public int[][] replaceRowRandom(int[][] matrix, int rowNumber) {
        int size = matrix.length;
        Random random = new Random();
        int randomRowIndex = random.nextInt(size - 1);
        int[] temp = matrix[rowNumber];
        matrix[rowNumber] = matrix[randomRowIndex];
        matrix[randomRowIndex] = temp;
        return matrix;
    }

    public int[][] searchElem(int[][] matrix, int value) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] % value == 0) {
                    if (matrix[i][j + 1] % 2 == 0) {
                        for (int k = 0; k < cols; k++) {
                            matrix[i][k] = 0;
                        }
                    } else {
                        for (int k = 0; k < rows; k++) {
                            matrix[k][j] = 0;
                        }
                    }
                }
            }
        }
        return matrix;
    }

    public int calculateDeterminant(int[][] matrix) {
        int n = matrix.length;
        if (n != matrix[0].length) {
            throw new IllegalArgumentException("Матрица должна быть квадратной");
        }
        if (n == 1) {
            return matrix[0][0];
        }
        int determinant = 0;
        for (int j = 0; j < n; j++) {
            determinant += matrix[0][j] * Math.pow(-1, j) * calculateDeterminant(getMinor(matrix, 0, j));
        }
        return determinant;
    }

    private int[][] getMinor(int[][] matrix, int row, int col) {
        int n = matrix.length;
        int[][] minor = new int[n - 1][n - 1];
        for (int i = 0, newRow = 0; i < n; i++) {
            if (i == row) {
                continue;
            }
            for (int j = 0, newCol = 0; j < n; j++) {
                if (j == col) {
                    continue;
                }
                minor[newRow][newCol] = matrix[i][j];
                newCol++;
            }
            newRow++;
        }
        return minor;
    }

    public int[][] multiMatrix(int[][] matrixFromKeyboard) {
        System.out.print("Введите имя файла с матрицей: ");
        String name = scanner.next();
        int[][] matrixFromFile = readMatrixFromFile(name);
        printMatrix(matrixFromFile);
        int[][] resultMatrix = new int[0][];
        if (matrixFromFile != null && matrixFromKeyboard != null) {
            if (matrixFromFile[0].length == matrixFromKeyboard.length) {
                resultMatrix = multiplyMatrices(matrixFromFile, matrixFromKeyboard);
                System.out.println("Результат умножения матриц:");
            } else {
                System.out.println("Невозможно выполнить умножение. Количество столбцов первой матрицы не соответствует количеству строк второй матрицы.");
            }
        } else {
            System.out.println("Ошибка чтения матриц из файла или с клавиатуры.");
        }
        return resultMatrix;
    }

    private int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int cols = secondMatrix[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < firstMatrix[0].length; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return result;
    }

    private int[][] readMatrixFromFile(String filename) {
        try {
            File file = new File(absPath + separator + filename);
            Scanner fileScanner = new Scanner(file);
            if(!fileScanner.hasNext()) {
                System.out.println("Файл пустой!");
                return new int[0][];
            }
            String line;
            int rows = Integer.parseInt(fileScanner.nextLine());
            int cols = Integer.parseInt(fileScanner.nextLine());
            int[][] matrix = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                line = fileScanner.nextLine();
                String[] values = line.split("\\s+");
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = Integer.parseInt(values[j]);
                }
            }
            return matrix;
        } catch (IOException e) {
            System.out.println("Не удалось считать файл: " + filename);
            return new int[0][];
        }
    }

    public int[][] swapRowsMatrix() {
        System.out.print("Введите имя файла с матрицей: ");
        String name = scanner.next();
        int[][] matrix = readMatrixFromFile(name);
        printMatrix(matrix);
        System.out.print("Введите номер первой строки для обмена: ");
        int firstRow = scanner.nextInt();
        System.out.print("Введите номер второй строки для обмена: ");
        int secondRow = scanner.nextInt();
        if (firstRow >= 0 && firstRow < matrix.length && secondRow >= 0 && secondRow < matrix.length) {
            swapRows(matrix, firstRow, secondRow);
            System.out.println("Матрица после обмена строк:");
        } else {
            System.out.println("Неверные номера строк.");
        }
        return matrix;
    }

    private void swapRows(int[][] matrix, int firstRow, int secondRow) {
        int[] temp = matrix[firstRow];
        matrix[firstRow] = matrix[secondRow];
        matrix[secondRow] = temp;
    }

    private int[][] transArrayToMatrix(int[][] matrix, int[] array) {
        int k = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = array[k];
                k++;
            }
        }
        return matrix;
    }

    private int[] transMatrixToArray(int [][] matrix) {
        int n = matrix.length * matrix[0].length;
        int[] array = new int[n];
        int k = 0;
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                array[k] = ints[j];
                k++;
            }
        }
        return array;
    }

    public int[][] sortMatrixShell(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j;
                for (j = i; j >= gap && array[j - gap] > temp; j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixBubble(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixInsertion(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = 1; i < n; ++i) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixSelection(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return transArrayToMatrix(matrix, array);
    }

    public int[][] sortMatrixHeap(int[][] matrix) {
        int[] array = transMatrixToArray(matrix);
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heap(array, n, i);
        }
        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heap(array, i, 0);
        }
        return transArrayToMatrix(matrix, array);
    }

    private void heap(int[] arr, int n, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        if (leftChild < n && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < n && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != index) {
            int swap = arr[index];
            arr[index] = arr[largest];
            arr[largest] = swap;
            heap(arr, n, largest);
        }
    }

    public void printRow(String[] row) {
        for (String cell : row) {
            System.out.print("| " + centerText(cell, 12) + " ");
        }
        System.out.println("|");
    }

    public void printHorizontalLine(int columns) {
        for (int i = 0; i < columns; i++) {
            System.out.print("+--------------");
        }
        System.out.println("+");
    }

    public String centerText(String text, int width) {
        return String.format("%-" + width + "s", String.format("%" + (text.length() + (width - text.length()) / 2) + "s", text));
    }

    public List<String> readFromFile(String name) {
        File file = new File(absPath + separator + name);
        List<String> lines = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(file);
            if(!fileScanner.hasNext()) {
                System.out.println("Файл пустой!");
                return lines;
            }
            String line = fileScanner.nextLine();
            lines.add(line);
            while (fileScanner.hasNext()) {
                line = fileScanner.nextLine();
                lines.add(line);
            }
            fileScanner.close();
        } catch (IOException ex) {
            System.out.println("Не удалось считать файл: " + file);
        }
        return lines;
    }
}
