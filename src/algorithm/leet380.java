package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class leet380 {
	
	Map<Integer,Integer> map;
	List<Integer> list;
	Random rand;
	
	/** Initialize your data structure here. */
    public leet380() {
        map = new HashMap<Integer,Integer>();
        list = new ArrayList<Integer>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
    		if(map.containsKey(val)) return false;
    		
    		int index = list.size();
    		map.put(val, index);
    		list.add(val);
    		return true;
    		
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        
        int index = map.get(val);
        if(index < list.size()-1) {
        		// this is not the last element. then we swap the last element with this element 
        		int lastElement = list.get(list.size()-1);
        		map.put(lastElement, index);
        		list.set(index, lastElement);
        }
        // delete the last element of the list and also delete the key-value pair form the map
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
