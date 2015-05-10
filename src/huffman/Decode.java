package huffman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

public class Decode {
	public static PriorityQeueCompareCanonical pqcCanonical=new PriorityQeueCompareCanonical();
	//static PriorityQueue<TreeNode> pqCanonical=new PriorityQueue<TreeNode>(character_set_Nodes.size()+1,pqcCanonical);


	 public static void main(String[] args) throws IOException{
		 //FrequencyTable test = new FrequencyTable();

		InputStream inputstream = new FileInputStream("sample3.huf");
		 int number_of_symbols = inputstream.read();
		 PriorityQueue<TreeNode> pqCanonical=new PriorityQueue<TreeNode>(number_of_symbols,pqcCanonical);
		 int counter = 0;
		// String symbol;
		 while(number_of_symbols>counter){
			int symbol;
			 int initial_read = inputstream.read();
			 if(initial_read == 0){
				  symbol = "E.O.F";
					int depth = inputstream.read();
					TreeNode temp1=new TreeNode(symbol,depth);
					//	System.out.print(depth);
					pqCanonical.add(temp1);
					 counter++;
			 }else{
			 symbol = Character.toString((char)initial_read);
			
			 int depth = (char)inputstream.read();
			// HashMapDecode.canonicalHashDecode.put(symbol,depth);
				TreeNode temp1=new TreeNode(symbol,depth);
				pqCanonical.add(temp1);

			 counter++;
			// System.out.print(symbol);
		 }
		 }		
		while(!pqCanonical.isEmpty()){
			//TreeNode temp=pqCanonical.poll();
			
		}
			 
		 
		 System.out.print(HashMapDecode.canonicalHashDecode);
		// fread(&buffer, 1, 1, file); 
		 
		 /*
			byte[] data   = new byte[5];
			int    bytesRead = inputstream.read(data);
			int counter=0;

			while(0 < bytesRead) {
				counter++;
				int Symbol =  data[counter];
				counter++;
				int len = data[counter];
				
				System.out.println(Symbol);

			
			//	bytesRead = inputstream.read(data);
			}
			inputstream.close();
	 */
	 }
	 
}
