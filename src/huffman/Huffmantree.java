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

	//static int depth = 0;
	//private TreeNode current_lowest_Node= 0;
	public HuffmanTree( ){
	
	}
	//public static TreeNode get_lowest_Node(){
		//TreeNode temp1 = null;
		
	//	if(list_of_nodes.peek()!=null){
		//	if(pq.peek() != null)
	//	System.out.print(pq.peek().characters+"dd");
		
	//	return pq.poll();
		//}
	//	return root;
		 
	//	System.out.print(root.characters);


		/*
				if(pq.peek().frequency<list_of_nodes.peek().frequency){
			return temp1=pq.poll(); 
		}else
			 
		
		temp1=list_of_nodes.pollFirst();
			return temp1;
		
		//for(TreeNode s:pq){ 
		//}
		*/
		//fix this shit up to allow for if only list_nodes remains and all possibilities lots of else if needed
		//if only list_nodes remain 
			//System.out.println(s);
	//	}

		
	//	list_of_nodes
		//int c = list_of_nodes.iterator().next().frequency;
		
		//Integer[] values = (Integer[])(list_of_nodes.toArray(new Integer[list_of_nodes.size()]));
	//	int
		/*
		   for(Iterator<TreeNode> itr = list_of_nodes.iterator();itr.hasNext();)  {
			   TreeNode temp1= itr.next();
			   	if(compare(list_of_nodes.peek(),temp1)==1){
			   		list_of_nodes.remove(temp1);
			   		list_of_nodes.addFirst(temp1);
			   		//System.out.println(itr.next());
			   	}
			*/   	
		  // }
	/*	while(list_of_nodes.iterator().hasNext()){
		  int temp1=list_of_nodes.iterator().next().frequency;
		  
		}*/
	
//	}
	public static void buildtree(){
		//System.out.println(pq.peek().characters);
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
		//System.out.println(pq.peek().characters);
	//	System.out.pprint(root.characters);
		setDepth (pq.peek());
		//System.out.print(pq.peek().left.characters);
		traverse(pq.peek());
		canonicalMapMaker();
	//	System.out.print(canonicalHash);
		//System.out.print(pq.peek().characters);

		//System.out.print(FrequencyTable.character_set);
		//}
	
		//pq.peek()
	//	System.out.print(pq.peek().characters);
		//recursively build tree using if statement and peek on both list_of nodes and pq
		//Treenode lchild = FrequencyTable.frequencyHash.
		//root = new Node();
		//traverse(pq.peek());
		//System.out.print(pq.peek().left.characters);
		//traverse(pq.peek());
	
	
	//public boolean lookup(int data) { 
		//return(lookup(root, data)); 
	//} 

	/*
	public TreeNode update_remaining_nodes(TreeNode left, TreeNode right){
		
		
		/*
		int combined_frequency=left.frequency + right.frequency;
		String combined_characters = left.characters +right.characters;
		TreeNode temp2 =new TreeNode(combined_frequency,combined_characters);
		temp2.left = left;
		temp2.right = right;
		list_of_nodes.add(temp2);
		list_of_nodes.remove(left);
		list_of_nodes.remove(right);
		return temp2;
*/
	//	return null;
	}
//*/
	public static void create_initial_node_array(){
		
		FrequencyTable.frequencyHash.put(0,1);
		//for()
		 Collection c = FrequencyTable.frequencyHash.values();
		Integer[] values = (Integer[])(c.toArray(new Integer[c.size()]));
		//Collection keys = frequencyHash.k
		Integer[] keys = (Integer[])(FrequencyTable.frequencyHash.keySet().toArray(new Integer[c.size()]));
		for(int x = 0; x<keys.length; x++){
			TreeNode temp2 =new TreeNode(FrequencyTable.frequencyHash.get(keys[x]),keys[x].toString());
		///	System.out.print(temp2.frequency);
			if(temp2.frequency != 0){
			pq.add(temp2);
			character_set_Nodes.add(temp2);
			
			//int ascii_value = Integer.parseInt(temp2.characters);
			  
			// String =temp2.characters;
			//pq.add(new TreeNode(FrequencyTable.frequencyHash.get(keys[x]),keys[x].toString()));
		//	System.out.println(temp2.characters+":"+temp2.frequency);
			}

		}
		
		
	}

	public static void traverse (TreeNode root){ // Each child of a tree is a root of its subtree.
	 //  depth++;
		if (root.left != null){
	       // depth++;
		 //     depth++;
	//		 System.out.print(depth);	

			traverse (root.left);
			//System.out.print(root.characters);
	      //  System.out.print(depth);
	        
	    }
		// System.out.print(depth);	
		
		 System.out.println(root.characters+" :"+root.frequency);
		// System.out.print(b);
		//depth--;
	    
	   
	    if (root.right != null){
	      //  depth++;

	    	traverse (root.right);

	       // System.out.print(depth);
			//System.out.print(root.characters);

	    }
	}
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
	public static void canonicalMapMaker(){
		
		for(TreeNode the_node: character_set_Nodes){
			pqCanonical.add(the_node);
			//int ascii_value = Integer.parseInt(the_node.characters);
			//canonicalHash.put(ascii_value,the_node.depth);
			
		//	the_node.characters;
			//the_node.depth;
			
		}
		//incrementing
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
