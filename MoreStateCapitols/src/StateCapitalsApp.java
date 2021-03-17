/*

    Zachary Tarell

 */
import java.io.File;
import java.io.IOException;
import java.util.*;

public class StateCapitalsApp {

    private final Map<String, Capital> capitals = new HashMap<>();

    /**
     * Reads input file data and creates a hash map of state capital information.
     */
    private void createMap() throws IOException {
        System.out.println("Importing file data");
        Scanner fin = new Scanner(new File("MoreStateCapitals.txt")).useDelimiter("::|\\r\\n");

        while (fin.hasNext()) {
            String state = fin.next();
            String capital = fin.next();
            int population = fin.nextInt();
            double squareMileage = fin.nextDouble();

            capitals.put(state, new Capital(capital, population, squareMileage));

        }
        fin.close();

//        for( Map.Entry<String, Capital> entry : capitals.entrySet() ){
//            System.out.println( entry.getKey() + " => " + entry.getValue() );
//        };
//        System.out.println(capitals);
    }

    /**
     * Prints the size of the hash map to the console.
     */
    private void printMapSize() {
        System.out.println("\nNumber of state capitals: " + capitals.size());
    }

    /**
     * Accesses the set of all keys in the hash map and prints the key-value pairs to the console.
     */
    private void printKeyValuePairs() {
        System.out.println("\nPrinting key-value pairs");
        Set<String> keys = capitals.keySet();
        for (String key : keys)
            System.out.printf("%s, %s, %d, %.2f\n", key, capitals.get(key).getName(), capitals.get(key).getPopulation(), capitals.get(key).getSquareMileage());
    }

    /**
     * Prompts the user to input a minimum population, then accesses the set of all keys in the hash map, and prints only the key-value pairs with a population greater than the input value.
     */
    private void limitPopulation() {
        System.out.println("\nPlease enter the lower limit for capital city population:");
        Scanner in = new Scanner(System.in);
        int minPopulation = in.nextInt();

        System.out.println("\nPrinting key-value pairs");
        Set<String> keys = capitals.keySet();
        for (String key : keys)
            if (capitals.get(key).getPopulation() >= minPopulation)
                System.out.printf("%s, %s, %d, %.2f\n", key, capitals.get(key).getName(), capitals.get(key).getPopulation(), capitals.get(key).getSquareMileage());
    }

    /**
     * Prompts the user to input a maximum square mileage, then accesses the set of all keys in the hash map, and prints only the key-value pairs with a square mileage less than the input value.
     */
    private void limitSquareMileage() {
        System.out.println("\nPlease enter the upper limit for capital city square mileage:");
        Scanner in = new Scanner(System.in);
        int maxSquareMileage = in.nextInt();

        System.out.println("\nPrinting key-value pairs");
        Set<String> keys = capitals.keySet();
        for (String key : keys)
            if (capitals.get(key).getSquareMileage() <= maxSquareMileage)
                System.out.printf("%s, %s, %d, %.2f\n", key, capitals.get(key).getName(), capitals.get(key).getPopulation(), capitals.get(key).getSquareMileage());
    }

    /**
     * Controls operation of the program
     * @param args arguments
     */
    public static void main(String[] args) throws IOException {
        StateCapitalsApp capitals = new StateCapitalsApp();
        capitals.createMap();
        capitals.printMapSize();
        capitals.printKeyValuePairs();
        capitals.limitPopulation();
        capitals.limitSquareMileage();
    }

}