import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(token[0]);
        int cols = Integer.parseInt(token[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sum = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int currentNumber = matrix[row][col];
                sum += currentNumber;
            }
        }

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
