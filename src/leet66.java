package algorithm;

import java.util.Stack;

public class leet66 {
	//can solve this, but there is still better solution.
public int[] plusOne(int[] digits) {
		Stack<Integer> stack = new Stack<>();
        int digit = 0, carry = 0;
        for(int i = digits.length-1; i>=0; i--){
        		if( i == digits.length-1 ){
        			digit = (digits[i]+1)%10;
        			carry = (digits[i]+1)/10;
        			stack.push(digit);
        		}
        		else{
        			digit = (digits[i]+carry)%10;
        			carry = (digits[i]+carry)/10;
        			stack.push(digit);
        		}
        }
        if(carry != 0){
        		stack.push(carry);
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i<res.length;i++){
        		res[i] = stack.pop();
        }
        return res;
    }
}
