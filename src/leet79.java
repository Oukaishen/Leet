package algorithm;

public class leet79 {
public boolean exist(char[][] board, String word) {
        if(board == null || word == null) return false;
        if(word.length() == 0) return true;
        
        int row = board.length;
        int col = board[0].length;
        
        boolean [][] visited = new boolean [row][col];
        
        boolean res = false;
        
        for(int i = 0; i < row ; i++){
        		for(int j = 0; j < col; j++){
        			if(dfs(i,j,board,visited,word))
        				return true;
        		}
        }
        return false;
        
    }
// actually this is my own method but just can not get that key sentence. -.- redo this
private boolean dfs(int starti, int startj, char[][] board, boolean[][] visited, String word){
	if(starti < 0 || startj < 0 || starti >= board.length || startj >= board[starti].length)
	return false;
	if(visited[starti][startj]) return false;
	if(board[starti][startj] != word.charAt(0)) return false;
	if(word.length() == 1) return true;
	else{
		boolean res = false;
		visited[starti][startj] = true;
		res = res || dfs(starti-1,startj, board,visited, word.substring(1));
		res = res || dfs(starti,startj-1, board,visited, word.substring(1));
		res = res || dfs(starti+1,startj, board,visited, word.substring(1));
		res = res || dfs(starti,startj+1, board,visited, word.substring(1));
		
		// this sentence, is the most important key of this problem
		visited[starti][startj] = false;
		
		return res;
	}
	
}

}
