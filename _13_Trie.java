//https://www.youtube.com/watch?v=SxYqF08Rneg

public class _13_Trie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Trie_Node{
	int cnt;
	Trie_Node[] child;  // This will create a set of trieNode
	Trie_Node(){
		cnt=0;
		child = new Trie_Node[26];
		for(int i=0;i<26;i++) child[i]=null;
	}
	void visit(){
		cnt+=1;
	}
}

class Trie_Methods{
	Trie_Node root;
	
	void insert(String s) {
		Trie_Node curr = root;
		for(int i = 0;i<26;i++) {
			char a = s.charAt(i);
			int index = a - 'a';
			if(curr.child[index]==null) {
				curr.child[index] = new Trie_Node();
			}
			curr=curr.child[index];
			curr.visit();
		}
	}
	
	int findNoOfStringsWithGivenPrefix(String S) {
		
		Trie_Node curr = root;
		
		for(int i=0;i<S.length();i++) {
			char a = S.charAt(i);
			int index = a - 'a';
			if(curr.child[index]==null) {
				return -1;
			}
			curr=curr.child[index];
		}
		return curr.cnt;
	}
}
