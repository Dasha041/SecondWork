import java.util.Scanner;

public class Manager {
    private final Scanner scanner;
    private final Worker worker;

    public Manager() {
        this.worker = new Worker();
        this.scanner = new Scanner(System.in);
    }

    public void createAndPrintMatrix() {
        int[][] matrix = worker.createMatrix();
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void deleteRow() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        System.out.print("Введите индекс строки: ");
        int rowNumber = scanner.nextInt();
        matrix = worker.deleteRowNumber(rowNumber, matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void transposeMatrix() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.transposeMatrix(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void deleteDia() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.deleteDia(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void replaceRow() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        System.out.print("Введите индекс строки: ");
        int rowNumber = scanner.nextInt();
        matrix = worker.replaceRowRandom(matrix, rowNumber);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void searchElem() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        System.out.print("Введите значение для проверки элементов матрицы: ");
        int value = scanner.nextInt();
        matrix = worker.searchElem(matrix, value);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void calculateDeterminant() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        int det = worker.calculateDeterminant(matrix);
        System.out.println("Результат: " + det);
    }

    public void multiMatrix() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.multiMatrix(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void swapRowsMatrix() {
        int[][] matrix = worker.swapRowsMatrix();
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void sortShell() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.sortMatrixShell(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void sortBubble() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.sortMatrixBubble(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void sortInsert() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.sortMatrixInsertion(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void sortSelect() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.sortMatrixSelection(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }

    public void sortHeap() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.sortMatrixHeap(matrix);
        System.out.println("Результат:");
        worker.printMatrix(matrix);
    }
}
