import java.util.Random;
import java.util.*;

class PlayerDeck {

    // Function that draws X number of cards
    public static void drawCards(int card[]) {

        int draw = 0;
        int ctr = 52;
        int discardPile[];

        Scanner input = new Scanner(System.in);
        System.out.println("How many cards would you like to draw?");
        draw = input.nextInt();

        // Printing all shuffled elements of cards
        ctr -= draw;


        for (int i = 0; i < draw; i++) {
            System.out.print(card[i] + " ");

        }
        System.out.println("\n" + ctr);

    }

    // Function which shuffle and print the array
    public static void shuffle(int card[], int n) {

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            // Random for remaining positions.
            int r = i + rand.nextInt(52 - i);

            //swapping the elements
            int temp = card[r];
            card[r] = card[i];
            card[i] = temp;

        }
    }

    // Driver code
    public static void main(String[] args) {
        // Array from 0 to 51
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,
                9, 10, 11, 12, 13, 14, 15,
                16, 17, 18, 19, 20, 21, 22,
                23, 24, 25, 26, 27, 28, 29,
                30, 31, 32, 33, 34, 35, 36,
                37, 38, 39, 40, 41, 42, 43,
                44, 45, 46, 47, 48, 49, 50,
                51};

        shuffle(a, 52);
        drawCards(a);

//        // Printing all shuffled elements of cards
//        for (int i = 0; i < 52; i++)
//            System.out.print(a[i] + " ");

    }
}
