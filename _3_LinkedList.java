import java.util.Scanner;

class Node{
	int val;
	Node next;
	Node(int val, Node next){
		this.val=val;
		this.next=next;
	}
}
class LinkedListMethods{
	private Node head;
	
	void getHead(){
		System.out.println(head.val);;
	}
	
	LinkedListMethods(){
		head=null;
	}
	
	void addElementAtEnd(int a){
		if(head==null) {
			head = new Node(a,null);
			return;
		}
		Node curr=head;
		while(curr.next!=null) {
			curr=curr.next;
		}
		curr.next=new Node(a,null);
	}
	
	void deleteAtIndex(int a){
		Node curr=head;
		for(int i =0;i<a-1;i++) {
			curr=curr.next;
		}
		curr.next=curr.next.next;
	}
	
	void addAtHead(int a) {
		if(head==null) {
			head=new Node(a,null);
			return;
		}
		head=new Node(a,head);
		return;
	}
	
	void reverseALinkList() {
		Node curr,prev;
		curr = head.next;
		if(curr==null) return;
		prev=head;
		
		while(curr != null) {
			Node Next = curr.next;
			curr.next = prev;
			prev=curr;
			curr=Next;
		}
		
		head.next=null;
		head=prev;
	}
	
	void print() {
		Node curr = head;
		while(curr!=null) {
			System.out.print(curr.val);
			if(curr.next!=null) {
				System.out.print("----->");
			}
			curr=curr.next;
		}
	}
}

public class _3_LinkedList {

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter the no of element you want to add in the Linked List");
       LinkedListMethods lm = new LinkedListMethods();
       int a = sc.nextInt();
       sc.nextLine();
       for(int i =0;i<a;i++) {
    	   int b = sc.nextInt();
    	   lm.addElementAtEnd(b);
	   }
       System.out.println("Enter the no of element you want to add at the head of the Linked List");
       a = sc.nextInt();
       sc.nextLine();
       for(int i =0;i<a;i++) {
    	   int b = sc.nextInt();
    	   lm.addAtHead(b);
	   }
       lm.getHead();
       lm.print();
       
       sc.close();
       lm.deleteAtIndex(2);
       lm.reverseALinkList();
       lm.print();
    }
    
}