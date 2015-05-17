package huffman;

import java.util.Comparator;

public class PriorityQeueCompareCanonical implements Comparator<TreeNode> {
/**
 * @param TreeNode o1,o2
 * designed to help make the canonical huffman codes
 */
		@Override
		public int compare(TreeNode o1, TreeNode o2) {
			// TODO Auto-generated method stub
			int node_depth1 = o1.depth;
			int node_depth2 = o2.depth;
			int node_characters1 = Integer.parseInt(o1.characters);
			int node_characters2 = Integer.parseInt(o2.characters);

			
			if(node_depth1 > node_depth2){
				return -1;
			}else if (node_depth1 < node_depth2) {
				return 1;
			} else {
					if(node_characters1>node_characters2){
						return 1;
					}else{
						return -1;

					}
					
						
			}	}


	}

