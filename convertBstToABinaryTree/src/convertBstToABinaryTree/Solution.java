package convertBstToABinaryTree;

//http://www.geeksforgeeks.org/convert-bst-to-a-binary-tree/
public class Solution {
	
	class Node
	{
		int val;
		Node left = null;
		Node right = null;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
        Solution obj = new Solution();
        Node root = obj . new Node();
        root.val = 5;
        Node left = obj . new Node();
        left.val = 2;
        Node right = obj . new Node();
        right.val = 13;
        root.left = left;
        root.right = right;
        convert(root);
	}
	
	public static void convert(Node root)
	{
		inorderOppTraversal(root, 0);
		System.out.println(root.val);
		System.out.println(root.right.val);
		System.out.println(root.left.val);
	}
	
	public static int  inorderOppTraversal(Node node,int greaterSum)
	{
		if(node ==null)
		{
			return (greaterSum +0);
		}
		greaterSum =inorderOppTraversal(node.right, greaterSum);
		//int temp =greaterSum;
		greaterSum = greaterSum +node.val;
		node.val = greaterSum;
		greaterSum =inorderOppTraversal(node.left, greaterSum);
		return greaterSum;
	}

}
