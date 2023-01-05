public class TreeNode {
   protected TreeNode left;   // left node
   protected Object data;     // data item
   protected TreeNode right;  // right node

   public TreeNode( Object newData )
   {
      data = newData;
      left = right = null;
   }

   public synchronized void insert( Integer number )
   {
      // new value is less than the node's data's value
      if ( number.intValue() < ( ( Integer ) data ).intValue() ) {
         if ( left == null )
            left = new TreeNode( number );

         else
            left.insert( number );

      }

      // assignment operator allows duplicate values
      else if ( number.intValue() >= ( ( Integer ) data ).intValue() ) {
         if ( right == null )
            right = new TreeNode( number );

         else
            right.insert( number );
      }

   }

   // get right child
   public synchronized TreeNode getRight()
   {
      return right;
   }

   // get left child
   public synchronized TreeNode getLeft()
   {
      return left;
   }

   // return the data
   public synchronized Object getData()
   {
      return data;
   }

}  // end class TreeNode
