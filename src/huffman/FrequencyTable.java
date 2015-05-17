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
static Map<Integer,Integer> frequencyHash = new HashMap<Integer,Integer>();

static Set<Integer> character_set = new HashSet<Integer>();
public FrequencyTable(){
	
	
}

/**
 * 
 * @param file
 * @return the frequencyHash
 * 
 */
public static Map<Integer, Integer>  countFreq(int file){
int cont = 0;
int counters =0;
  if(character_set.add(file)==true){
	  frequencyHash.put(file, 0);
   		}
  if(file !=0){
  int temp=frequencyHash.get(file);
  temp++;
  frequencyHash.remove(file);
  frequencyHash.put(file,temp);
   cont++;
   		
  }
return frequencyHash;
}

}