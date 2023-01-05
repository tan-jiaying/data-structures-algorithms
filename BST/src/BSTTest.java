import java.util.ArrayList;
import java.util.Scanner;

public class BSTTest {
	
	public static void main(String[] args) {
		// initialize variables
		BST bst = new BST();
		ArrayList<Integer> keyList = new ArrayList<Integer>();
		int key = 0;
		int option = 0;
		
		// prompt user to insert key as root node
		Scanner input = new Scanner(System.in);
		System.out.println("-------------Populate BST-------------");
		while (key != -1) {
			System.out.print("Enter key to be inserted (-1 once complete): ");
			key = input.nextInt();
			if (key != -1) {
				keyList.add(key);
				bst.insertNode(key);
			}
		}
		System.out.print("BST has been populated.\n");
		
		// switch case to perform different operations on BST
		while (option != 5) {
			System.out.println("\n-----------------Menu-----------------");
			System.out.println("1. Insert Node");
			System.out.println("2. Delete Node");
			System.out.println("3. Tree Traversal");
			System.out.println("4. Print Tree");
			System.out.println("5. Exit");
			System.out.print("Enter operation to be carried out on BST: ");
			option = input.nextInt();
			
			switch (option) {
				case 1: // insert node
					System.out.println("\n--------------Insert Node-------------");
					System.out.print("\nEnter key to be inserted: ");
					key = input.nextInt();
					keyList.add(key);
					bst.insertNode(key); 
					System.out.printf("%d has been inserted into the BST.\n", key);
					break;
					
				case 2: // delete node
					System.out.println("\n--------------Delete Node-------------");
					System.out.print("Enter key to be deleted: ");
					key = input.nextInt();
					if (keyList.contains(key)) {
						keyList.remove(keyList.indexOf(key));
						bst.deleteNode(key);
						System.out.printf("%d has been deleted from the BST.\n", key);
					} 
					else {
						System.out.println("\nKey does not exist.");
					}
					break;
					
				case 3: // tree traversal 
					System.out.print("\n------------Tree Traversal------------");
					
					System.out.println("\nPre-order traversal:");
					bst.preOrderTraversal();
					
					System.out.println("\n\nIn-order traversal:");
					bst.inOrderTraversal();
					
					System.out.println("\n\nPost-order traversal:");
					bst.postOrderTraversal();
					
					System.out.println();
					break;
					
				case 4: // print tree
					System.out.print("\n---------Visualization of BST---------\n");
					bst.printBST();
					break;
			}
		}
		
		System.out.println("\nProgram has ended.");
	}
}
