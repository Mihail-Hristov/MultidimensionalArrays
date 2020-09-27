import java.util.Arrays;
import java.util.Scanner;

public class ReversMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;
        }


        for (int col = matrix[rows - 1].length - 1; col >= 0 ; col--) {
            int currentRow = rows - 1;
            int currentCol = col;

            while (currentCol < cols && currentRow >= 0) {
                System.out.print(matrix[currentRow--][currentCol++] + " ");
            }
            System.out.println();
        }

        for (int row = rows - 2; row >= 0; row--) {
            int currentRow = row;
            int currentCol = 0;

            while (currentCol < matrix[row].length && currentRow >= 0) {
                System.out.print(matrix[currentRow--][currentCol++] + " ");
            }
            System.out.println();
        }

    }
}
