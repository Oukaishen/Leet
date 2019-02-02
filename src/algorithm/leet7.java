package algorithm;

public class leet7 {
	public static void main(String [] args){
		leet7 test = new leet7();
		System.out.println(test.reverse(1));
	}
public int reverse(int x) {
		if(x == 0 ) return 0;
        long num = x;
        int sign = x<0? -1 : 1;
        num = Math.abs(num);
        long res = 0;
        while(num != 0){
        		long digit =  num%10;
        		num /= 10;
        		res = res*10 +digit;
        		if(res > Integer.MAX_VALUE || -1*res < Integer.MIN_VALUE)
        			return 0;
        }
        return (int)res * sign;
    }
}
