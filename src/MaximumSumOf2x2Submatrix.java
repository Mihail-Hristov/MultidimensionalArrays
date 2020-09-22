import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
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
        int bestSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[2][2];

        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int sumForCurrentSubMatrix = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sumForCurrentSubMatrix > bestSum) {
                    bestSum = sumForCurrentSubMatrix;
                    for (int i = 0; i < 2; i++) {
                        for (int j = 0; j < 2; j++) {
                            bestMatrix[0][0] = matrix[row][col];
                            bestMatrix[0][1] = matrix[row][col + 1];
                            bestMatrix[1][0] = matrix[row + 1][col];
                            bestMatrix[1][1] = matrix[row + 1][col + 1];
                        }
                    }
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(bestSum);
    }
}
