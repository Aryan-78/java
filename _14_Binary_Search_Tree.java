// https://www.youtube.com/watch?v=TsqG-IGfZic
import java.util.Arrays;
import java.util.Collections;

public class _14_Binary_Search_Tree {

	public static void main(String[] args) {
		BST a = new BST();
		Integer[]aaa = {1,2,1,5,3};
		Arrays.sort(aaa, Collections.reverseOrder());
		for(int i=0;i<aaa.length;i++) {
			System.out.print(aaa[i]+" ");
		}
		a.insert(50);
		a.insert(30);
		a.insert(70);
		a.insert(60);
		a.insert(80);
		System.out.println(a.root.val);
		a.inorder();
		a.delete(70);
		a.inorder();
	}

}
class BST{
	class Node{
		int val;
		Node left,right;
		Node(int val){
			this.val = val;
			left = right = null;
		}
	}
	
	Node root;
	
	public BST(){
		root=null;
	}

	/*======================================================================================*/
	// Insert Node
	
	void insert(int a ){
		root = insertion(a,root);
	}
	
	Node insertion(int val, Node root) {
		if(root==null) {
			Node n = new Node(val);
			return n;
		}
		if(val<root.val) {
			root.left = insertion (val,root.left);
		}
		else if(val>root.val) {
			root.right = insertion(val,root.right);
		}
		return root;
	}
	
	/*======================================================================================*/
	// Inorder
	
	void inorder() {
		inOrderReal(root);
		System.out.println(" ");
	}
	
	void inOrderReal(Node root) {
		if(root==null) return;
		inOrderReal(root.left);
		System.out.print(root.val+" ");
		inOrderReal(root.right);
	}
	
	/*======================================================================================*/
	// Delete Node
	
	void delete(int a ) {
		root = deleteReal(a,root);
	}
	
	Node deleteReal(int a , Node root){
		if(root==null) return null;
	
		if(a>root.val) {
			root.right=deleteReal(a ,root.right);
		}
		else if(a<root.val) {
			root.left=deleteReal(a ,root.left); 
		}
		
		else{
			if(root.left==null) {
				return root.right;
			}
			if(root.right==null) {
				return root.left;
			}else {
				root.val = minval(root.right);
				root.right = deleteReal(root.val,root.right);
			}
		}
		return root;
	}
	
	int minval(Node root) {
		int min = root.val;
		while(root!=null) {
			min=root.val;
			root=root.left;
		}
		return min;
	}
}