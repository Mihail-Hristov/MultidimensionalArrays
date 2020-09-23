import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokenForSize = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(tokenForSize[0]);
        int cols = Integer.parseInt(tokenForSize[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        String input = scanner.nextLine();

        while (!"END".equals(input)){
            String[] tokenForCommand = input.split("\\s+");

            boolean validCommand = checkInputtedCommand(matrix, tokenForCommand);

            if (validCommand){
                int firstRow = Integer.parseInt(tokenForCommand[1]);
                int firstCol = Integer.parseInt(tokenForCommand[2]);
                int secondRow = Integer.parseInt(tokenForCommand[3]);
                int secondCol = Integer.parseInt(tokenForCommand[4]);

                int temp = matrix[firstRow][firstCol];
                matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                matrix[secondRow][secondCol] = temp;

            }else {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    System.out.print(matrix[row][col] + " ");
                }
                System.out.println();
            }

            input = scanner.nextLine();
        }

    }

    public static boolean checkInputtedCommand(int[][] matrix, String[] token) {

        String word = token[0];

        if (!word.equals("swap")) {

            return false;
        } else if (token.length != 5) {

            return false;
        } else return checkIndexes(token, matrix);

    }

    public static boolean checkIndexes(String[] token, int[][] matrix){
        int firstRow = Integer.parseInt(token[1]);
        int firstCol = Integer.parseInt(token[2]);
        int secondRow = Integer.parseInt(token[3]);
        int secondCol = Integer.parseInt(token[4]);

        return firstRow >= 0 && firstRow < matrix.length
                && secondRow >= 0 && secondRow < matrix.length
                && firstCol >= 0 && firstCol < matrix[matrix.length - 1].length
                && secondCol >= 0 && secondCol < matrix[matrix.length - 1].length;

    }
}
