package richardxin.leetcode;

public class TreeUtil {
	private static TreeNode<Integer> createMinimalBST(int arr[], int start, int end){
		/*
		 * given sorted array with unique integer, create BST(binary search tree) with minimal height
		 * 
		 */		
		if (start>end) return null;
		int mid = (start+end)/2;
		TreeNode<Integer> n = new TreeNode<Integer>(arr[mid]);
		n.left = createMinimalBST(arr, start, mid-1);		
		n.right = createMinimalBST(arr, mid+1, end);
		return n;
	}
	
	public static TreeNode<Integer> createMinimalBST(int array[]){
		return createMinimalBST(array, 0, array.length -1);
	}
	
	public static boolean lookup(TreeNode<Integer> node, Integer target) {
		/*
		 * Given a binary tree, return true if a node with the target data is
		 * found in the tree. Recurs down the tree, chooses the left or right
		 * branch by comparing the target to each node.
		 */

		// 1. if null return false
		if (node == null) {
			return false;
		} else {
			// 2. see if found here
			if (target == node.data)
				return true;
			else {
				// 3. otherwise recur down the correct subtree
				if (target < node.data)
					return lookup(node.left, target);
				else
					return lookup(node.right, target);
			}
		}
	}
	
	public static TreeNode<Integer> insert(TreeNode<Integer> node, int data){
	/*
	 * insert a new node with the given number into the tree in the correct place. 
	 * Calling insert() with the number 5 on this tree...
		    2
		   / \
		  1   10
		
		returns the tree...
		    2
		   / \
		  1   10
		     /
		    5 
	 * 
	 */
		if (node == null){
			return new TreeNode<Integer>(data);
		} else {
			if (data <= node.data)
				node.left = insert(node.left, data);
			else
				node.right = insert(node.right, data);
		}
		return node;
	}
	
	public void mirror(TreeNode<Integer> root) {
		mirrorHelp(root);
	}
	
	private static void mirrorHelp(TreeNode<Integer> node){
		/**
		 Changes the tree into its mirror image.

		 So the tree...
		       4
		      / \
		     2   5
		    / \
		   1   3

		 is changed to...
		       4
		      / \
		     5   2
		        / \
		       3   1

		 Uses a recursive helper that recurs over the tree,
		 swapping the left/right pointers.
		*/
		
		if (node != null){
			mirrorHelp(node.left);
			mirrorHelp(node.right);
		}
		
		TreeNode<Integer> temp = node.left;
		node.left = node.right;
		node.right = temp;		
	}
	
	public static boolean sameTree(TreeNode<Integer> node1, TreeNode<Integer> node2){
		/*
		 Compares 2 tree nodes to
		 see if they have the same data and structurally identical.
		*/
		 if (node1 == null && node2 == null)
			 return true;
		 
		 if (node1 != null && node2 != null){
			 return (node1.data == node2.data) &&
					 sameTree (node1.left, node2.left) &&
					 sameTree (node1.right, node2.right);
		 } else 
			 return false;	
	}
}
