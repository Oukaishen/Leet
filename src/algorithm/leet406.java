package algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class leet406 {
		public static void main(String[] args){
			int[][] people = new int [][]{
				{7,0},{7,1},{4,4},{6,1},{5,0},{5,2}
			};
			leet406 test = new leet406();
			System.out.println(test.reconstructQueue(people));
		}
public int[][] reconstructQueue(int[][] people) {
		// this method is quite clever. cannot solve on my own.
		if(people == null || people.length == 0) return people;
        Arrays.sort(people, new Comparator<int[]>(){
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0] == o2[0]) return o1[1]-o2[1];
				return o2[0] - o1[0];
			}
        	
        });
        for(int i = 1; i<people.length;i++){
        		//insert sort
        		int index = people[i][1];
        		for(int j = i; j>0 && j != index; j--){
        			int[] temp = people[j];
        			people[j] = people[j-1];
        			people[j-1] = temp;
        		}
        }
        return people;
    }
}
