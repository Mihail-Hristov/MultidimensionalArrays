import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][rows];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        for (int i = 0; i < rows; i++) {
            int currentNumber = matrix[i][i];
            System.out.print(currentNumber + " ");
        }
        System.out.println();

        for (int i = rows - 1; i >= 0; i--) {
            int currentNumber = matrix[i][(rows - 1) - i];
            System.out.print(currentNumber + " ");
        }
    }
}
