//import java.util.ArrayList;
import java.util.Scanner;
public class _2_sorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		ArrayList<Integer> as = new ArrayList<>(5);
//		for(int i = 0;i<10;i++) {
//			as.add(i);
//		}
//		for(int i = 0;i<10;i++) {
//			System.out.println(as.get(i));
//		}
		System.out.println("Enter the length of the array :");
		int a=sc.nextInt();
		System.out.println("Enter the elements of the array");
		int b[] = new int[a]; 
		for(int i=0;i<a;i++) {
			int j = sc.nextInt();
			b[i]=j;
		}
		boolean tj =true;
		while(tj) {
			sort so = new sort(b);
			System.out.println("Enter the type of sorting algorithm you want to choose :\n1)Bubble Sorting\n2)Bubble Sorting With Optimization\n3)Selection Sorting\n4)InSertion Sorting\n5)Merge Sorting\n6)Quick Sort\n7)To exit");
			int c = sc.nextInt();
			switch(c) {
				case 1:
					System.out.println("You Choose Bubble Sorting: ");
					System.out.print("Your initial Array :");
					so.print();
					so.bubblesort();
					System.out.print("Your Sorted Array :");
					so.print();
					break;
				case 2:
					System.out.println("You Choose Bubble Sorting with optimization: ");
					System.out.print("Your initial Array :");
					so.print();
					so.bubblesort_optimize();
					System.out.print("Your Sorted Array :");
					so.print();
					break;
				case 3:
					System.out.println("You Choose Selection Sorting: ");
					System.out.print("Your initial Array :");
					so.print();
					so.Selectionsort();
					System.out.print("Your Sorted Array :");
					so.print();
					break;
				case 4:
					System.out.println("You Choose Insertion Sorting: ");
					System.out.print("Your initial Array :");
					so.print();
					so.insertionSort();
					System.out.print("Your Sorted Array :");
					so.print();
					break;
				case 5:
					System.out.println("You Choose Merge Sorting: ");
					System.out.print("Your initial Array :");
					so.print();
					so.mergeSort(0, a-1);
					System.out.print("Your Sorted Array :");
					so.print();
					break;
				case 6:
					System.out.println("You Choose Quick Sorting: ");
					System.out.print("Your initial Array :");
					so.print();
					so.quickSort(0, a-1);
					System.out.print("Your Sorted Array :");
					so.print();
					break;
				case 7:
					System.out.println("Thanks For Exploring");
					tj=false;
					break;
				default:
					System.out.println("PLease enter a valid Value");
			}
		}
		sc.close();
		
		
	}

}


class sort{
	//===========================================================================================//
	// Constructor
	
	int arr[];
	sort(int newarr[]){
		arr = newarr.clone();
	}
	
	//===========================================================================================//
	// Print an array 
	
	void print() {
		for(int i = 0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	//===========================================================================================//
	// Bubblesorting and its optimization
	
	void bubblesort(){
		int N = arr.length;
		for(int i = 1;i<=N-1;i++) {
			for(int j =0;j<N-i;j++) {
				if(arr[j]<arr[j+1]) {
					swap(j,j+1);
				}
			}
		}
	}
	
	void bubblesort_optimize() {
		int N= arr.length;
		for(int i=1;i<=N-1;i++) {
			boolean x = false;
			for(int j=0;j<N-i;j++) {
				if(arr[j]<arr[j+1]) {
					swap(j,j+1);
					x=true;
				}
			}
			if(!x) break;
		}
	}
	
	//===========================================================================================//
	// Selection Sorting
	
	void Selectionsort() {
		int N = arr.length;
		for(int i=0;i<N-1;i++) {
			int maxIndex=i;
			for(int j = i+1;j<=N-1;j++) {
				if(arr[maxIndex]<arr[j]) {
					maxIndex=j;
				}
			}
			swap(maxIndex,i);
		}
	}
	
	// Swap
	
	void swap(int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	
	//===========================================================================================//
	// Insertion Sorting
	
	void insertionSort() {
		int N = arr.length;
		for(int i = 1;i<N;i++) {
			int current = arr[i];
			int j = i-1;
			while(j>=0 && arr[j]<current){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=current;
		}
	}
	
	//===========================================================================================//
	// Merge Sorting
	// Similar to Sorting There is a Question for Inversion Count in Assignment 
	// Check IT
	
	void merge(int ls,int le,int rs,int re) {
		int array[] = new int[re-ls+1];
		int pointer = 0;
		int st = ls;
		while(rs<=re && ls<=le) {
			if(arr[ls]<=arr[rs]) {
				array[pointer++]=arr[ls++];
			}else {
				array[pointer++]=arr[rs++];
			}
		}
		while(ls<=le) {
			array[pointer++]=arr[ls++];
		}
		while(rs<=re) {
			array[pointer++]=arr[rs++];
		}
		
		for(int i=0;i<pointer;i++) {
			arr[i+st]=array[i];
		}

	}
	
	void mergeSort(int start,int end) {
		if(start==end) {
			return;
		}
		
		int mid=(start+end)/2;
		
		mergeSort(start, mid);
		mergeSort(mid+1,end);
		merge(start,mid,mid+1,end);
	
	}
	
	//===========================================================================================//
	// Quick Sorting
	void quickSort(int start, int end) {
		if(start>=end) {
			return;
		}
		
		int pivot = findinsertionvalue(start,end);
		quickSort(start,pivot-1);
		quickSort(pivot+1,end);
	}
	
	int findinsertionvalue(int start,int end) {
		int counter = start-1;
		int pivot = arr[end];
		for(int i=start;i<=end;i++) {
			if(arr[i]>=pivot){
				counter++;
				int temp = arr[i];
				arr[i]=arr[counter];
				arr[counter]=temp;
			}
		}
		return counter;
	}
}