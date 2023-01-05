import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BSTTest {

    public static void main(String[] args) {
        // initialize variables
        BST bst = new BST();
        ArrayList<Integer> keyList = new ArrayList<Integer>();
        int key = 0;
        String option = "";
        Scanner input = new Scanner(System.in);

        // prompt user to insert key as root node
        System.out.println("-------------Populate BST-------------");
        while (key != -1) {
            System.out.print("Enter key to be inserted (-1 once complete): ");
            key = enterInt(input);
            if (key != -1) {
                keyList.add(key);
                bst.insertNode(key);
                System.out.printf("%d has been inserted into the BST.\n", key);
            }
        }
        System.out.print("BST has been populated.\n");

        // switch case to perform different operations on BST
        while (!option.equals("5")) {
            menu(); // prints out menu for user to pick action
            option = input.next();

            switch (option) {
                case "1": // insert node
                    System.out.println("\n--------------Insert Node-------------");
                    System.out.print("Enter key to be inserted (-1 once complete): ");
                    key = enterInt(input);
                    while (key != -1) {
                        keyList.add(key);
                        bst.insertNode(key);
                        System.out.printf("%d has been inserted into the BST.\n", key);
                        System.out.print("Enter key to be inserted (-1 once complete): ");
                        key = enterInt(input);
                    }
                    break;

                case "2": // delete node
                    System.out.println("\n--------------Delete Node-------------");
                    System.out.print("Enter key to be deleted (-1 once complete): ");
                    key = enterInt(input);
                    while (key != -1) {
                        if (keyList.contains(key)) {
                            keyList.remove(keyList.indexOf(key));
                            bst.deleteNode(key);
                            System.out.printf("%d has been deleted from the BST.\n", key);
                            System.out.print("Enter key to be deleted (-1 once complete): ");
                            key = enterInt(input);
                        } else {
                            System.out.println("\nKey does not exist.");
                            System.out.print("Enter key to be deleted (-1 once complete): ");
                            key = enterInt(input);
                        }
                    }
                    break;

                case "3": // tree traversal
                    System.out.print("\n------------Tree Traversal------------");

                    System.out.println("\nPre-order traversal:");
                    bst.preOrderTraversal();

                    System.out.println("\n\nIn-order traversal:");
                    bst.inOrderTraversal();

                    System.out.println("\n\nPost-order traversal:");
                    bst.postOrderTraversal();

                    System.out.println();
                    break;

                case "4": // print tree
                    System.out.print("\n---------Visualization of BST---------\n");
                    bst.printBST();
                    break;

                case "5":
                    break;

                default:
                    System.out.println("\nERROR! Please enter either 1, 2, 3, 4, or 5.");
            }
        }
        input.close();
        System.out.println("\nProgram has ended.");
    }

    public static void menu() {
        System.out.println("\n-----------------Menu-----------------");
        System.out.println("1. Insert Node");
        System.out.println("2. Delete Node");
        System.out.println("3. Tree Traversal");
        System.out.println("4. Print Tree");
        System.out.println("5. Exit");
        System.out.print("Enter operation to be carried out on BST: ");
    }

    public static int enterInt(Scanner input) {
        int key;
        while (true) {
            try {
                key = input.nextInt();
                return key;
            } catch (InputMismatchException e) {
                input.next();
                System.out.print("\nThat's not an integer. Try again: ");
            }
        }
    }
}