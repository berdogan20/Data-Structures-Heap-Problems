package Problems;

public class CheckIfGivenBinaryTreeIsHeap {

	/*
	 * Binary tree needs to fulfill the following two conditions for being a heap
	 * It should be a complete tree
	 * Every node’s value should be greater than or equal to its child node 
	 * Time Complexity: O(N), where N is the number of nodes
	 * Auxiliary Space: O(logN), for recursive stack space.
	 * */
	
	static class Node {
	    int key;
	    Node left, right;
	 
	    Node(int k)
	    {
	        key = k;
	        left = right = null;
	    }
	}
	

	/*
	 * This function checks 
	 * if the tree is complete 
	 * or not, recursively
	 * */
	public boolean isCompleteTree(Node root)
	{
		// if the node does not have a child
		if (root == null ||
				(root.left == null && root.right == null))
		{
			return true;
		}
		
		else if (root.right == null)
		{
			return isCompleteTree(root.left);
		}
		
		else if (root.left == null)
		{
			return false;
		}
		else
		{
			return isCompleteTree(root.left) && isCompleteTree(root.right);
		}
	}
	
	
	/*
	 * This function checks 
	 * if the given tree
	 * has heap property
	 * */
	public boolean isTreeHeap(Node root)
	{
		if (root == null)
		{
			return true;
		}
		else if (root.left == null && root.right == null)
		{
			return true;
		}
		else if (root.right == null)
		{
			return isTreeHeap(root.left);
		}
		else
		{
			if (root.key >= root.left.key 
					&&
					root.key >= root.right.key)
			{
				return isTreeHeap(root.left) && isTreeHeap(root.right);
			}
			
			else
			{
				return false;
			}
		}
	}
	
	
	
	/*
	 * This function checks 
	 * if the given tree is 
	 * a heap or not by considering
	 * its being complete tree
	 * and every node’s value should be 
	 * greater than or equal to its child node
	 * */
	public boolean isHeap(Node root)
	{
		if (root == null)
		{
			return true;
		}
		
		return isCompleteTree(root) && isTreeHeap(root);
		
	}
	
	
	public static void main(String[] args) {
		
		CheckIfGivenBinaryTreeIsHeap bt
        = new CheckIfGivenBinaryTreeIsHeap();

	    Node root = new Node(10);
	    root.left = new Node(9);
	    root.right = new Node(8);
	    root.left.left = new Node(7);
	    root.left.right = new Node(6);
	    root.right.left = new Node(5);
	    root.right.right = new Node(4);
	    root.left.left.left = new Node(3);
	    root.left.left.right = new Node(2);
	    root.left.right.left = new Node(1);
	
	    if (bt.isHeap(root) == true)
	        System.out.println(
	            "Given binary tree is a Heap");
	    else
	        System.out.println(
	            "Given binary tree is not a Heap");
	}

}
