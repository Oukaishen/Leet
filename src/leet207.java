package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class leet207 {
	public static void main(String [] args){
		int numCourses = 2;
		int [][] prerequisites = {{1,0}};
		leet207 test = new leet207();
		System.out.println(test.canFinish(numCourses, prerequisites));
	}
public boolean canFinish(int numCourses, int[][] prerequisites) {
        int [] indegree = new int[numCourses];
        Arrays.fill(indegree, 0);
        ArrayList<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i< numCourses; i++){
        		adj.add(new ArrayList<>());
        }
        
        
        for(int i = 0; i< prerequisites.length; i++){
        		indegree[prerequisites[i][0]] += 1;  
        		
//        		if(adj.get(prerequisites[i][1]) == null ){
//        			ArrayList<Integer> temp = new ArrayList<>();
//        			temp.add(prerequisites[i][0]);
//        			adj.set(prerequisites[i][1], temp);
//        		}
//        		else
        			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        Queue<Integer> que = new LinkedList<>();
        int counter = 0;
        
        for(int i = 0; i< numCourses;i++){
        		if(indegree[i] == 0)
        			que.offer(i);
        }
        
        
        
        while(!que.isEmpty()){
        		int node = que.poll();
        		counter++;
        		
        		for(int toNode: adj.get(node)){
        			indegree[toNode]--;
        			if(indegree[toNode] == 0)
        				que.offer(toNode);
        		}
        }
        
        if(counter == numCourses)
        		return true;
        return false;
    }
}
