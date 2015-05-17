package huffman;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class DecoderHuffmanTree {
	static TreeNode head;
	private TreeNode root;
	private int character;
	private int frequency;
	public static PriorityQeueCompare pqc=new PriorityQeueCompare();
	static PriorityQueue<TreeNode> pqTree=new PriorityQueue<TreeNode>(Decode.number_of_symbols,pqc);
	static ArrayDeque<TreeNode> stacking = new ArrayDeque<TreeNode>();
	public DecoderHuffmanTree(){
 
}
/**
 * builds a canonical huffman tree to allow for 
 * decoding.
 */
public static TreeNode decodebuildtree(){
TreeNode current = new TreeNode();
TreeNode head = current;
while(!pqTree.isEmpty()){
TreeNode temp=pqTree.poll();
for(int x=0;x<temp.canonical_code.length();x++){
	
if(temp.canonical_code.length()-1 == x)	
if(temp.canonical_code.charAt(temp.canonical_code.length()-1)=='0'){
			current.left=temp;
			temp.parent = current;
			current = head;
			break;
		}
if(temp.canonical_code.length()-1 == x)	
if(temp.canonical_code.charAt(temp.canonical_code.length()-1)=='1'){
			
			current.right=temp;
			temp.parent = current;
			current = head;
			break;
		}
if(temp.canonical_code.charAt(x)=='0'){
	

		if(current.left==null){
			TreeNode temp2 = new TreeNode();
			current.left = temp2;
			temp2.parent = current;
			current = temp2;
			
		}else if(current.left!=null){
			current = current.left;
		}
}else if(temp.canonical_code.charAt(x)=='1'){ 
		if(current.right!=null){
			current = current.right;
		}else if(current.right==null){
			TreeNode temp2 = new TreeNode();
			current.right = temp2;
			temp2.parent=current;
			current = temp2;
		}
		}
	}
}

return head;
}


}
