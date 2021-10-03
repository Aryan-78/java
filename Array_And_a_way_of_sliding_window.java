import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
public class Array_And_a_way_of_sliding_window {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> ss = new ArrayList<>();
		ss.add(12);
		ss.add(23);
		ss.add(34);
		ss.add(54);
		ss.add(45);
		ss.add(0);
		ss.add(0, 76);
		System.out.println(ss);
		
		/*
		 * There is a way we can use sliding window which is express below. 
		 * */
		
		int k=2;
		Deque<Integer> dq = new LinkedList<>();
		int a = ss.size();
		for(int i=0;i<a;i++) {
			if(i>=k) {
				dq.pollFirst();
			}
			dq.addLast(ss.get(i));
			System.out.println(dq);
		}
	
	}
}
