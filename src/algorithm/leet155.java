package algorithm;

import java.util.ArrayList;

public class leet155 {
	
			class Item{
				private int val;
				private Item next;
				public Item(int x){
					val = x;
					next = null;
				}
			}
	Item first;
	int min;	
	public leet155() {
        first = null;
        min = Integer.MAX_VALUE;
    }
    
    public void push(int x) {
    		// the key idea is that 
    		// whenever we store a new min value, we store the previous-min value first.
    	    // this way, every time we del a current-min value, we can get the second-min value under it;
    		if(x <= min){
    			Item tmp = first;
    	        first = new Item(min);
    	        first.next = tmp;
    	        min = x;
    		}
    		
        Item tmp = first;
        first = new Item(x);
        first.next = tmp;
        
        //for min
        
    }
    
    public void pop() {
        if(first == null) return;
        if(first.val == min){
        		first = first.next; // remove the curr-min value
        		min = first.val;		// get the second min to act as current-min
        		first= first.next;  // remove this redundant node;
        }
        else
        first = first.next;
        //
  
    }
    
    public int top() {
        if(first == null) return -1;
        return first.val;
    }
    
    public int getMin() {
        return min;
    }
}
