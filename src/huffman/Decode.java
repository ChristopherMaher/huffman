package huffman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Decode {

	 public static void main(String[] args) throws IOException{
		 BufferedReader in = new BufferedReader(new FileReader("sample.txt"));
			String str;
			String thng = null;
			int count = 0;
			int count2 = 0;
			while ((str = in.readLine()) != null) {
				thng = str;
		
			}

			in.close();
			System.out.print(thng);
	 }
}
