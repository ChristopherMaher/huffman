package huffman;

import java.util.Comparator;

public class PriorityQeueCompare implements Comparator<TreeNode> {
/*
 * (non-Javadoc)
 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
 */

	@Override
	public int compare(TreeNode o1, TreeNode o2) {
		// TODO Auto-generated method stub
		int node_frequency1 = o1.frequency;
		int node_frequency2 = o2.frequency;
		
		if(node_frequency1 > node_frequency2){
			return 1;
		}else if (node_frequency1 < node_frequency2) {
			return -1;
		} else {
			return 0;
		}	}

}
