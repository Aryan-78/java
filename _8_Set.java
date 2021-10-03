import java.util.Collections;
import java.util.HashSet;
import java.util.TreeSet;
public class _8_Set {
	public static void main(String[] args) {
		TreeSet<Integer> aa = new TreeSet<>(Collections.reverseOrder());
		aa.add(2);
		aa.add(3);
		aa.add(7);
		aa.add(4);
		aa.remove(aa.first());
		System.out.println(aa);
		
		HashSet<String> ab = new HashSet<>();
		ab.add("2");
		ab.add("3");
		ab.add("3");
		ab.add("7");
		ab.add("4");
		
		System.out.println(ab.hashCode());
		System.out.println(ab);
	}
}
