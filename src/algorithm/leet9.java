package algorithm;

public class leet9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leet9.isPalindrome(10));
	}
	
	public static boolean isPalindrome(int x) {
		if(x < 0) 
			return false;
		int rev = 0;
		for(int dupx = x; dupx > 0; dupx /= 10){
			rev = rev * 10 + dupx%10;
		}
		
		return rev == x;
    }
	
}
