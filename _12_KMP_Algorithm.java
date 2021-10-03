/*
 * 
 * One of the most complicated algorithm 
 * Must watch 
 * 
 * https://www.youtube.com/watch?v=f9Rb0kd_Gng
 * https://www.youtube.com/watch?v=bDy5RCGu5yk
 * 
 * */

import java.util.Scanner;
public class _12_KMP_Algorithm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter The Pattern :");
		String a =sc.nextLine();
		System.out.println("Enter The text :");
		String b =sc.nextLine();
		int[] ans = LPS(a);
		sc.close();
		for(int i:ans) {
			System.out.print(i+" ");
		}
		System.out.println();
		KMP(b,a);
	}
	static int[] LPS(String a ){ 
		int n = a.length();
		int[] LPS = new int[n];
		LPS[0]=0;
		
		int runningLEN = 0;
		int index = 1;
		
		while(index<n) {
			if(a.charAt(index)==a.charAt(runningLEN)) {
				runningLEN++;
				LPS[index]=runningLEN;
				index++;
			}
			else {
				if(runningLEN!=0) {
					runningLEN = LPS[runningLEN-1];
				}else {
					LPS[index]=0;
					index++;
				}
			}
		}
		
		return LPS;
	}
	
	static void KMP(String text, String pattern) {
		int []lps = LPS(pattern);

        int n = text.length();
        int m = pattern.length();

        int i = 0, j = 0;

        while (i < n){
            if(text.charAt(i) == pattern.charAt(j)){
                j++;
                i++;
            }
            if(j == m){
                System.out.println("Found pattern at index: " + (i-j));
                j = lps[j-1];
            }
            else if(i<n && pattern.charAt(j) != text.charAt(i)){
                if(j != 0) { 
                	j = lps[j-1];
                }
                else{
                	i++;	
                }
            }
        }
        System.out.println("BREAK");
    }
}
