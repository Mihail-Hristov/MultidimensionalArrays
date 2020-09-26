import java.util.Scanner;

public class TheHeiganDance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double heigansDamage = Double.parseDouble(scanner.nextLine());

        int playerPoints = 18500;
        double heiganPoints = 3000000;

        int[][] battlefield = new int[15][15];

        for (int row = 0; row < 15; row++) {
            for (int col = 0; col < 15; col++) {
                battlefield[row][col] = 0;
            }
        }
        int playerRow = 7;
        int playerCol = 7;

        int damageForPlayer = 0;
        int countCloudDamage = 0;

        boolean playerIsDead = false;
        boolean heiganIsDead = false;
        String playerDeadFrom = "";

        while (playerPoints > 0 && heiganPoints > 0){

            String[] token = scanner.nextLine().split("\\s+");
            String spell = token[0];
            int currentRow = Integer.parseInt(token[1]);
            int currentCol = Integer.parseInt(token[2]);

            heiganPoints -= heigansDamage;



            if (countCloudDamage > 0){
                playerPoints -= 3500;
                countCloudDamage --;
                if (playerPoints <= 0){
                    playerIsDead = true;
                    playerDeadFrom = "Plague Cloud";
                    break;
                }
            }

            if (heiganPoints <= 0){
                heiganIsDead = true;
                break;
            }


            switch (spell){
                case "Cloud":
                    damageForPlayer = 3500;
                    countCloudDamage ++;

                    break;
                case "Eruption":
                    damageForPlayer = 6000;

                    break;
            }

            if ((currentRow - 1 <= playerRow && playerRow <= currentRow + 1)
                    && (currentCol - 1 <= playerCol && playerCol <= currentCol + 1)){
                if (currentRow - 1 > playerRow - 1 && playerRow - 1 >= 0){
                    playerRow -= 1;
                    if (spell.equals("Cloud")){
                        countCloudDamage --;
                    }
                }else if (currentCol + 1 < playerCol + 1 && (playerCol + 1) < 15){
                    playerCol += 1;
                    if (spell.equals("Cloud")){
                        countCloudDamage --;
                    }
                }else if (currentRow + 1 < playerRow + 1 && playerRow + 1 < 15){
                    playerRow += 1;
                    if (spell.equals("Cloud")){
                        countCloudDamage --;
                    }
                }else if (currentCol - 1 > playerCol - 1 && playerCol - 1 >= 0){
                    playerCol -= 1;
                    if (spell.equals("Cloud")){
                        countCloudDamage --;
                    }
                }else {
                    playerPoints -= damageForPlayer;
                }
            }


            if (playerPoints <= 0){
                playerIsDead = true;
                if (spell.equals("Cloud")){
                    playerDeadFrom = "Plague Cloud";
                }else {
                    playerDeadFrom = spell;
                }
            }
        }

        if (heiganIsDead){
            System.out.println("Heigan: Defeated!");
        }else {
            System.out.println(String.format("Heigan: %.2f", heiganPoints));
        }

        if(playerIsDead){
            System.out.println(String.format("Player: Killed by %s", playerDeadFrom));
        }else {
            System.out.println(String.format("Player: %d", playerPoints));
        }

        System.out.println(String.format("Final position: %d, %d", playerRow, playerCol));



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
