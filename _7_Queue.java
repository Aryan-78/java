import java.util.Queue;
import java.util.LinkedList;
import java.util.Deque;
public class _7_Queue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		QueImplementation a= new QueImplementation();
//		a.push(111);
//		a.push(221);
//		a.push(321);
//		System.out.println(a.no_of_char());
//		System.out.println(a.pop());
//		System.out.println(a.no_of_char());
//		System.out.println(a.pop());
//		System.out.println(a.no_of_char());
//		System.out.println(a.pop());
//		System.out.println(a.no_of_char());
		/*
		 * Here Queue is an interface so we implemented the methods of LinkedList on queue
		 * 
		 * i.e. deque Implemented Queue;
		 * and LinkedList Implement deque
		 * 
		 * and but using Queue<Integer> que = new LinkedList<>(); we only uses Queue methods.
		 * 
		*/
		
		Queue<Integer> que = new LinkedList<>();
		que.add(10);
		que.add(20);
		que.add(30);
		System.out.println(que.poll());
		System.out.println(que.poll());
		System.out.println(que.poll());
		System.out.println(que.poll());
	
		/*
		 * Here Deque is an interface so we implemented the methods of LinkedList on deque
		 * 
		 * i.e. LinkedList Implement deque
		 * 
		 * and but using Queue<Integer> que = new LinkedList<>(); we only uses Queue methods.
		 * 
		 * */
		
		Deque<Integer> dq = new LinkedList<>();
		System.out.println(dq);
	}

}
class QueueNode{
	int val;
	QueueNode next;
	QueueNode(int val, QueueNode next){
		this.val = val;
		this.next = next;
	}
}

class QueImplementation{
	QueueNode head,tail;
	
	QueImplementation(){
		head=tail=null;
	}
	
	int no_of_char() {
		if(head==null) return -11;
		QueueNode temp=head;
		int c =0;
		while(temp!=null) {
			temp=temp.next;
			c+=1;
		}
		return c;
	}
	
	void push(int val){
		//add element at the tail
		if(head==null) {
			head=new QueueNode(val,null);
			tail=head;
			return;
		}
		QueueNode temp = new QueueNode(val,null); 
		tail.next = temp;
		tail = temp;
	}
	
	int pop() {
		// remove element from the head
		if(head==null) return -1;
		int val = head.val;
		head=head.next;
		if(head==null) tail=null;
		return val;
	}
	
	int top() {
		// view element from the head
		if(head==null) return -1;
		int val = head.val;
		return val;
	}
}
