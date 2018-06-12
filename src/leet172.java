package algorithm;

public class leet172 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(trailingZeroes(3));
	}
	
	public static int trailingZeroes(int n) {
       int result = 0;
	   int k_now = 5;
       while( k_now <= n){
    	   		result += n/k_now;
    	   		n /= 5;
       }
       return result;
    }
	
}
