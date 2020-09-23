import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(token[0]);
        int cols = Integer.parseInt(token[1]);

        StringBuilder[][] matrix = fillTheMatrix(rows, cols);

        printTheMatrix(matrix);
    }

    public static StringBuilder[][] fillTheMatrix(int rows, int cols){
        StringBuilder[][] matrix = new StringBuilder[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                char outsideChar = (char) (97 + row);
                char insideChar = (char) (97 + row + col);

                StringBuilder currentChar = new StringBuilder();
                currentChar.append(outsideChar);
                currentChar.append(insideChar);
                currentChar.append(outsideChar);

                matrix[row][col] = currentChar;
            }
        }

        return matrix;
    }

    public static void printTheMatrix(StringBuilder[][] matrix){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
