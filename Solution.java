import java.lang.StringBuilder;

public class Solution {
  public static void main(String args[]){
	  String s = "assdAA";
	  System.out.println(s.concat("kg"));
	  StringBuilder sb1  = new StringBuilder();
	  sb1.append(2);
	  sb1.append(1);
	  sb1.append(1);
	  sb1.append(4);
	  sb1.append(8);
	  sb1.replace(0, 2, "56");
	  System.out.println(sb1.reverse());
	  System.out.println(sb1.subSequence(0, 3));
	  System.out.println(sb1.substring(0, 3));
  }
}