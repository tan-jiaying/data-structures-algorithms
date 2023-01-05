import java.util.LinkedList;
import java.util.Arrays;
import java.util.Scanner;

public class HashTable {
    String[] array; // for double hashing
    LinkedList[] array1; // for separate chaining
    int arraySize;
    String option;
    Scanner input = new Scanner(System.in);
    String value;

    // checks if a number is a prime number
    public boolean isPrimeNumber(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    // changes the arraysize to a prime number
    public int nextPrimeNumber(int num) {
        num++;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                num++;
                i = 2;
            } else {
                continue;
            }
        }
        return num;
    }

    // creates hash table
    public void createTable(int arraySize, String option) {
        if (isPrimeNumber(arraySize) == false) {
            arraySize = nextPrimeNumber(arraySize);
        }
        // assign the object's arraySize
        this.arraySize = arraySize;

        if (option.equals("1") || option.equals("2")) { // open addressing --> array of strings
            array = new String[arraySize];
        } else { // separate chaining --> array of linked lists
            array1 = new LinkedList[arraySize];
            for (int i = 0; i < arraySize; i++) {
                array1[i] = new LinkedList<String>();
            }
        }
    }

    // first hash function
    public int hashFunction1(String data) {
        int index = data.hashCode();
        index %= arraySize;

        if (index < 0) {
            index += arraySize;
        }

        return index;
    }

    // second hash function
    public int hashFunction2(int index) {
        return 7 - index % 7;
    }

    // validate data into hash table
    public void insert(String data, String option) {
        int index = hashFunction1(data);
        int step = hashFunction2(index);

        if (option.equals("1") || option.equals("2")) { // open addressing
            if (Arrays.asList(array).contains(null) == true) { // array is not full

                while (array[index] != null) { // check for collision
                    System.out.println(data + " experienced collision at index " + index);

                    if (option.equals("1")) { // linear probing
                        if (index == array.length - 1) {
                            index = 0;
                        } else {
                            index++;
                        }
                    } else { // double hashing
                        index += step;
                        index %= arraySize;
                    }
                }

                array[index] = data;
                System.out.println(data + " successfully inserted at index " + index);
            } else { // array is full
                System.out.println("Hash Table is full!");
            }
        } else { // separate chaining
            array1[index].add(data);
            System.out.println(data + " successfully inserted at index " + index);
        }
    }

    public void insertValues(String option) { // insert values
        System.out.println("\n-------------Insert Values for Hashing-------------");
        System.out.print("Enter value to be inserted ('exit' once complete): ");
        value = input.next();

        while (!value.toLowerCase().equals("exit")) {
            insert(value, option);
            System.out.print("Enter value to be inserted ('exit' once complete): ");
            value = input.next();
        }

        System.out.print("\nValues have been added to Hash Table\n");
    }

    public void displayPartialTable(String option) { // view partial hash table
        System.out.println("\n----------------Partial Hash Table---------------");
        for (int i = 0; i < arraySize; i++) {

            // add empty space in front if index < 10
            String indexString = Integer.toString(i);
            if (i < 10) {
                indexString = " " + indexString;
            }

            if (option.equals("1") || option.equals("2")) {
                if (array[i] != null) {
                    System.out.println(indexString + "  |  " + array[i]);
                }
            } else {
                if (!array1[i].isEmpty()) {
                    System.out.println(indexString + "  |  " + array1[i]);
                }
            }
        }
    }

    public void displayCompleteTable(String option) { // view complete hash table
        System.out.println("\n----------------Complete Hash Table---------------");
        for (int i = 0; i < arraySize; i++) {

            // add empty space in front if index < 10
            String indexString = Integer.toString(i);
            if (i < 10) {
                indexString = " " + indexString;
            }

            if (option.equals("1") || option.equals("2")) {
                if (array[i] != null) {
                    System.out.println(indexString + "  |  " + array[i]);
                } else {
                    System.out.println(indexString + "  |  -");
                }
            } else {
                if (!array1[i].isEmpty()) {
                    System.out.println(indexString + "  |  " + array1[i]);
                } else {
                    System.out.println(indexString + "  |  -");
                }
            }

        }
    }
}
