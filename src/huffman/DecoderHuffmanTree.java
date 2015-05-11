package huffman;

import java.util.PriorityQueue;

public class DecoderHuffmanTree {
	private TreeNode root;
	private int character;
	private int frequency;
	public static PriorityQeueCompare pqc=new PriorityQeueCompare();
	static PriorityQueue<TreeNode> pqTree=new PriorityQueue<TreeNode>(Decode.number_of_symbols,pqc);
	public DecoderHuffmanTree(){
 
}
/**
 * builds a canonical huffman tree to allow for 
 * decoding.
 */
public static void decodebuildtree(){
TreeNode root = new TreeNode();
while(!pqTree.isEmpty()){
	
TreeNode temp=pqTree.poll();
for(int x=0;x<temp.canonical_code.length();x++){
	
if(temp.canonical_code.charAt(temp.canonical_code.length()-1)=='0'){
			
			root.left=temp;
			temp.parent = root;
			break;
		}
if(temp.canonical_code.charAt(temp.canonical_code.length()-1)=='1'){
			
			root.right=temp;
			temp.parent = root;
			break;
		}
if(temp.canonical_code.charAt(x)=='0'){
	

		if(root.left==null){
			TreeNode temp2 = new TreeNode();
			root.left = temp2;
			temp2.parent = root;
			root = temp2;
			
		}else if(root.left!=null){
			root = root.left;
		}
}else if(temp.canonical_code.charAt(x)=='1'){ 
		if(root.right!=null){
			root = root.right;
		}else if(root.right==null){
			TreeNode temp2 = new TreeNode();
			root.right = temp2;
			temp2.parent=root;
			root = temp2;
		}
		}
	}
}
}

/**
 * 
 * @param read_byte
 * was going to read and compare the mask byte to the read in byte. Telling which way to go down the tree
 */
public static void readBytes(Byte read_byte){
	int mask = 0x80;
	int value = (read_byte & mask);
	if(value==1){
		
	}else{
		
	}
}



}
