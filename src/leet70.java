package algorithm;

public class leet70 {
	// again dont afraid this but just do it
public int climbStairs(int n) {
        if(n < 0 ) return -1;
        if(n <= 1) return 1;
        int n_2 = 1;
        int n_1 = 1;
        
        for(int i = 2; i<=n ; i++){
        		int tmp =  n_1+n_2;
        		n_2 = n_1;
        		n_1 = tmp;
        }
        
        return n_1;
    }
}
