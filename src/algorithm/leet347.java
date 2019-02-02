package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class leet347 {
	// let me try hashmap method
public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if(nums == null) return res;
        HashMap<Integer,Integer> count = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
        		count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        List<Map.Entry<Integer, Integer>> forsort = new LinkedList<>(count.entrySet());
        Collections.sort(forsort, 
        					 new Comparator<Map.Entry<Integer,Integer>>(){

								@Override
								public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
									// TODO Auto-generated method stub
									return (o2.getValue().compareTo(o1.getValue()));
								}
        	
        					}
        );
        for(int i = 0; i< k; i++){
        		res.add(forsort.get(i).getKey());
        }
        return res;
    }
}
