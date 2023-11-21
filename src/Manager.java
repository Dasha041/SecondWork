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

    public void formatString() {
        System.out.print("Введите текст: ");
        String text = scanner.next();
        System.out.printf("По левому краю: %-20s\n", text);
        int width = 100;
        int padding = (width - text.length()) / 2;
        System.out.printf("По центру: %-" + width + "s\n", String.format("%" + (text.length() + padding) + "s", text));
        System.out.printf("По правому краю: %100s\n", text);
        System.out.println();
    }

    public void formatTable() {
        String[] headers = {"Заголовок1", "Заголовок2", "Заголовок3"};
        String[][] data = {
                {"Строка1", "Данные1", "Данные2"},
                {"Строка2", "Данные3", "Данные4"},
                {"Строка3", "Данные5", "Данные6"}
        };
        worker.printHorizontalLine(headers.length);
        worker.printRow(headers);
        worker.printHorizontalLine(headers.length);
        for (String[] row : data) {
            worker.printRow(row);
        }
        worker.printHorizontalLine(headers.length);
        System.out.println();
    }

    public void deleteChars() {
        String string = worker.readFromFile("String.txt").get(0);
        System.out.print("Строка в файле: ");
        System.out.println(string);
        System.out.print("Введите символ: ");
        String chars = scanner.next();
        string = string.replaceAll("[" + chars + "]", "");
        System.out.print("Результат: ");
        System.out.println(string);
        System.out.println();
    }

    public void changeMask() {
        String string = worker.readFromFile("Mask.txt").get(0);
        System.out.print("Маска в файле: ");
        System.out.println(string);
        System.out.print("Введите имя: ");
        String name = scanner.next();
        string = string.replaceAll("\\{name\\}", name);
        System.out.print("Результат: ");
        System.out.println(string);
        System.out.println();
    }

    public void runningString() {
        System.out.print("Введите строку: ");
        String inputString = scanner.next();
        int delay = 500;
        System.out.println("Результат: ");
        try {
            runText(inputString, delay);
        } catch (InterruptedException e) {
        }
        System.out.println();
    }

    private static void runText(String text, int delay) throws InterruptedException{
        for (int i = 0; i <= text.length(); i++) {
            System.out.print("\r" + text.substring(0, i));
            Thread.sleep(delay);
            System.out.print("\r" + " ".repeat(text.length() - i));
        }
    }
}
