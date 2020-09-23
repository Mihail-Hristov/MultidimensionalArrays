import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        for (int row = 0; row < size; row++) {
            matrix[row] = readCurrentRow(scanner);
        }

        int sumOfPrimaryDiagonal = 0;
        int sumOfSecondaryDiagonal = 0;

        for (int i = 0; i < size; i++) {
            sumOfPrimaryDiagonal += matrix[i][i];
        }

        for (int i = 0; i < size; i++) {
            sumOfSecondaryDiagonal += matrix[(size - 1) - i][i];
        }

        int result = Math.abs(sumOfPrimaryDiagonal - sumOfSecondaryDiagonal);

        System.out.println(result);

    }

    public static int[] readCurrentRow(Scanner scanner){
        String[] arr = scanner.nextLine().split("\\s+");
        int[] row = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            row[i] = Integer.parseInt(arr[i]);
        }
        return row;
    }
}
