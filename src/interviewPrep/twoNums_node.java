package interviewPrep;

import interviewPrep.spltLinkedList.LinkedList;
import interviewPrep.spltLinkedList.Node;

public class twoNums_node {
	
	// reverse LL, do normal operations w/ carry over. multiply each sum by 10^n where n is the # of additions done to that point
 
	public static void reverseList(LinkedList r1, LinkedList l1) {
		
		Node temp = r1.head;
		Node curr = r1.head;
		Node prev = null;
		Node head = null;
		
		while(curr != null) {
			temp = temp.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		r1.head = prev;
		
		temp = l1.head;
		curr = l1.head;
		prev = null;
		
		while(curr != null) {
			temp = temp.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		l1.head = prev;
	}
	
	
	public static void fillZeroes(LinkedList r1, LinkedList l1) {
		
		if(r1.size == l1.size) return;
		
		
		int r1_size = r1.size;
		int l1_size = l1.size;
		
		if(r1.size > l1.size) {
			while(l1_size != r1_size) {
				
				Node zero = new Node(0);
				zero.next = l1.head;
				l1.head = zero;
				r1_size--;		
			}
		}else {
			while(l1_size != r1_size) {
				Node zero = new Node(0);
				zero.next = r1.head;
				r1.head = zero;
				l1_size--;
			}
		}
		
		
	}
	
	public static int addNodes(Node r1, Node l1) {
		
		int total = 0;
		int sum = 0;
		int num_ops = 0;
		int carry_over = 0;
		
		
		Node r_curr = r1;
		Node l_curr = l1;
		
		while(l_curr != null) {
			
			sum = r_curr.val + l_curr.val + carry_over;
			carry_over = (sum >= 10 ?  1 : 0);
			sum = sum%10;
			total += (int) (sum * Math.pow(10,num_ops));
			num_ops++;
			l_curr = l_curr.next;
			r_curr = r_curr.next;
		}
		
		// if carry_over on last addition
		if(carry_over == 1) {
			total += (int) (Math.pow(10,num_ops));
		}
		
		
		return total;
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		LinkedList list1 = new LinkedList();
		LinkedList list2 = new LinkedList();
		
		Node r1 = new Node(9);
		Node r2 = new Node(9);
		Node r3 = new Node(9);
		
		Node l1 = new Node(3);
		Node l2 = new Node(4);
		Node l3 = new Node(4);
		//Node l4 = new Node(5);
		
		list1.addNode(r1);
		list1.addNode(r2);
		list1.addNode(r3);
		
		list2.addNode(l1);
		list2.addNode(l2);
		list2.addNode(l3);
		//list2.addNode(l4);
		
		fillZeroes(list1,list2);
		reverseList(list1,list2);
		
		list1.printList();
		list2.printList();
		
		int res = addNodes(list1.head,list2.head);
		
		System.out.println(res);
		
		
		
		
		
		
	}
	
	
	
}
