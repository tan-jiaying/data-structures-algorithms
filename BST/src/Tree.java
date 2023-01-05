
public class Tree {
   protected TreeNode root;

   // Construct an empty Tree of integers
   public Tree()
   {
      root = null;
   }

   // Insert a new node in the binary search tree.
   // If the root node is null, create the root node here.
   // Otherwise, call the insert method of class TreeNode.
   public synchronized void insertNode( Integer d )
   {
      if ( root == null )
         root = new TreeNode( d );

      else
         root.insert( d );
   }

   // Preorder Traversal
   public synchronized void preorderTraversal()
   {
      preorderHelper( root );
   }

   // Recursive method to perform preorder traversal
   private synchronized void preorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      System.out.print( node.data + " " );
      preorderHelper( node.left );
      preorderHelper( node.right );
   }

   // Inorder Traversal
   public synchronized void inorderTraversal()
   {
      inorderHelper( root );
   }

   // Recursive method to perform inorder traversal
   private synchronized void inorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      inorderHelper( node.left );
      System.out.print( node.data + " " );
      inorderHelper( node.right );
   }

   // Postorder Traversal
   public synchronized void postorderTraversal()
   {
      postorderHelper( root );
   }

   // Recursive method to perform postorder traversal
   private synchronized void postorderHelper( TreeNode node )
   {
      if ( node == null )
         return;

      postorderHelper( node.left );
      postorderHelper( node.right );
      System.out.print( node.data + " " );
   }

}  // end class Tree
