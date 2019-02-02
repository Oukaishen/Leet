package algorithm;

public class leet96 {
public int numTrees(int n) {
        int [] G = new int [n+1]; //G[n] is the number of unique BST for a sequence length of n
        G[0] = G[1] = 1;
        for(int i = 2; i<=n;i++){
        		G[i] = 0;
        		for(int j = 1; j<= i; j++){
        			G[i] += G[j-1]*G[i-j];	//G[n] = sigma(F[i,n]) F[i,n] is the number of unique BST when i is the root
        			 // F[i,n] = G[i-1]*G[n-i] draw a picture and you can see that
        		} 
        }
      return G[n];  
    }
}
