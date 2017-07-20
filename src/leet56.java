package algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class leet56 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		leet56 test = new leet56();
		List<Interval >result = test.merge(intervals);
		System.out.println(test.merge(intervals));
	}
	// my own method, seems the key idea is similar with otehrs
	// sort is the gist, if there is an distinct interval, the second start must be larger than the first end.
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null) return null; 
		List<Interval> result = new ArrayList<Interval>();
		if(intervals.size() == 0) return result;
		Interval dummy = new Interval(Integer.MAX_VALUE,Integer.MAX_VALUE);
		intervals.add(dummy);
        Collections.sort(intervals, new Comparator<Interval>(){
        			public int compare(Interval o1, Interval o2){
        				//sort by their start value
        				if(o1.start < o2.start) return -1;
        				else if(o1.start > o2.start) return 1;
        				else return 0;
        			}
        		});
        int tmpStart = 0; int tmpEnd = 0; Interval current;
        Iterator<Interval> iter = intervals.iterator();        
    		current = iter.next();
    		tmpStart = current.start;
    		tmpEnd = current.end;
        
    		while(iter.hasNext()){
    			current = iter.next();
    			if(current.start > tmpEnd){
    				// previous part is confirmed
    				Interval ans = new Interval(tmpStart,tmpEnd);
    				result.add(ans);
    				tmpEnd =current.end;
    				tmpStart = current.start;
    			}
    			else{
    				tmpEnd = Math.max(current.end, tmpEnd);
    			}
    		}
        return result;
    }
}
