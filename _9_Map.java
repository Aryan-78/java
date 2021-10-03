import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.*;
public class _9_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeMap<String, Integer> tm = new TreeMap<>();
		tm.put("D", 10);
		tm.put("C", 23);
		tm.put("E", 10);
		System.out.println(tm);
		
		for(Map.Entry<String, Integer> e:tm.entrySet()) {
			System.out.println("Your Keys is "+e.getKey()+" And your value is "+e.getValue());
		}
		
		tm.forEach((k,v)->System.out.println("YOur key is:"+k+" and value is "+v));
		
		System.out.println(tm.floorEntry("F"));
		System.out.println(tm.descendingKeySet());
		System.out.println(tm.hashCode());
		System.out.println(tm.subMap("C", "D"));
		System.out.println(tm);
		System.out.println("====================");
		System.out.println(tm.ceilingEntry("A"));
		
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A", 101);
		map.put("D", 16701);
		map.put("C", 1);
		map.put("B", 1014);
		System.out.println(map);
	}

}
