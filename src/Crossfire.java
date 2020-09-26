import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] size = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(size[0]);
        int cols = Integer.parseInt(size[1]);

        int[][] matrix = new int[rows][cols];
        int numberForFilling = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numberForFilling++;
            }
        }

        String input = scanner.nextLine();

        while (!"Nuke it from orbit".equals(input)){
            String[] token = input.split("\\s+");
            int currentRow = Integer.parseInt(token[0]);
            int currentCol = Integer.parseInt(token[1]);
            int currentRadius = Integer.parseInt(token[2]);

            int[] rowForModify = matrix[currentRow];

            boolean haveElementsFromLeft = true;
            boolean haveElementsFromRight = true;
            int takeToIndex = 0;
            int takeFromIndex = rowForModify.length - 1;
            if (currentCol - currentRadius >= 0) {
                takeToIndex = currentCol - currentRadius;
            }else {
                haveElementsFromLeft = false;
            }

            if (currentCol + currentRadius < rowForModify.length){
                takeFromIndex = currentCol + currentRadius + 1;
            }else {
                haveElementsFromRight = false;
                takeFromIndex += 1;
            }

            int[] newRow = new int[takeToIndex + (rowForModify.length - (takeFromIndex))];
            int countCol = 0;

            if (haveElementsFromLeft){
                for (int col = 0; col < takeToIndex; col++) {
                    newRow[col] = rowForModify[col];
                    countCol ++;
                }
            }

            if (haveElementsFromRight){
                for (int col = takeFromIndex; col < rowForModify.length; col++) {
                    newRow[countCol] = rowForModify[col];
                    countCol ++;
                }
            }

            matrix[currentRow] = newRow;


            int fromRow = 0;
            int toRow = matrix.length - 1;

            if (currentRow - currentRadius >= 0){
                fromRow = currentRow - currentRadius;
            }
            if (currentRow + currentRow < matrix.length - 1){
                toRow = currentRow + currentRadius;
            }

            for (int row = fromRow; row <= toRow; row++) {
                if (row == currentRow){
                    continue;
                }else if (matrix[row].length - 1 < currentCol){
                    continue;
                }
                int countCol2 = 0;
                int[] currentRow2 = matrix[row];
                int[] newRow2 = new int[matrix[row].length - 1];
                for (int col = 0; col < currentCol; col++) {
                    newRow2[col] = currentRow2[col];
                    countCol2 ++;
                }
                for (int col = currentCol + 1; col < currentRow2.length; col++) {
                    newRow2[countCol2] = currentRow2[col];
                    countCol2 ++;
                }

                matrix[row] = newRow2;
            }




            input = scanner.nextLine();
        }

        int countRow = 0;
        int countBlankRows = 0;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length < 1){
                countBlankRows ++;
            }
        }

        if (countBlankRows > 0){
            int[][] finalMatrix = new int[matrix.length - countBlankRows][];
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i].length < 1){
                    continue;
                }
                finalMatrix[countRow] = matrix[i];

                countRow ++;
            }

            printTheMatrix(finalMatrix);
        }else {
            printTheMatrix(matrix);
        }


    }

    public static void printTheMatrix(int [][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
