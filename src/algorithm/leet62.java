package algorithm;

public class leet62 {
	
	public static void main(String[] args){
		System.out.println(leet62.uniquePaths(36, 7));
	}
	
	public static int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)return 1;
        int total = m + n - 2;
        int longside = Math.max(m, n)-1;
        int shortside = Math.min(m, n)-1;
        
        double res = 1;
        for(int i = longside + 1 ; i <= total; i++){
        		res *= i;
        }
        for(int i = shortside; i>=1 ;i--){
        		res /= i;
        }
        return (int)res;
    }
}
