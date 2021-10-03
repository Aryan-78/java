import java.util.TreeMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Set;
//import javafx.util.Pair;

public class _11_Inside_PQ_a_HasHMap_with_respect_to_Value {

	public static void main(String[] args) {
		TreeMap<Integer,Integer> hm = new TreeMap<Integer,Integer>();
		hm.put(1, 3);
		hm.put(2, 5);
		hm.put(3, 2);
		hm.put(4, 8);
		System.out.println(hm.firstKey());
		System.out.println(hm.entrySet());
		
		//Pair<Integer,Integer> aa =  hm.firstEntry();
		
		System.out.println(hm.values());
		
		PriorityQueue<Map.Entry<Integer, Integer>> PQ = new PriorityQueue<>((o1,o2)->o1.getValue()-o2.getValue());
		// Or o1.getKey()-o2.getKey();
		
		hm.entrySet().forEach((e)->PQ.add(e));
		Set<Integer> a = hm.keySet();
	
		/* 
		 * Here We can use Hashmap Inside The PriorityQueue
		 * Map.Entry< , > is used to justify the Map Object in Place
		 * (o1,o2)->o1.getValue()-o2.getValue()
		 * 
		 * Here o2 is always the first element that we have initially added 
		 * i.e. o2 = (1,3) for all cases.
		 * 
		 * Here It act as a comparator where o1.value - o2.value
		 * if(o2>o1)  return -1  [  act as red-Black Tree  ]
		 * if(o2<o1)  return +1
		 * [   Watch https://www.youtube.com/watch?v=y5S7Uq7hUVE   ]  
		 * 
		 * hm.entryset is for creating it as a whole and send it to PQ
		 * 
		 * if we just do hm.forEach()
		 * 
		 * then we have to do bifergation between K and V <K,V>
		 * 
		 * */
		System.out.println(PQ);
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		System.out.println(PQ.poll());
		
	}
}
