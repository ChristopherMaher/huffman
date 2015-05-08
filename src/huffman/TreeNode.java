package huffman;

public class TreeNode {
public int frequency;
public String characters;
TreeNode left;    
TreeNode right;   
TreeNode parent;
public TreeNode(int frequency,String characters){
	this.frequency=frequency;
	this.characters= characters;
	left = null;
	right = null;
	}

}
