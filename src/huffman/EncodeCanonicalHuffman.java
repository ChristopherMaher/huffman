package huffman;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class EncodeCanonicalHuffman {
	public EncodeCanonicalHuffman(){
		
	}
	public static PriorityQeueCompareCanonical pqcCanonical=new PriorityQeueCompareCanonical();
	static PriorityQueue<TreeNode> pqCanonical=new PriorityQueue<TreeNode>(HuffmanTree.character_set_Nodes.size()+1,pqcCanonical);
    static Map<Integer,String> canonicalHash = new HashMap<Integer,String>();
    static Set<TreeNode> tempset = new HashSet<TreeNode>();
    
    /**
     * Creates the canonical Huffman Map
     */
	public static void canonicalMapMaker(){
		pqCanonical.addAll(tempset);
		int cononical_code = 0;
		String s_cononical_code = "";
		
		int current_depth=0;
		int previous_depth = 0;
		while(!pqCanonical.isEmpty()){
			TreeNode temp=pqCanonical.poll();
			current_depth =temp.depth;
			if(temp.depth>=previous_depth){
				
				if(Integer.parseInt(temp.characters) == 0){
					s_cononical_code=String.format("%8s", Integer.toBinaryString(cononical_code & 0xFF)).replace(' ', '0');
					s_cononical_code=s_cononical_code.substring(8-current_depth,8);
					canonicalHash.put(Integer.parseInt(temp.characters), s_cononical_code);
					previous_depth = current_depth;
				}else{
					cononical_code=cononical_code+1;
					s_cononical_code=String.format("%8s", Integer.toBinaryString(cononical_code & 0xFF)).replace(' ', '0');

					s_cononical_code=s_cononical_code.substring(8-current_depth,8);
					canonicalHash.put(Integer.parseInt(temp.characters), s_cononical_code);
					previous_depth = current_depth;
					}
			}
				if(current_depth<previous_depth){
					cononical_code=cononical_code+1;
					int mask = 0xFF;
					System.out.println(cononical_code+":"+"THE STUFF");

					cononical_code=(byte)cononical_code>>(previous_depth-current_depth);
					System.out.println(cononical_code+"thecodes");
					s_cononical_code=String.format("%8s", Integer.toBinaryString(cononical_code & 0xFF)).replace(' ', '0');
					System.out.println(s_cononical_code);
					s_cononical_code=s_cononical_code.substring(8-current_depth,8);
					canonicalHash.put(Integer.parseInt(temp.characters), s_cononical_code);
					previous_depth = current_depth;

			}
			
		}
		
}


}
