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

        int startRow = row + (Math.min( size - (size - row), size - (size - col)));
        int startCol = row - (Math.min(size - col, size - row));

        int first = startRow;
        int temp = 0;

        while (first >= 0 && temp < size) {
            char current = table[first][temp];
            int[] currentPosition = new int[] {first,temp};
            if (current == 'q' && !Arrays.equals(position, currentPosition)){
                return false;
            }
            first --;
            temp ++;
        }

        int second = startCol;
        int tmp = 0;

        while (second < size && tmp >= 0) {
            char current = table[second][tmp];
            int[] currentPosition = new int[] {first,temp};
            if (current == 'q' && !Arrays.equals(position, currentPosition)){
                return false;
            }
            second ++;
            tmp --;
        }

        return true;
    }

}
