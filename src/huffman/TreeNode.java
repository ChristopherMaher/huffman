package huffman;

public class TreeNode {
public int frequency;
public String characters;
TreeNode left;    
TreeNode right;   
TreeNode parent;
public int depth;
public TreeNode(int frequency,String characters){
	this.frequency=frequency;
	this.characters= characters;
	left = null;
	right = null;
	
	}
public TreeNode(String characters,int depth){
	this.characters = characters;
	this.depth = depth;
}

}
