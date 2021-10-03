import java.util.ArrayList;
import java.util.PriorityQueue;
public class _10_Heap {

	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Heap_or_PrimaryQueueImp tr = new Heap_or_PrimaryQueueImp();
		tr.insert(10);
		System.out.println(tr.peek());
		tr.insert(11);
		System.out.println(tr.peek());
		tr.insert(7);
		System.out.println(tr.peek());
		tr.insert(56);
		System.out.println(tr.peek());
		tr.insert(57);
		System.out.println(tr.peek());
		System.out.println("=================================");
		System.out.println(tr.poll());
		System.out.println(tr.peek());
		System.out.println("=================================");
		System.out.println(tr.poll());
		System.out.println(tr.peek());
		System.out.println("=================================");
		System.out.println(tr.poll());
		System.out.println(tr.peek());
		System.out.println("=================================");
		System.out.println(tr.poll());
		System.out.println(tr.peek());
	}

}

class Heap_or_PrimaryQueueImp{
	ArrayList<Integer> heap;
	int n;
	Heap_or_PrimaryQueueImp(){
		heap = new ArrayList<>();
		n=0;
	}
	
	void insert(int val) {
		heap.add(val);
		int pointer = n;
		n++;
		while(pointer>0){
			int parent = (pointer-1)/2;
			if(heap.get(pointer)>heap.get(parent)) {
				heap.set(pointer, heap.get(parent));
				heap.set(parent, val);
				pointer = parent;
			}else {
				break;
			}
		}
	}
	
	int poll(){
		int val = heap.get(0);
		n--;
		heap.set(0, heap.get(n));
		heap.set(n, null);
		int pointer = 0;
		while(pointer<n) {
			int lchild = 0,rchild = 0;
			if(pointer*2+1<n) {
				lchild = heap.get(pointer*2+1);
			}
			if(pointer*2+2<n) {
				rchild = heap.get(pointer*2+2);
			}
			if(lchild>heap.get(pointer) && lchild>rchild) {
				swap(pointer,pointer*2+1);
				pointer = pointer*2+1;
			}else if(rchild>heap.get(pointer) && rchild>lchild) {
				swap(pointer,pointer*2+2);
				pointer = pointer*2+2;
			}else {
				break;
			}
		}
		return val;
	}
	
	int peek() {
		int val = heap.get(0);
		return val;
	}
	
	void swap(int a, int b) {
		int x = heap.get(a);
		heap.set(a,heap.get(b));
		heap.set(b, x);
	}
}