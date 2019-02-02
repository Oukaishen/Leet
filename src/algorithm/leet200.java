package algorithm;

import java.util.Arrays;

public class leet200 {
	// similar to the sedgick algorithm book 
	// this method is not the best. not very concise.
	// there is others' better solution
	public int numIslands(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int row = grid.length;
		int col = grid[0].length;
		int [] id = new int[row*col];
		Arrays.fill(id, -1);
		for(int i = 0; i< row; i++){
			for(int j = 0; j< col; j++){
				int numid = i*col+j;
				if(grid[i][j] == '1')
					id[numid] = numid;
			}
		}
		
		for(int i = 0; i< row; i++){
			for(int j = 0; j< col; j++){
				int numid = i*col+j;
				if(grid[i][j] == '1'){
					if(i>0 && grid[i-1][j]=='1')
						union(numid,(i-1)*col+j,id);
					if(i<row-1 && grid[i+1][j]=='1')
						union(numid,(i+1)*col+j,id);
					if(j>0 && grid[i][j-1]=='1')
						union(numid,i*col+j-1,id);
					if(j<col-1 && grid[i][j+1]=='1')
						union(numid,i*col+j+1,id);
				}
			}
		}
		
		int res = 0;
		for(int i = 0; i<id.length;i++){
			if(id[i] == i) res++;
		}
		return res;
    }
	private int find(int p, int[] id){
		while(id[p] != p) p = id[p];
		return p;
	}
	private void union(int p1, int p2, int[] id){
		int id1 = find(p1,id);
		int id2 = find(p2,id);
		if(id1 == id2) return;
		if(id1 < id2) id[id2] = id1;
		else id[id1] = id2;
	}
	// dfs method
	// faster
	public int numIslands1(char[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int row = grid.length;
		int col = grid[0].length;
		int res = 0;
		for(int i = 0; i< row; i++){
			for(int j = 0; j< col; j++){
				int numid = i*col+j;
				if(grid[i][j] == '1')
					{res++;
					DFSmark(i,j, grid);}
			}
		}
		return res;
	}
	private void DFSmark(int i, int j, char[][] grid){
		if(i<0 || j < 0 || i >= grid.length|| j>= grid[0].length || grid[i][j] != '1') return;
		grid[i][j] = '0';
		DFSmark(i-1,j,grid);
		DFSmark(i+1,j,grid);
		DFSmark(i,j-1,grid);
		DFSmark(i,j+1,grid);
	}
}
