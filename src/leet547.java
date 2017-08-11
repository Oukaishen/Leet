package algorithm;

public class leet547 {
	// again the findunion save me. this works
	// but how is the dfs method?
public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length) return -1;
        int N = M.length;
        int res = 0;
        int id [] = new int [N];
        for(int i = 0; i<N; i++) id[i] = i;
        
        for(int i = 0; i<N; i++){
        		for(int j = 0; j<N; j++){
        			if(i==j) continue;
        			if(M[i][j] == 1){
        				union(i,j,id);
        				M[i][j] = 0;
        				M[j][i] = 0;
        			}
        		}
        }
        
        for(int i = 0; i<N;i++){
        		if(id[i] == i) res++;
        }
        
        return res;
    }

private int findroot(int[] id, int p){
	while(id[p] != p) p = id[p];
	return p;
}

private void union(int p1, int p2, int[] id){
	int id1 = findroot(id, p1);
	int id2 = findroot(id, p2);
	if(id1 == id2) return;
	if(id1 < id2 ) id[id2] = id1;
	else id[id1] = id2;
}

// dfs method
public int findCircleNum1(int[][] M){
	if(M == null || M.length == 0 || M[0].length == 0 || M.length != M[0].length ) return -1;
	int res = 0; int N = M.length;
	int [] visited = new int [N];
	for(int i = 0; i< N; i++){
		if(visited[i] == 0){
			res++;
			DFS(M, visited, i);
		}
	}
	return res;
}

private void DFS(int [][] M, int [] visited, int i){
	for(int j = 0; j<M.length; j++){
		if(M[i][j] == 1 && visited[j] == 0){
			visited[j] = 1;
			DFS(M,visited,j);
		}
	}
}

}
