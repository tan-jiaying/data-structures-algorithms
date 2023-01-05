

public class Node {
	protected Node left; // left node
	protected Node right; // right node
	protected int key; // value of node
	
	// constructor 
	public Node(int newKey) {
		key = newKey;
		left = right = null;
	}
}
