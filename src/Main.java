import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager manager = new Manager();
        printMenu();
        int input = scanner.nextInt();
        while (input != 0) {
            if (input == 1) {
                manager.createAndPrintMatrix();
            } else if (input == 2) {
                manager.deleteRow();
            } else if (input == 3) {
                manager.transposeMatrix();
            } else if (input == 4) {
                manager.deleteDia();
            } else if (input == 5) {
                manager.replaceRow();
            } else if (input == 6) {
                manager.searchElem();
            } else if (input == 7) {
                manager.calculateDeterminant();
            } else if (input == 8) {
                manager.multiMatrix();
            } else if (input == 9) {
                manager.swapRowsMatrix();
            } else if (input == 10) {
                manager.sortShell();
            } else if (input == 11) {
                manager.sortBubble();
            } else if (input == 12) {
                manager.sortInsert();
            } else if (input == 13) {
                manager.sortSelect();
            } else if (input == 14) {
                manager.sortHeap();
            } else if (input == 15) {
                manager.formatString();
            } else if (input == 16) {
                manager.formatTable();
            } else if (input == 17) {
                manager.deleteChars();
            } else if (input == 18) {
                manager.changeMask();
            } else if (input == 19) {
                manager.runningString();
            }
            printMenu();
            input = scanner.nextInt();
        }
    }

    private static void printMenu() {
        System.out.println("Выберите задание:");
        System.out.println("1. Создать двухмерный массив (матрицу) из нескольких полученных векторов.\n" +
                "2. Вычеркнуть из матрицы строку, индекс которой получен от пользователя.\n" +
                "3. Транспонировать матрицу.\n" +
                "4. Вычеркнуть побочную диагональ матрицы. Выполнить 1 циклом.\n" +
                "5. Произвести замену указанной строки матрицы на случайную из той же матрицы.\n" +
                "6. Найти в матрице элемент кратный значению считанного с клавиатуры и заменить весь столбец или строку на нули. Если следующий элемент в массиве чётный, то строку, если не чётный, то столбец.\n" +
                "7. Найти детерминант матрицы считанной с клавиатуры.\n" +
                "8. Выполнить произведение матрицы считанной из файла, на матрицу считанную с клавиатуры.\n" +
                "9. В матрице считанной из файла, поменять местами строку, с номером считанным с клавиатуры.\n" +
                "10. Выполнить сортировку матрицы методом Шелла.\n" +
                "11. Выполнить сортировку матрицы методом пузырька.\n" +
                "12. Выполнить сортировку матрицы методом вставок.\n" +
                "13. Выполнить сортировку матрицы методом выбора.\n" +
                "14. Выполнить сортировку матрицы методом кучи.\n" +
                "15. Вывести форматированный текст. по левому, по центру, по правому краю.\n" +
                "16. Вывести псевдографикой таблицу со строками и столбцами.\n" +
                "17. Считать строку из файла. Вычеркнуть из неё символы полученные из клавиатуры.\n" +
                "18. Считать строку с клавиатуры. Выполнить замену по маске замены из файла.\n" +
                "19. Считать строку с клавиатуры и вывести её в формате бегущей строки.");
        System.out.println("0. Выход.");
    }
}