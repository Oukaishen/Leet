package algorithm;

public class leet463 {
	
		public static void main(String [] args){
			leet463 test = new leet463();
			int [][] grid = {{1,0}};
		}
public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0 || grid.length != grid[0].length) return 0;
        int res = 0;
        
        for(int i = 0 ; i < grid.length;i++){
        		for(int j = 0; j<grid[0].length ; j++){
        			if(grid[i][j] == 1){
        				
        				if(i == 0) res++;
        				if(i == grid.length - 1) res++;
        				if( i > 0 && grid[i-1][j] == 0) res++;
        				if( i < grid.length -1 && grid[i+1][j] == 0) res++;
        				
        				if(j == 0) res++;
        				if(j == grid[0].length - 1) res++;
        				if( j > 0 && grid[i][j-1] == 0) res++;
        				if( j < grid[0].length -1 && grid[i][j+1] == 0) res++;
        				  
        				 
        			}
        		}
        }
        return res;
    }
}
