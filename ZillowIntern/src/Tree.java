/* */
// The following definitions of Tree and Node are provided.
// insert and delete will be methods of class Tree.

public class Tree {
    private class Node {
        private int val;
        private Node left = null;
        private Node right = null;
        private Node mid = null;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;


    /* 
     * Please complete this method.
     * Inserts val into the tree. There is no need to rebalance the tree.
     */
    public void insert(int val) {
        
        if(root == null)
        {
           root = new Node(val);
           
        }
        else
        {
            Node currNode = root;
            Node parentNode = null;
            char  lastSide =' ' ;
            
            while(currNode !=null)
            {
                if(val==currNode.val)
                {
                    parentNode = currNode;
                    currNode = currNode.mid;
                    lastSide = 'm';
                }
                else if(val < currNode.val)
                {
                    parentNode = currNode;
                    currNode = currNode.left;
                    lastSide = 'l';
                }
                else
                {
                    parentNode  = currNode;
                    currNode = currNode.right;
                    lastSide = 'r';
                }
            }
            
            if(lastSide == 'm')
            {
                currNode = new Node(val);
                parentNode.mid = currNode;
            }
            else if(lastSide == 'l')
            {
               currNode = new Node(val);
               parentNode.left = new Node(val);
            }
            else
            {
               currNode = new Node(val);
               parentNode.right = new Node(val);
            }
            
            
        }

    }
    
    /*
     * TO find the number of children in a node 
     */
    
    public int getNumofChildren(Node node)
    {
    	int numChildren =0;
    	if(node.left!=null)
    	{
    		numChildren ++;
    	}
    	if(node.right!= null)
    	{
    		numChildren++;
    	}
    	if(node.mid!=null)
    	{
    		numChildren++;
    	}
    	return numChildren;
    }
    
    public Node getSuccessor(Node node)
    {
    	Node returnNode = null;
    	Node currNode = node;
    	Node parentNode = null;
    	while(currNode.left!=null)
    	{
    		parentNode = currNode;
    		currNode = currNode.left;
    	}
    	
    	
		returnNode = currNode;
		
	
    	
    	
    	return returnNode;
    }


    /*
    *   Recursive function for delete
    */

    public Node delete(Node currNode,int val)
    {
       if(currNode == null)
       {
       	 return null;
       }
       else 
       {
       	 if(currNode.val > val)
       	 {
            currNode.left = delete(currNode.left,val);
       	 }
       	 else if(currNode.val<val)
       	 {
       	 	currNode.right = delete(currNode.right,val);
       	 }
       	 else
       	 {
       	 	int numChildren = getNumofChildren(currNode);
       	 	if(numChildren == 0)
       	 	{
       	 		currNode = null;
       	 		return currNode;
       	 	}
       	 	else if(numChildren ==1)
       	 	{
               if(currNode.mid!=null)
               {
               	  currNode.mid = currNode.mid.mid;
               	  return currNode;
               }
               else if(currNode.right!=null)
               {
               	 currNode = currNode.right;
               	 return currNode;
               }
               else
               {
               	  currNode = currNode.left;
               	  return currNode;
               }
       	 	}
       	 	else
       	 	{
                if(currNode.mid!=null)
                {
                	currNode.mid = currNode.mid.mid;
                	return currNode;
                }
                else
                {
                	Node successorNode = getSuccessor(currNode.right);           
                    currNode.right = delete(currNode,successorNode.val);
                    currNode.val = successorNode.val;
                } 
       	 	}
       	 }
       }
       return currNode;
    }

    /* 
     * Please complete this method.
     * Deletes only one instance of val from the tree.
     * If val does not exist in the tree, do nothing.
     * There is no need to rebalance the tree.
     */
    public void delete(int val) {
    	//System.out.println("delete");
    	if(root != null)
    	{
    		root = delete(root,val);
    	}
           
    }
    
    public void inOrderTraversal(Node root)
    {
    	if(root != null)
    	{
    		inOrderTraversal(root.left);
        	inOrderTraversal(root.mid);
        	System.out.println(root.val);
        	inOrderTraversal(root.right);
    	}
    }
    
    public static void main(String[] args)
    {
    	Tree obj = new Tree();
    	//5,4,9,5,7,2,2
    	obj.insert(5);
    	obj.insert(4);
    	obj.insert(9);
    	obj.insert(5);
    	obj.insert(7);
    	obj.insert(2);
    	obj.insert(2);
    	obj.inOrderTraversal(obj.root);
    	obj.delete(4);
    	Node currNode = obj.root;
    	obj.inOrderTraversal(currNode);
    }
    
}
