package huffman;


import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.Scanner;

public class Encode {

	public Encode(){
		
	}

	
	public static void main(String... args) throws IOException {
		FrequencyTable test = new FrequencyTable();

		InputStream inputstream = new FileInputStream("sample.txt");

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
		//System.out.println("ASCII => " + Charset.forName("ASCII"));
		//String s = "Hello World! \u00ff";
		//byte[] b = s.getBytes("98");
		//System.out.println(new String(b, "ISO-98"));
	//	System.out.println((char)65); 
		
		
	}
}


