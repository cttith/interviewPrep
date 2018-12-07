package interviewPrep;

import java.util.ArrayList;



// split linked list into equal parts, differing by at most one from each other
// return list of equally split lists.
// add null to list if needed

public class spltLinkedList {
	
	public static class LinkedList{
		
		Node head;
		Node tail;
		int size;
		
		LinkedList(){
			this.head = null;
			this.tail = null;
			size = 0;
		}
		
		public void addNode(Node newNode) {
			if(this.isEmpty()) {
				head = newNode;
				tail = head;
			}else {
				tail.next = newNode;
				tail = newNode;
			}
			this.size++;

		}
		
		public int returnSize() {
			return this.size;
		}
		
		public boolean isEmpty() {
			if(size > 0) {
				return false;
			}
			return true;
		}
		
		public void printList() {
			Node temp = head;
			
			while(temp != null) {
				System.out.println(temp.val);
				temp = temp.next;
			}
		}
		
		
	}
	
	public static class Node{
		Node next;
		int val;
		
		Node(int val){
			this.next = null;
			this.val = val;
		}
		
		
	}

	
	public static Node[] split(Node root, int k) {
		
		int size = 0;
		
		Node temp = root;
		while(temp != null) {
			temp = temp.next;
			size++;
		}
		
		int min = size/k;
		int extra = size%k;
		
		Node[] parts = new Node[k];
		Node node = root;
		Node prev = null;
		
		for(int i = 0; i < k; i++,extra--) {
			parts[i] = node;
			for(int j = 0; j < min + (extra > 0 ? 1 : 0); j++) {
				prev = node;
				node = node.next;
			}
			if (prev != null) prev.next = null;  // end link at the min-th + extra num	
		}
		
		
		
		
	return parts;
		
	}
	
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five =  new Node(5);
		
		list.addNode(one);
		list.addNode(two);
		list.addNode(three);
		list.addNode(four);
		list.addNode(five);
		
		list.printList();
		
		Node[] res = split(list.head,3);
		
		for(Node curr : res) {
			
			Node temp = curr;
			while(temp != null) {
				System.out.print(temp.val + " ");
				temp = temp.next;
			}
			System.out.print("\n");
			
		}
			
	}
	
	
	
	
	
}
