package huffman;

import java.util.Comparator;

public class PQDecodeCompare implements Comparator<ComparableObject> {


		@Override
		public int compare(TreeNode o1, TreeNode o2) {
			// TODO Auto-generated method stub
			int node_depth1 = o1.depth;
			int node_depth2 = o2.depth;
			int node_characters1 = Integer.parseInt(o1.characters);
			int node_characters2 = Integer.parseInt(o2.characters);

		//	int node_character number = 
			
			if(node_depth1 > node_depth2){
				return -1;
			}else if (node_depth1 < node_depth2) {
				return 1;
			} else {
					if(node_characters1>node_characters2){
						return -1;
					}else{
						return 1;

					}
					
						
			}	}


	}