package richardxin.leetcode;

public class TreeUtil {
	private TreeNode<Integer> createMinimalBST(int arr[], int start, int end){
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
	
	public TreeNode<Integer> createMinimalBST(int array[]){
		return createMinimalBST(array, 0, array.length -1);
	}
}
