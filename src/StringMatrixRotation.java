import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        int degrees = Integer.parseInt(command.substring(7 , command.length() - 1));
        int countRotation = degrees / 90;
        int typeOfMatrix = countRotation % 4;

        String input = scanner.nextLine();

        List<String> words = new ArrayList<>();
        int maxLength = 0;

        while (!"END".equals(input)){

            int currentLength = input.length();
            if (currentLength > maxLength){
                maxLength = currentLength;
            }
            words.add(input);

            input = scanner.nextLine();
        }


        switch (typeOfMatrix){
            case 0:
                char[][] matrixOfType0 = new char[words.size()][maxLength];

                for (int row = 0; row < matrixOfType0.length; row++) {
                    String currentWordFor0 = words.get(row);
                    char currentCharFor0;
                    for (int col = 0; col < matrixOfType0[row].length; col++) {
                        if (col < currentWordFor0.length()) {
                            currentCharFor0 = currentWordFor0.charAt(col);
                        }else {
                            currentCharFor0 = ' ';
                        }
                        matrixOfType0[row][col] = currentCharFor0;
                    }
                }

                printTheMatrix(matrixOfType0);

                break;
            case 1:
                char[][] matrixOfType1 = new char[maxLength][words.size()];

                for (int row = 0; row < maxLength; row++) {
                    for (int col = 0; col < words.size(); col++) {
                        char currentCharFor1;
                        String currentWordFor1 = words.get((words.size() - 1) - col);
                        if (row < currentWordFor1.length()) {
                            currentCharFor1 = currentWordFor1.charAt(row);
                        }else {
                            currentCharFor1 = ' ';
                        }
                        matrixOfType1[row][col] = currentCharFor1;
                    }
                }

                printTheMatrix(matrixOfType1);

                break;
            case 2:
                char[][] matrixOfType2 = new char[words.size()][maxLength];

                for (int row = words.size() - 1; row >= 0; row--) {
                    String currentWordFor2 = words.get(row);
                    char currentCharFor2;
                    int countChar = 0;
                    for (int col = maxLength - 1; col >= 0; col--) {
                        if (countChar < currentWordFor2.length()){
                            currentCharFor2 = currentWordFor2.charAt(countChar);
                        }else {
                            currentCharFor2 = ' ';
                        }
                        matrixOfType2[(words.size() - 1) - row][col] = currentCharFor2;
                        countChar ++;
                    }
                }

                printTheMatrix(matrixOfType2);

                break;
            case 3:
                char[][] matrixOfType3 = new char[maxLength][words.size()];

                int countChar = -1;
                for (int row = maxLength - 1; row >= 0 ; row--) {
                    countChar ++;
                    for (int col = 0; col < words.size(); col++) {
                        String currentWordFor3 = words.get(col);
                        char currentCharFor3;
                        if (row >= maxLength - currentWordFor3.length()){
                            currentCharFor3 = currentWordFor3.charAt(countChar);
                        }else {
                            currentCharFor3 = ' ';
                        }
                        matrixOfType3[row][col] = currentCharFor3;
                   }
                }

                printTheMatrix(matrixOfType3);

                break;
        }


    }

    public static void printTheMatrix(char[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }

    }

}
