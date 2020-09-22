import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = 8;

        int rows = size;
        int cols = size;

        char[][] table = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                table[row][col] = line[col].charAt(0);
            }
        }

        boolean isValidPosition = false;
        int[] position = new int[2];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char currentChar = table[row][col];
                if (currentChar == 'q'){
                    int[] currentPosition = new int[] {row, col};
                    isValidPosition = checkForQueens(currentPosition , size, table);
                    if (isValidPosition){
                        position = currentPosition;
                    }
                }
            }
        }


        System.out.println(position[0] + " " + position[1]);

    }
    public static boolean checkForQueens(int[] position, int size, char[][] table){
        int row = position[0];
        int col = position[1];

        // check horizontal
        for (int i = 0; i < size; i++) {
            char current = table[row][i];
            int[] currentPosition = new int[] {row, i};
            if (current == 'q' && !Arrays.equals(position, currentPosition)){
                return false;
            }
        }

        //check vertical
        for (int i = 0; i < size; i++) {
            char current = table[i][col];
            int[] currentPosition = new int[] {i,col};
            if (current == 'q' && !Arrays.equals(position, currentPosition)){
                return false;
            }
        }

        int difference1 = Math.min( (size - 1) - (size - row), (size - 1) - (size - col));
        int startRow = row + difference1;
        int startCol = col - difference1;

        while (startRow >= 0 && startCol < size) {
            char current = table[startRow][startCol];
            int[] currentPosition = new int[] {startRow,startCol};
            if (current == 'q' && !Arrays.equals(position, currentPosition)){
                return false;
            }
            startRow --;
            startCol ++;
        }

        int difference2 = Math.min((size - 1) - ((size - 1) - row), (size - 1) - (size - col));
        int secondStartRow = row - difference2;
        int secondStarCol = col - difference2;

        while (secondStartRow < size && secondStarCol < size) {
            char current = table[secondStartRow][secondStarCol];
            int[] currentPosition = new int[] {secondStartRow,secondStarCol};
            if (current == 'q' && !Arrays.equals(position, currentPosition)){
                return false;
            }
            secondStartRow ++;
            secondStarCol ++;
        }

        return true;
    }

}
