import java.util.Stack;
public class _6_Stack {

	public static void main(String[] args) {
		stack s = new stack();
		s.push(2);
		s.push(5);
		System.out.println(s.pop());
		System.out.println(s.isempty());
		Stack<Integer> ss = new Stack<>();
		ss.add(2);
		ss.add(22);
		ss.add(23);
		System.out.println(ss.push(12));
		ss.add(0, 1012);
		System.out.println(ss);
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
	}
}

class Node_for_Stack{
	int val;
	Node_for_Stack next;
	Node_for_Stack(int val, Node_for_Stack next){
		this.val=val;
		this.next=next;
	}
}

class stack{
	private Node_for_Stack head;
	
	
	void push(int val){	
		if(head==null) {
			head=new Node_for_Stack(val,null);
			return;
		}
		Node_for_Stack temp = new Node_for_Stack(val,head);
		head =temp;
	}
	
	int pop(){
		if(head == null) {
			return -1;
		}
		int val = head.val;
		head=head.next;
		return val;
	}
	
	boolean isempty() {
		return head==null;
	}
	
	int top() {
		if(head==null) {
			return -1;
		}
		int val = head.val;
		return val;
	}
}