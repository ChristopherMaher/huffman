package huffman;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Scanner;

public class Encode {

	public Encode(){
		
	}

	
	public static void main(String... args) throws IOException {
		FrequencyTable test = new FrequencyTable();

		InputStream inputstream = new FileInputStream(args[0]);

		byte[] data   = new byte[1024];
		int    bytesRead = inputstream.read(data);

		while(bytesRead != -1) {

			int counter;
			
			for(int i =0; i < data.length && i < 20; i++)
				FrequencyTable.countFreq(data[i]);
		
			bytesRead = inputstream.read(data);
		}
		inputstream.close();
		HuffmanTree.create_initial_node_array();
		HuffmanTree.buildtree();
		try {
			FileOutputStream bufferedOut = new FileOutputStream(args[1]);
		
			
		
			Iterator iter =HuffmanTree.character_set_Nodes.iterator();
			

			bufferedOut.write(HuffmanTree.character_set_Nodes.size());
			for(int x=1;x<2*HuffmanTree.character_set_Nodes.size(); x++ ){
				String key_value = "";
				if (iter.hasNext()) {
				 TreeNode temp=(TreeNode) (iter.next());
				 key_value=temp.characters;
				    bufferedOut.write(Integer.parseInt(key_value));
				
				}
				x++;
				bufferedOut.write(EncodeCanonicalHuffman.canonicalHash.get(Integer.parseInt(key_value)).length());
				
			}

			InputStream inputStream2 = new FileInputStream(args[0]);

			byte[] data2   = new byte[1024];
			int  bytesRead2 = inputStream2.read(data2);
			ByteBuffer current_byte = new ByteBuffer();
			int bit_counter=0;
			Boolean end = false;
			while(bytesRead2 != -1) {
				int counter2;
				for(int i =0; i < data2.length && i < 20; i++){
					
					int symbol = data2[i];
					if(end!=true){
					String canonical_code=EncodeCanonicalHuffman.canonicalHash.get(symbol); 
					if(symbol == 0){
						end=true;
					}
					int canonical_code_break_up = 0;
						for(int x =0;x<canonical_code.length();x++){
							canonical_code_break_up= Character.getNumericValue(canonical_code.charAt(x));
						
							System.out.println(canonical_code+":"+canonical_code_break_up);
							 
							 if(bit_counter<8){
							 current_byte.update_byte_value(canonical_code_break_up);
							 bit_counter++;
							 }else{
								 bit_counter = 0;
								 bufferedOut.write(current_byte.byte_value);
								 current_byte.byte_value = 0;
								 current_byte = new ByteBuffer(canonical_code_break_up); 
								 //System.out.println(current_byte.byte_value+"SADF");
								 bit_counter++;
								 
							 }
						}
					
				
					
				
				}
				}
				if(end==true){
					bytesRead2=-1;
				}else
				bytesRead2 = inputStream2.read(data2);
			}
			if(bit_counter<8)
			 bufferedOut.write(current_byte.byte_value);
			inputStream2.close();
			
			bufferedOut.flush();
			bufferedOut.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
}


