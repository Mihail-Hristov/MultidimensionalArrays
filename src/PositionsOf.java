import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] matrixParameters = scanner.nextLine().split("\\s+");
        
        int rows = Integer.parseInt(matrixParameters[0]);
        int cols = Integer.parseInt(matrixParameters[1]);
        
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int searchingNumber = Integer.parseInt(scanner.nextLine());
        //boolean found = false;

        List<int[]> indexes = new ArrayList<>();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (searchingNumber == matrix[i][j]){
                    indexes.add(new int[] {i, j});
                    //found = true;
                }
            }

        }
        if (indexes.isEmpty()){
            System.out.println("not found");
        }else {
            for ( int[] index: indexes) {
                System.out.println(index[0] + " " + index[1]);
            }
        }
    }
}
