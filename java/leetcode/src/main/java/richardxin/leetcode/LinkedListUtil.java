package richardxin.leetcode;

import java.util.LinkedList;

public class LinkedListUtil {
	public static ListNode<Integer> getOddEvenSorted(ListNode<Integer> head){
		/*
		 * 328. Odd Even Linked List
		 * 
		 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
		 * Please note here we are talking about the node number and not the value in the nodes.
		 * 
		 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
		 * 
		 * Note:
		 * The relative order inside both the even and odd groups should remain as it was in the input.
		 * The first node is considered odd, the second node even and so on ... 
		 */
		if (head == null) return head;
		// 2 pointers, one for odd node and one for even node
		ListNode<Integer> p = head;
		ListNode<Integer> q = head;
		while (q != null){
			q = q.next;
			if (q == null || q.next == null)
				break;
			ListNode<Integer> next_p = p.next;
			ListNode<Integer> next_q = q.next;
			q.next =  next_q.next;
			p.next = next_q;
			next_q.next = next_p;
			p= p.next;			
		}
		return head;		
	}
	
	public static void deleteDups(ListNode node){
		/*
		 * Remove duplicates from an unsorted linked list
		 */
	}
}
