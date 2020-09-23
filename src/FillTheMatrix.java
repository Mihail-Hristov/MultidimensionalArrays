import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] token = scanner.nextLine().split(", ");

        int size = Integer.parseInt(token[0]);
        char typeOfFilling = token[1].charAt(0);

        int[][] matrix = new int[size][size];

        if (typeOfFilling == 'A'){
            matrix = fillTheMatrixOfTypeA(size);
        }else if (typeOfFilling == 'B'){
            matrix = fillTheMatrixOfTypeB(size);
        }else {
            System.out.println("Invalid type");
        }

        printTheMatrix(matrix);

    }

    public static int[][] fillTheMatrixOfTypeA(int size){
        int[][] matrix = new int[size][size];

        int numberForPrinting = 1;

        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = numberForPrinting;
                numberForPrinting ++;
            }
        }

        return matrix;
    }

    public static int[][] fillTheMatrixOfTypeB(int size){
        int[][] matrix = new int[size][size];

        int numberForPrint = 1;

        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = numberForPrint;
                    numberForPrint++;
                }
            }else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = numberForPrint;
                    numberForPrint++;
                }
            }
        }

        return matrix;
    }


    public static void printTheMatrix(int[][] matrix){

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
