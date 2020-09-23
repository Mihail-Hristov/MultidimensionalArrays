import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(token[0]);
        int cols = Integer.parseInt(token[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[] matrixWithBestSum = findTheMatrix(matrix);

        int count = 0;

        int[][] bestMatrix = new int[3][3];

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                bestMatrix[row][col] = matrixWithBestSum[count];
                count ++;
            }
        }

        int finalSum = matrixWithBestSum[9];

        System.out.println(String.format("Sum = %s", finalSum));

        for (int row = 0; row < bestMatrix.length; row++) {
            for (int col = 0; col < bestMatrix[row].length; col++) {
                System.out.print(bestMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    public static int[] findTheMatrix(int[][] matrix){

        int[] parameters = new int[10];
        int bestSum = Integer.MIN_VALUE;

        for (int row = 0; row <= matrix.length - 3; row++) {
            for (int col = 0; col <= matrix[row].length - 3; col++) {
                int currentSum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (currentSum > bestSum){
                    bestSum = currentSum;
                    int[] currentParameters = new int[]{matrix[row][col], matrix[row][col + 1], matrix[row][col + 2]
                            , matrix[row + 1][col], matrix[row + 1][col + 1], matrix[row + 1][col + 2]
                            , matrix[row + 2][col], matrix[row + 2][col + 1], matrix[row + 2][col + 2]
                            , bestSum};

                    parameters = currentParameters;
                }
            }
        }

        return parameters;
    }
}
