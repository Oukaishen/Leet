package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class leet310 {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // cannot figure out myself
		// really fucking clever those guys
		// think of that we start form  the leaves, when they meet or one step to meet. we got the best root
		if(n == 1 ) return Collections.singletonList(0);
		List<Set<Integer>> adjacent = new ArrayList<>();
		for(int i = 0; i<n;i++){
			adjacent.add(new HashSet<Integer>());
		}
		for(int [] edge: edges){
			adjacent.get(edge[0]).add(edge[1]);
			adjacent.get(edge[1]).add(edge[0]);
		}
		List<Integer> leaves = new ArrayList<Integer>();
		for(int i = 0; i<n; i++){
			if(adjacent.get(i).size() == 1) leaves.add(i);
		}
		
		while(n > 2){
			n -= leaves.size(); // minus all the outest leaves
			List<Integer> newLeaves = new ArrayList<Integer>();
			for(int i : leaves){
				int j = adjacent.get(i).iterator().next();
				adjacent.get(j).remove(i);
				if(adjacent.get(j).size() == 1) newLeaves.add(j);
			}
			
			leaves = newLeaves;
		}
		return leaves;
    }
}
