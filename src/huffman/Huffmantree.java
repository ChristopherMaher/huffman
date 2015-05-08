package huffman;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class HuffmanTree{
	private TreeNode root;
	private int character;
	private int frequency;
	static ArrayDeque<TreeNode> list_of_nodes =new ArrayDeque<TreeNode>();
	public static PriorityQeueCompare pqc=new PriorityQeueCompare();
	static PriorityQueue<TreeNode> pq=new PriorityQueue<TreeNode>(FrequencyTable.character_set.size()+1,pqc);

	//private TreeNode current_lowest_Node= 0;
	public HuffmanTree( ){
	
	}
	public static TreeNode get_lowest_Node(){
		TreeNode temp1 = null;
		if(list_of_nodes.peek()!=null){
		if(pq.peek().frequency<list_of_nodes.peek().frequency){
			return temp1=pq.poll(); 
		}else
			 
		
		temp1=list_of_nodes.pollFirst();
			return temp1;
		
		//for(TreeNode s:pq){ 
		}
		return pq.poll();
		
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
	
	}
	public static void buildtree(){
		TreeNode left=get_lowest_Node();
		TreeNode right=get_lowest_Node();
		TreeNode root = new TreeNode(left.frequency+right.frequency,left.characters+"D"+right.characters);
		right.parent = root;
		left.parent = root;
		list_of_nodes.addFirst(root);
		System.out.print(root.frequency);
		System.out.print(root.characters);

		//Treenode lchild = FrequencyTable.frequencyHash.
		//root = new Node();
		
	}
	
	//public boolean lookup(int data) { 
		//return(lookup(root, data)); 
	//} 

	
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
		return null;
	}
	public static void create_initial_node_array(){
		 FrequencyTable.frequencyHash.put(3,1);
		 Collection c = FrequencyTable.frequencyHash.values();
		Integer[] values = (Integer[])(c.toArray(new Integer[c.size()]));
		//Collection keys = frequencyHash.k
		Integer[] keys = (Integer[])(FrequencyTable.frequencyHash.keySet().toArray(new Integer[c.size()]));
		for(int x = 0; x<keys.length; x++){
			//TreeNode temp2 =new TreeNode(frequencyHash.get(keys[x]),keys[x].toString());
			pq.add(new TreeNode(FrequencyTable.frequencyHash.get(keys[x]),keys[x].toString()));
		}
		
		
	}
	
}
