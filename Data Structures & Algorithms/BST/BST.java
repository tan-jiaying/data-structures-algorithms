public class BST {
	private Node root;
	
	// constructor 
	public BST() {
		root = null;
	}

	// insertion method 
	public void insertNode(int key) {
		root = insertHelper(root, key);
	}
	
	public Node insertHelper(Node root, int key) {
		// base case: if BST is empty 
		if (root == null) {
			root = new Node(key);
			return root;
		}
		
		// recursive case: go down the BST
		if (key < root.key) {
			root.left = insertHelper(root.left, key);
		}
		else if (key > root.key) {
			root.right = insertHelper(root.right, key);
		}
		
		return root;
	}
	
	
	// deletion method
	public void deleteNode(int key) {
		root = deleteHelper(root, key);
	}
	
	public Node deleteHelper(Node root, int key) {
		// base case: if BST is empty 
		if (root == null) {
			return root;
		}
		
		// recursive case: go down the BST 
		if (key < root.key) {
			root.left = deleteHelper(root.left, key);
		}
		else if (key > root.key) {
			root.right = deleteHelper(root.right, key);
		}
		
		// if key = root's key, then node to be deleted is found
		else {
			// if the node has no child or only one child
			if (root.left == null) {
				return root.right;
			}
			else if (root.right == null) {
				return root.left;
			}
			
			// if the node has two children
			root.key = minKey(root.right); // find the smallest key in the right subtree
			root.right = deleteHelper(root.right, root.key); 
		}
		
		return root;
	}
	
	public int minKey(Node root) {
		int min = root.key; 
		while (root.left != null) { // keep looping as long as there is a smaller value 
			min = root.left.key;
			root = root.left;
		}
		
		return min;
	}
	
	// pre-order traversal method
	public void preOrderTraversal() {
		preOrderHelper(root);
	}
	
	private void preOrderHelper(Node root) {
		if (root != null) {
			System.out.print(root.key + " ");
			preOrderHelper(root.left);
			preOrderHelper(root.right);
		}
	}
	
	// in-order traversal method 
	public void inOrderTraversal() {
		inOrderHelper(root);
	}
	
	private void inOrderHelper(Node root) {
		if (root != null) {
			inOrderHelper(root.left);
			System.out.print(root.key + " ");
			inOrderHelper(root.right);
		}
	}
	
	// post-order traversal method 
	public void postOrderTraversal() {
		postOrderHelper(root);
	}
	
	private void postOrderHelper(Node root) {
		if (root != null) {
			postOrderHelper(root.left);
			postOrderHelper(root.right);
			System.out.print(root.key + " ");
		}
	}
	
	// print tree method
	public void printBST() {
		if (root != null) {
			System.out.print("Root====");
			System.out.println(root.key);
			printHelper(root.left, "      ", false);
			printHelper(root.right, "      ", true);
		}
	}
	
	private void printHelper(Node node, String indent, boolean isRight) {
		if (node != null) {
			System.out.print(indent);
			
			if (isRight) {
				System.out.print("R====");
				indent += "   ";
			} 
			else {
				System.out.print("L====");
				indent += "|  ";
			}
			
			System.out.println(node.key);
			printHelper(node.left, indent, false);
			printHelper(node.right, indent, true);
		}
	}
}