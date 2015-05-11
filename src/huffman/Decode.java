package huffman;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.PriorityQueue;

public class Decode {
	static int number_of_symbols;
	public Decode(){
		
	}
	public static PriorityQeueCompareCanonical pqcCanonical=new PriorityQeueCompareCanonical();


	 public static void main(String[] args) throws IOException{
		 
		InputStream inputstream = new FileInputStream(args[0]);
		byte[] data   = new byte[1024];
		  number_of_symbols = inputstream.read();
		 PriorityQueue<TreeNode> pqCanonical=new PriorityQueue<TreeNode>(number_of_symbols,pqcCanonical);
		 int counter = 0;
		 while(number_of_symbols>counter){
			String symbol;
			 int initial_read = inputstream.read();
			 if(initial_read == 0){
				 	symbol = Integer.toString(0);
					int depth = inputstream.read();
					TreeNode temp1=new TreeNode(symbol,depth);
					pqCanonical.add(temp1);
					DecoderHuffmanTree.pqTree.add(temp1);
					 counter++;
			 }else{
				symbol = Integer.toString(initial_read);
				int depth = inputstream.read();
				TreeNode temp1=new TreeNode(symbol,depth);
				DecoderHuffmanTree.pqTree.add(temp1);
				pqCanonical.add(temp1);

			 counter++;
		 }
		 }	
		 
	
		 String s = "0";
		while(!pqCanonical.isEmpty()){
			TreeNode temp=pqCanonical.poll();
			if(s.length()< temp.depth)
		        while(s.length() != temp.depth){
		        	s = "0"+s;
		        }
		     
		       System.out.println(temp.characters+":"+s);
		       	temp.canonical_code=s;
		        s = Integer.toBinaryString(Integer.valueOf(s, 2) + 1);
		        
	
		}
		int    bytesRead = inputstream.read(data);

		while(bytesRead != -1) {

			
			for(int i =0; i < data.length && i < 20; i++)
				DecoderHuffmanTree.readBytes(data[i]);
			bytesRead = inputstream.read(data);
		}

		
		inputstream.close();
		DecoderHuffmanTree.decodebuildtree();

	 }
	 
}
