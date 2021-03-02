import java.util.*;
import java.lang.*;

public class GoblinTower {

    public static int randomStart(int min, int max) {
        Random rand = new Random();

        return rand.nextInt(max - min) + min;
    }

    public static void main(String[] args) {

        // System Objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // Hero Variables
        int h_maxHealth = 20; //20-30
        int h_attackPower = 3; //1-3
        int h_defensePower = 5; //1-5
        char f = '2';
        char [] h_potions = new char[randomStart(1,5)]; //max 5 slots, ea. slot set to 2
        for (int i = 0; i < h_potions.length; i++) {
            h_potions[i] = f;
        }
        int h_gold = 0;

        // Goblin Variables
        int g_health = 10; //5-10
        int g_attackPower = 3; //2-3
        int g_defensePower = 2; //1-2

        //Start filling HERO variables
        h_maxHealth = randomStart(20,30);
        System.out.println("HERO'S Health is " + h_maxHealth);
        h_attackPower = randomStart(1,3);
        System.out.println("HERO'S Attack Power is " + h_attackPower);
        h_defensePower = randomStart(1,5);
        System.out.println("HERO'S Defense Power is " + h_defensePower);
        // Array
        System.out.println("HERO'S Potions' size is " + h_potions.length
                + " and looks like: " + Arrays.toString(h_potions));
        System.out.println("HERO'S Gold is " + h_gold + "\n");

        //Start filling GOBLIN variables
        g_health = randomStart(5,10);
        System.out.println("GOBLIN'S Health is " + g_health);
        g_attackPower = randomStart(2,3);
        System.out.println("GOBLIN'S Attack Power is " + g_attackPower);
        g_defensePower = randomStart(1,2);
        System.out.println("GOBLIN'S Defense Power is " + g_defensePower);

    }
}
