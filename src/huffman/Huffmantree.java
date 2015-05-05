package huffman;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Huffmantree {
static String file;
static Map<Character,Integer> frequencyHash = new HashMap<Character,Integer>();

static Set<Character> character_set = new HashSet<Character>();

public Huffmantree(String file){
	this.file = file;
	
}


public static void countFreq(){
//Map<Character,Integer> frequencyHash = new HashMap<Character,Integer>();
int cont = 0;
int counters =0;
for(int i=0; i<file.length(); i++) {
  if(character_set.add(file.charAt(i))==true){
	  frequencyHash.put(file.charAt(i), 0);
  }
		int temp=frequencyHash.get(file.charAt(i));
		temp++;
		frequencyHash.remove(file.charAt(i));
		frequencyHash.put(file.charAt(i),temp);
		cont++;
}	
System.out.print(frequencyHash);
	//return frequencyHash;
}
public String toString(){
	return "this is hash";
}
}
