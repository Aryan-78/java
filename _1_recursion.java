import java.util.Scanner;

public class _1_recursion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the term whose fibonacci No you want: ");
		int a = sc.nextInt();
		System.out.printf("Your answer is: %d \n",fibonacciNo(a));
		System.out.println("Enter the value for n and r respectively for combination: ");
		int b = sc.nextInt();
		int c = sc.nextInt();
		System.out.printf("Your answer is: %d \n",Combination(b,c));
		System.out.println("Choose a no from which you can reach to 1 by dividing by 3 , 2 or subtracting by 1 in minimum steps :");
		int d = sc.nextInt();
		System.out.printf("Your answer is: %d \n",minStepToReachOne(d));
		System.out.println("Choose the no whose factorial you need to find :");
		int e = sc.nextInt();
		System.out.printf("Your answer is: %d \n",factorial(e));
		System.out.println("Find the no if it is a palindrome :");
		String f = sc.next();
		if(palindrome(f)) {
			System.out.printf("Your answer is a palindrome");	
		}else {
			System.out.println("Your answer is not a palindrome");
		}
		sc.close();
	}
	/*===========================================================================================*/ 
	// fibonacci No
	
	private static int fibonacciNo(int a) {
		if(a==0) return 0;
		if(a==1) return 1;
		return fibonacciNo(a-1)+fibonacciNo(a-2);
	}

	//===========================================================================================//
	// Combination
	
	private static int Combination(int n, int r) {
		if(r>n) {
			return 0;
		}
		if(r==0) {
			return 1;
		}if(n==0) {
			return 0;
		}
		return Combination(n-1,r)+Combination(n-1,r-1);
	}
	
	//===========================================================================================//
	//Min Steps
	
	private static int minStepToReachOne(int a) {
		if (a==1) return 0;
		if(a%6==0) {
			return 1+minThree(minStepToReachOne(a/3),minStepToReachOne(a/2),minStepToReachOne(a-1));
		}
		if(a%3==0) {
			return 1+Math.min(minStepToReachOne(a/3), minStepToReachOne(a-1));
		}
		if(a%2==0) {
			return 1+Math.min(minStepToReachOne(a/2), minStepToReachOne(a-1));
		}
		return minStepToReachOne(a-1);
	}
	
	private static int minThree(int a, int b, int c) {
		return Math.min(a,Math.min(b,c));
	}
	
	//===========================================================================================//
	//factorial
	
	private static int factorial(int a) {
		if (a==0) return 1;
		int answer = a*factorial(a-1);
		return answer;
	}

	//===========================================================================================//
	//palindrome
	
	private static boolean palindrome(String a) {
		int firstIndex=0;
		int lastIndex=a.length()-1;
		if(a.length()==1) {
			return true;
		}
		if(a.length()==2) {
			if(a.charAt(firstIndex)==a.charAt(lastIndex)) {
				return true;
			}else{
				return false;
			}
		}
		
		if(a.charAt(firstIndex)==a.charAt(lastIndex)) {
			String j=a.substring(firstIndex+1,a.length()-1);
			return palindrome(j);
		}else {
			return false;
		}
	}
}