import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[][] firstMatrix = readMatrix(scanner);
        int[][] secondMatrix = readMatrix(scanner);

        boolean areEqual = areTheyEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    public static int[][] readMatrix(Scanner scanner) {
        String[] token = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(token[0]);
        int cols = Integer.parseInt(token[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] arr = scanner.nextLine().split("\\s+");
            for (int j = 0; j < arr.length; j++) {
                matrix[i][j] = Integer.parseInt(arr[j]);
            }
        }

            return matrix;
        }

        public static boolean areTheyEqual ( int[][] firstMatrix, int[][] secondMatrix){
            if (firstMatrix.length != secondMatrix.length) {
                return false;
            }
            for (int row = 0; row < firstMatrix.length; row++) {
                if (firstMatrix[row].length != secondMatrix[row].length) {
                    return false;
                }
                for (int col = 0; col < firstMatrix[row].length; col++) {
                    if (firstMatrix[row][col] != secondMatrix[row][col]) {
                        return false;
                    }
                }
            }
            return true;
        }

}
