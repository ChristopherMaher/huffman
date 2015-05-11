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
	public static PriorityQeueCompareCanonical pqcCanonical=new PriorityQeueCompareCanonical();
	static PriorityQueue<TreeNode> pqCanonical=new PriorityQueue<TreeNode>(character_set_Nodes.size()+1,pqcCanonical);

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
			
		TreeNode right=pq.poll();
		
		TreeNode root = new TreeNode(left.frequency+right.frequency,left.characters+","+right.characters);
		right.parent = root;
		left.parent = root;
		root.left = left;
		root.right = right;
		pq.add(root);
		//System.out.println(root.characters+":"+root.frequency);
		//System.out.println(root.characters);
		}
	

			//}

		}
		setDepth (pq.peek());
		traverse(pq.peek());
		canonicalMapMaker();

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
			character_set_Nodes.add(temp2);
			
			
			}

		}
		
		
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
		
		 System.out.println(root.characters+" :"+root.frequency);
	    
	   
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
	
	/**
	 * makes a canonical HashMap
	 * was supposed to allow for future encoding.
	 * here is the rough,rough start
	 * 
	 */
	
	public static void canonicalMapMaker(){
		
		for(TreeNode the_node: character_set_Nodes){
			pqCanonical.add(the_node);
		
			
		}
	    String s = "0000";
	    for (int i = 0; i < 3; i++) {
	        System.out.println(s);
	      //  System.out.println("\t" + Integer.valueOf(s, 2));
	        s = Integer.toBinaryString(Integer.valueOf(s, 2) + 1);
	        while(s.length() != 4){
	        	s = "0"+s;
	        }
	        
	    }

		
		
	
	}
	
		
}
