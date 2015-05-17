package huffman;

public class TreeNode {
public int frequency;
public String characters;
TreeNode left;    
TreeNode right;   
TreeNode parent;
public int depth;
public String canonical_code;
Boolean leaf;
/**
 * 
 * @param frequency
 * @param characters
 */
public TreeNode(int frequency,String characters){
	this.frequency=frequency;
	this.characters= characters;
	left = null;
	right = null;
	leaf=false;
	
	}
/**
 * 
 * @param characters
 * @param depth
 */
public TreeNode(String characters,int depth){
	this.characters = characters;
	this.depth = depth;
	leaf=false;

}
/**
 * 
 */
public TreeNode(){
	leaf=false;

	//this.characters = characters;
	//this.depth = depth;
}
}
