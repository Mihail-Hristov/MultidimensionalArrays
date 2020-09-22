import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        List<int[]> indexes = new ArrayList<>();
        List<Integer> correctValue = new ArrayList<>();

        String[] token = scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(token[0]);
        int col = Integer.parseInt(token[1]);

        int valueForReplace = matrix[row][col];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == valueForReplace) {
                    indexes.add(new int[]{i, j});
                    correctValue.add(chekForNewSum(matrix, i, j));
                }
            }
        }

        for (int i = 0; i < indexes.size(); i++) {
            int[] rowAndCol = indexes.get(i);
            matrix[rowAndCol[0]][rowAndCol[1]] = correctValue.get(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int chekForNewSum(int[][] matrix, int row, int col) {
        int newSum = 0;
        int wrongValue = matrix[row][col];

        int left = col - 1;
        int right = col + 1;
        int up = row - 1;
        int down = row + 1;

        if (isValid(matrix, row, left) && matrix[row][left] != wrongValue) {
            newSum += matrix[row][left];
        }
        if (isValid(matrix, row, right) && matrix[row][right] != wrongValue) {
            newSum += matrix[row][right];
        }
        if (isValid(matrix, up, col) && matrix[up][col] != wrongValue) {
            newSum += matrix[up][col];
        }
        if (isValid(matrix, down, col) && matrix[down][col] != wrongValue) {
            newSum += matrix[down][col];
        }
        return newSum;
    }

    public static boolean isValid(int[][] matrix, int row, int col){

        return row >= 0 && row <matrix.length && col >= 0 && col < matrix[row].length;
    }
}
