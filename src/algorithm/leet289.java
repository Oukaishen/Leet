package algorithm;

public class leet289 {
public void gameOfLife(int[][] board) {
        if(board == null) return;
        
        int row = board.length;
        int col = board[0].length;
        
        for(int i = 0; i< row; i++){
        		for(int j = 0; j< col; j++){
        			update(board, i, j);
        		}
        }
       
        for(int i = 0; i< row; i++){
    		for(int j = 0; j< col; j++){
    			switch (board[i][j]){
    				case 2: board[i][j] = 1; break;
    				case 3: board[i][j] = 0; break;
    				case 4: board[i][j] = 1; break;
    				default: board[i][j] = 0; 
    			}
    		}
    }
        
        
    }

private void update(int [][] board, int i, int j){
	int live_neigh = 0;
	boolean live = false;
	if(board[i][j] == 1) live = true;
	
	// 1
	if(i>0 && j>0 ) {
		if(board[i-1][j-1] == 2 || board[i-1][j-1] ==3) live_neigh++;
	}
	// 2
	if(i>0  ) {
		if(board[i-1][j] == 2 || board[i-1][j] ==3) live_neigh++;
	}
	// 3
	if(i>0 && j < board[i].length-1 ) {
		if(board[i-1][j+1] == 2 || board[i-1][j+1] ==3) live_neigh++;
	}
	// 4
	if( j > 0 ) {
		if(board[i][j-1] == 2 || board[i][j-1] ==3) live_neigh++;
	}	
	// 5
	if( j < board[i].length-1 ) {
		if(board[i][j+1] == 1 ) live_neigh++;
	}
	// 6
	if( i<board.length-1 && j > 0 ) {
		if(board[i+1][j-1] == 1 ) live_neigh++;
	}
	//7
	if( i<board.length-1  ) {
		if(board[i+1][j] == 1 ) live_neigh++;
	}
	// 8
	if( i<board.length-1 && j <board[i].length-1 ) {
		if(board[i+1][j+1] == 1 ) live_neigh++;
	}
	
	/// foure rules;
	if(live && live_neigh < 2) board[i][j] = 3;
	else if(live && (live_neigh == 2 || live_neigh == 3)) board[i][j] = 2;
	else if(live && live_neigh > 3) board[i][j] = 3;
	else if(!live && live_neigh ==3) board[i][j] = 4;
	
}

}
