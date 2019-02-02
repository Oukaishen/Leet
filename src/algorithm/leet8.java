package algorithm;

public class leet8 {
public int myAtoi(String str) {
		   if(str.isEmpty()) return 0;
           int end = 0, base = 0, sign = 1;
           char [] arr = str.toCharArray();
           while( arr[end] == ' ') end++;
           if(arr[end] == '+' || arr[end] == '-') sign = arr[end++] == '+'? 1: -1; 
           while(end < arr.length && arr[end] <= '9' && arr[end] >= '0'){
        	   		if(base > Integer.MAX_VALUE/10 || (base == Integer.MAX_VALUE/10 && arr[end]-'0' > 7))
        	   			return sign == 1? Integer.MAX_VALUE: Integer.MIN_VALUE;
        	   			
        	   		base = base* 10 + (arr[end++]-'0');
           }
           return base*sign;
    }
}
