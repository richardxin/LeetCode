package richardxin.leetcode;
/*
 * Definition for node of singly-linked list.
 */
public class ListNode <T> {
	// very basic implementation of singly linked list
	public ListNode<T> next = null;
	T data;
	
	public ListNode (T data){
		this.data = data;
	}
	
	void appendToTail(T d){
		ListNode<T> end = new ListNode<>(d);
		ListNode<T> n = this;
		while (n.next != null){
			n = (ListNode<T>) n.next;
		}
		n.next = end;
	}	
}

