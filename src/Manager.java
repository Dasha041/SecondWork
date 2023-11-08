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
        worker.printMatrix(matrix);
    }

    public void deleteRow() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        System.out.print("Введите индекс строки: ");
        int rowNumber = scanner.nextInt();
        matrix = worker.deleteRowNumber(rowNumber, matrix);
        worker.printMatrix(matrix);
    }

    public void transposeMatrix() {
        int[][] matrix = worker.createMatrix();
        worker.printMatrix(matrix);
        matrix = worker.transposeMatrix(matrix);
        worker.printMatrix(matrix);
    }
}
