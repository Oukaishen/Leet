package algorithm;

public class Leet695 {

    boolean [][] visited;
    int rows, cols;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null ) return -1;
        rows = grid.length;
        cols = grid[0].length;
        visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for(int r =0; r < rows; r++ ){
            for(int c=0; c< cols; c++){
                if(grid[r][c] == 1)
                    max = Math.max(dfs(r,c,grid), max);
            }
        }
        return max;
    }

    public int dfs(int r, int c, int[][] grid){
        if(r <0 || r >= rows || c<0 || c >= cols || grid[r][c] == 0  || visited[r][c]){
            return 0;
        }
        visited[r][c] = true;
        return 1 + dfs(r-1, c, grid) + dfs(r+1, c ,grid) +
                dfs(r, c-1, grid) + dfs(r, c+1, grid);
    }
}
