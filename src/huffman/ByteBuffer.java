package huffman;

public class ByteBuffer {
//	static int counter = 0;
	static int byte_value = 0; 
	//int bit_value;
public ByteBuffer(int canonical_bit){
	
	byte_value = byte_value << 1;
	byte_value = byte_value | canonical_bit;
	
}
public ByteBuffer() {
	// TODO Auto-generated constructor stub
}
public ByteBuffer(int file,int current_byte_value) {
	// TODO Auto-generated constructor stub
}
public static void update_byte_value(int canonical_bit){
	byte_value = byte_value<< 1;
	byte_value = byte_value | canonical_bit;
	
	
}
public int flush_remianing_bits(){
	return byte_value;
}
}
