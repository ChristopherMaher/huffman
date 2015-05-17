package huffman;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.PriorityQueue;

public class Decode {
	static int number_of_symbols;
	public Decode(){
		
	}
	public static PriorityQeueCompareCanonical pqcCanonical=new PriorityQeueCompareCanonical();


	 public static void main(String[] args) throws IOException{
		 try {
			
		    Writer  writer=new BufferedWriter(new FileWriter(new File(args[1])));


		InputStream inputstream = new FileInputStream(args[0]);
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
					temp1.leaf = true;
					pqCanonical.add(temp1);
					DecoderHuffmanTree.pqTree.add(temp1);
					 counter++;
			 }else{
				symbol = Integer.toString(initial_read);
				int depth = inputstream.read();
				TreeNode temp1=new TreeNode(symbol,depth);
				temp1.leaf = true;
				DecoderHuffmanTree.pqTree.add(temp1);
				pqCanonical.add(temp1);

			 counter++;
		 }
		 }	
		 
	
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
						temp.canonical_code = s_cononical_code;
						previous_depth = current_depth;
					}else{
				cononical_code=cononical_code+1;
				s_cononical_code=String.format("%8s", Integer.toBinaryString(cononical_code & 0xFF)).replace(' ', '0');

				s_cononical_code=s_cononical_code.substring(8-current_depth,8);
				temp.canonical_code = s_cononical_code;
				previous_depth = current_depth;
					}
				}
				if(current_depth<previous_depth){
					cononical_code=cononical_code+1;

					cononical_code=(byte)cononical_code>>(previous_depth-current_depth);
					s_cononical_code=String.format("%8s", Integer.toBinaryString(cononical_code & 0xFF)).replace(' ', '0');
					s_cononical_code=s_cononical_code.substring(8-current_depth,8);					
					temp.canonical_code = s_cononical_code;

					previous_depth = current_depth;

				}
				
			}
		
		TreeNode root=DecoderHuffmanTree.decodebuildtree();
		TreeNode current_node = root;
		
		byte[] data1   = new byte[1024];
		int    bytesRead = inputstream.read(data1);
		Boolean endOfFile=false;
		while(bytesRead != -1) {


			for(int i =0; i < data1.length; i++){
				if( endOfFile==false){
				int mask = 0x80;
				
			while(mask!=0){
			
				int value = (mask & data1[i] );
			
				if(value==0){
					current_node = current_node.left;

					if(current_node.leaf==true){
						System.out.println(current_node.characters);
						int left_characters=Integer.parseInt(current_node.characters);
						writer.write(left_characters);

						int node_for_end=Integer.parseInt(current_node.characters);
						if(node_for_end == 0){
							endOfFile=true;
							break;
						}else{
							current_node = root;
						}
					}
				}else{
					current_node = current_node.right;
				if(current_node.leaf!=true){

						if(current_node.characters == "0"){
					//		System.out.print("ASDFASFD");
							endOfFile=true;
						}
					}else{
						int right_characters=Integer.parseInt(current_node.characters);
						writer.write(right_characters);
						
						System.out.println(current_node.characters);
						current_node = root;

					}
			}
			
			 mask=mask >> 1;
		}
			
				}
			}

			bytesRead = inputstream.read(data1);
		}
		
		inputstream.close();
		writer.flush();
		writer.close();
	 }catch (IOException e) {
			e.printStackTrace();
		}
	 }
}
