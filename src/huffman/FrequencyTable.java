package huffman;


import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import sun.misc.Sort;

public class FrequencyTable {
//static String file;
static Map<Integer,Integer> frequencyHash = new HashMap<Integer,Integer>();

static Set<Integer> character_set = new HashSet<Integer>();
//static ArrayDeque<TreeNode> list_of_nodes =new ArrayDeque<TreeNode>();
public FrequencyTable(){
	
//	this.file = file;
	
}


public static Map<Integer, Integer>  countFreq(int file){
int cont = 0;
int counters =0;
//for(int i=0; i<file.length(); i++) {
  if(character_set.add(file)==true){
	  frequencyHash.put(file, 0);
   		}
  int temp=frequencyHash.get(file);
  temp++;
  frequencyHash.remove(file);
  frequencyHash.put(file,temp);
   cont++;
 
//System.out.print(frequencyHash);
return frequencyHash;
}
/*public static void create_initial_node_array(){
    
	Collection c = frequencyHash.values();
	Integer[] values = (Integer[])(c.toArray(new Integer[c.size()]));
	//Collection keys = frequencyHash.k
	Integer[] keys = (Integer[])(frequencyHash.keySet().toArray(new Integer[c.size()]));
	for(int x = 0; x<keys.length; x++){
		//TreeNode temp2 =new TreeNode(frequencyHash.get(keys[x]),keys[x].toString());
		list_of_nodes.add(new TreeNode(frequencyHash.get(keys[x]),keys[x].toString()));
	}
	
}*/
/*
public static void update_node_array(TreeNode left, TreeNode right){
	int combined_frequency=left.frequency + right.frequency;
	String combined_characters = left.characters +right.characters;
	TreeNode temp2 =new TreeNode(combined_frequency,combined_characters);
	temp2.left = left;
	temp2.right = right;
	list_of_nodes.add(temp2);
	}
	*/
}