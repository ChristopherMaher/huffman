package huffman;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class HuffmanTree{
	private TreeNode root;
	private int character;
	private int frequency;
	static ArrayDeque<TreeNode> list_of_nodes =new ArrayDeque<TreeNode>();
	public static PriorityQeueCompare pqc=new PriorityQeueCompare();
	static PriorityQueue<TreeNode> pq=new PriorityQueue<TreeNode>(FrequencyTable.character_set.size()+1,pqc);
	
	static Map<Integer,Integer> canonicalHash = new HashMap<Integer,Integer>();
	static Set<TreeNode> character_set_Nodes = new HashSet<TreeNode>();

	public HuffmanTree( ){
	
	}
/**
 * builds the huffman tree
 */
	public static void buildtree(){
		while(pq.size()>1){
		//if (pq.peek().characters != null){
			if(!pq.isEmpty()){
		TreeNode left=pq.poll();
	//	System.out.println(left.characters+"LEFT");
		TreeNode right=pq.poll();
		//System.out.println(right.characters);
		TreeNode current_node = new TreeNode(left.frequency+right.frequency,left.characters+","+right.characters);
	//	System.out.println(root.characters+":"+root.frequency);

		right.parent = current_node;
		left.parent = current_node;
		current_node.left = left;
		current_node.right = right;
		pq.add(current_node);
		//System.out.println(root.characters);
		}
	

			//}

		}
	
		System.out.print("SDF");
		TreeNode test1=(pq.peek());
		setDepth (pq.peek());
		traverse(pq.peek());
		EncodeCanonicalHuffman.canonicalMapMaker();

	}
	/**
	 * creates first stack of TreeNodes before combining
	 */
	public static void create_initial_node_array(){
		
		FrequencyTable.frequencyHash.put(0,1);
		 Collection c = FrequencyTable.frequencyHash.values();
		Integer[] values = (Integer[])(c.toArray(new Integer[c.size()]));
		Integer[] keys = (Integer[])(FrequencyTable.frequencyHash.keySet().toArray(new Integer[c.size()]));
		for(int x = 0; x<keys.length; x++){
			TreeNode temp2 =new TreeNode(FrequencyTable.frequencyHash.get(keys[x]),keys[x].toString());
			if(temp2.frequency != 0){
			pq.add(temp2);
			//EncodeCanonicalHuffman.pqCanonical.add(temp2);

			EncodeCanonicalHuffman.tempset.add(temp2);
			//System.out.println(EncodeCanonicalHuffman.pqCanonical);
			character_set_Nodes.add(temp2);
			
			
			}

		}
		//System.out.print(FrequencyTable.frequencyHash);
		
	}
/**
 * @param TreeNode
 * traverses the huffman tree, while making the new combined nodes. 
 * It than adds said nodes to the stack.
 */
	public static void traverse (TreeNode root){ // Each child of a tree is a root of its subtree.
		if (root.left != null){
	  	

			traverse (root.left);
			
	        
	    }
		
		// System.out.println(root.characters+" :"+root.frequency);
	    
	   
	    if (root.right != null){

	    	traverse (root.right);


	    }
	}
	/**
	 * 
	 * @param head
	 * traverses the tree setting the depth of each Treenode.
	 */
	public static void setDepth (TreeNode head)
	{
	    Stack<TreeNode> s = new Stack<TreeNode>();
	    
	    head.depth = 0;
	    s.push(head);

	    while(s.size() > 0)
	    {
	        TreeNode temp = s.pop();

	        if (temp != null)
	        {
	            if (temp.left != null)
	            {
	                temp.left.depth = temp.depth + 1;
	                s.push(temp.left);
	            }

	            if (temp.right != null)
	            {
	                temp.right.depth = temp.depth + 1;
	                s.push(temp.right);
	            }
	        }

	    }

	}
	
	
	
	
}
