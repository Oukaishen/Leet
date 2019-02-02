package algorithm;

import java.util.ArrayList;
import java.util.List;



public class leet212 {
//very good problem
	class TNode{
		 TNode [] children = new TNode[26];
		 String word;
	}
	
private TNode buildTree(String[] words){
	TNode root = new TNode();
	for(String word: words){
		TNode node = root;
		for(char ch : word.toCharArray()){
			if(node.children[ch-'a'] == null){
				node.children[ch - 'a'] = new TNode();
			}
			node = node.children[ch - 'a'];
		}
		node.word = word;
	}
	return root;
}

public List<String> findWords(char[][] board, String[] words) {
		if(board == null) return null;
		List<String> res = new ArrayList<>();
		TNode root = buildTree(words);
		
		for(int i = 0; i< board.length; i++){
			for(int j = 0; j<board[0].length ; j++){
				dfs(res, board, root, i,j);
			}
		}
		return res;
    }

private void dfs( List<String> res, char[][] board, TNode root, int starti, int startj ){
		if(starti <0 || startj <0 || starti >= board.length || startj >= board[0].length) return;
		char ch = board[starti][startj];
		if( ch == '#' || root.children[ch - 'a'] == null) return;
		root = root.children[ch - 'a'];
		if(root.word != null){
			res.add(root.word);
			root.word = null;
		}
		
		board[starti][startj] = '#';
		dfs(res,board,root,starti-1,startj);
		dfs(res,board,root,starti+1,startj);
		dfs(res,board,root,starti,startj-1);
		dfs(res,board,root,starti,startj+1);
		board[starti][startj]  = ch;
		
}
	
}
