package algorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class leet332 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public List<String> findItinerary(String[][] tickets) {
		
		if(tickets == null) 
			return null;
		if(tickets.length == 0 || tickets[0].length != 2)
			return null;
		int N = tickets.length;
		Map<String, PriorityQueue<String>> targets = new HashMap<>();
		for(String[] ticket : tickets){
			targets.computeIfAbsent(ticket[0], z -> new PriorityQueue()).add(ticket[1]);
		}
		List<String> res = new LinkedList<>();
		Stack<String> stack = new Stack<>();
		stack.push("JFK");
		while(!stack.isEmpty()){
			while(targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty()){
				stack.push( targets.get(stack.peek()).poll() );
			}
			res.add(0,stack.pop());
		}
		
		return res; 
    }
	
}
