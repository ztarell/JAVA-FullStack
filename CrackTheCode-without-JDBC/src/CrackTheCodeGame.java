/* By Zachary Tarell
* Mthree - c44_feb2021
* 3/5/2021
*/

import java.util.*;

public class CrackTheCodeGame {

    public static void main(String[] args) {

        String rNum; // random number
        String gNum; // guess number
        int rounds = 0;

        rNum = getRandom();
        System.out.println(rNum + " is secret number.");

        do {
            gNum = getGuess();
            System.out.println(gNum + " is guessed number.");
            runGame(rNum, gNum);
            rounds++;
        } while (!rNum.equals(gNum));

        System.out.println("\n<============ CONGRATULATIONS YOU WON ===========>\n"
                + "The secret number was " + rNum
                + " and it only took you " + rounds + " rounds!");

    }

    // random number
    public static String getRandom() {
        String sn; // secret number
        Random randy = new Random();
        sn = String.format("%04d", randy.nextInt(10000));
        return sn;
    }

    // guess number
    public static String getGuess() {
        String gn; // guess number
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Please enter your guess (any 4 digit number): ");
            gn = sc.nextLine();
        } while (gn.length() != 4 || gn.replaceAll("\\D", "").length() != 4);
        return gn;
    }

    // play the game
    public static void runGame(String secret, String guess) {

        int n = secret.length();
        int m = guess.length();

        if (n != m) {
            throw new IllegalArgumentException();
        }
        int exak = 0;
        int parsh = 0;

        int[] sn = new int[10]; // secret number
        int[] gn = new int[10]; // guess number

        for (int i = 0; i < n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                exak++; // if match, increment exak
            } else {
                // otherwise, increment counter to calculate parsh in the second pass
                sn[secret.charAt(i) - '0']++;
                gn[guess.charAt(i) - '0']++;
            }
        }
        // for each character, find the overlapping frequency to get the number of parsh
        for (int i = 0; i < 10; i++) {
            parsh = parsh + Math.min(sn[i], gn[i]);
        }
        System.out.println(String.format("e:%d:p:%d", exak, parsh));
    }

}