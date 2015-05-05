package huffman;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Encode {

	public Encode(){
		
	}
	public void frequencyCounter() throws IOException{

		
	}

	 public static void main(String[] args) throws IOException{
		 BufferedReader in = new BufferedReader(new FileReader("sample.txt"));
			String str;
			String thng = null;
			int count = 0;
			int count2 = 0;
			while ((str = in.readLine()) != null) {
				//thng = str;
				Huffmantree test = new Huffmantree(str);
				//Huffmantree.regex1();
				Huffmantree.countFreq();

			}

			in.close();
			//System.out.print(thng);
			//Huffmantree test = new Huffmantree(str);
			//Huffmantree.regex1();
			//Huffmantree.countFreq();
	 }
}
