import java.util.InputMismatchException;
import java.util.Scanner;

public class HashingTest {
    public static void main(String[] args) {
        // initialize variables
        HashTable hash = new HashTable();
        int arraySize;
        Scanner input = new Scanner(System.in);
        String option;

        // Ask user for choice of hashing method
        option = enterCollisionSolution(input);

        // Enter size of array
        arraySize = enterArraySize(input);

        // Create hash table
        hash.createTable(arraySize, option);

        // Input values
        hash.insertValues(option);

        // Perform operations on hash table
        operations(option, hash, input);

        input.close();
        System.out.println("\nProgram ended.");
    }

    public static int enterArraySize(Scanner input) {
        int arraySize;

        System.out.print("\nEnter array size (must be greater than 10): ");
        while (true) {
            try {
                arraySize = input.nextInt();
                while (arraySize < 11) {
                    System.out.print("ERROR! Please enter a value greater than 10: ");
                    arraySize = input.nextInt();
                }
                return arraySize;
            } catch (InputMismatchException e) {
                input.next();
                System.out.print("\nThat's not an integer. Try again: ");
            }
        }
    }

    public static int enterNumOfValues(Scanner input, int arraySize) {
        int count;

        System.out.print("\nEnter number of values to be inserted (must be lesser than " + arraySize + "): ");
        while (true) {
            try {
                count = input.nextInt();
                while (count > arraySize) {
                    System.out.printf("ERROR! Please enter a value lesser than %d: ", arraySize);
                    count = input.nextInt();
                }
                return count;
            } catch (InputMismatchException e) {
                input.next();
                System.out.print("\nThat's not an integer. Try again: ");
            }
        }
    }

    public static void collisionSolutionMenu() {
        System.out.println("\n----------------------Option-----------------------");
        System.out.println("1. Linear Probing");
        System.out.println("2. Double Hashing");
        System.out.println("3. Separate Chaining");
        System.out.print("Enter choice of collision resolution method: ");
    }

    public static String enterCollisionSolution(Scanner input) {
        collisionSolutionMenu();
        String option = input.next();

        while (!option.equals("1") && !option.equals("2") && !option.equals("3")) {
            System.out.print("\nERROR! Please enter 1, 2, or 3");
            collisionSolutionMenu();
            option = input.next();
        }

        return option;
    }

    public static void operations(String option, HashTable hash, Scanner input) {
        String menuChoice = "0";

        while (!menuChoice.equals("4")) {
            System.out.println("\n-----------------------Menu------------------------");
            System.out.println("1. Insert Value");
            System.out.println("2. View Partial Hash Table");
            System.out.println("3. View Full Hash Table");
            System.out.println("4. Exit");
            System.out.print("Enter operation to be carried out on Hash Table: ");
            menuChoice = input.next();

            switch (menuChoice) {
                case "1": // Insert value
                    hash.insertValues(option);
                    break;

                case "2": // Visualization of index with values
                    hash.displayPartialTable(option);
                    break;

                case "3": // Visualization of complete hash table
                    hash.displayCompleteTable(option);
                    break;

                case "4":
                    break;

                default:
                    System.out.println("\nInsert 1, 2, 3, or 4");
            }
        }
    }
}