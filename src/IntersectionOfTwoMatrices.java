import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = readMatrix(scanner, rows, cols);
        char[][] secondMatrix = readMatrix(scanner, rows, cols);

        char[][] finalMatrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col] == secondMatrix[row][col]){
                    char currentChar = firstMatrix[row][col];
                    finalMatrix[row][col] = currentChar;
                }else {
                    finalMatrix[row][col] = '*';
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(finalMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] readMatrix (Scanner scanner, int rows, int cols){
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr= scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                char current = arr[col].charAt(0);
                matrix[row][col] = current;
            }
        }

        return matrix;
    }
}
