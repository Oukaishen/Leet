package algorithm;

import java.util.Stack;

public class leet32 {
	public static void main(String[] args){
		leet32 test = new leet32();
		System.out.println(test.longestValidParentheses("()(()"));
	}
	
public int longestValidParentheses(String s) {
//		if(s == null) return 0;
//		Stack<Character> stack = new Stack<Character>();
//		int tmp = 0;
//		int max = Integer.MIN_VALUE;
//		boolean valid = false;
//		for(int i= 0; i<s.length();i++){
//			char c = s.charAt(i);
//			if( c == '('){
//				stack.push(c);
//				//valid = false;
//			}
//			else if(c == ')' && !stack.isEmpty()){
//				stack.pop();
//				tmp++;
//				if(stack.isEmpty()) valid = true;
//				if(tmp > max && valid) max = tmp;
//			}
//			else if(c == ')' && stack.isEmpty()){
//				tmp = 0;
//				valid =false;
//				if(tmp > max) max = tmp;
//			}
//		}
//		return max*2;
		if(s == null || s.length() == 0 ) return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int max = 0; int tmp =0;
		stack.push(-1);
		for(int i = 0; i<s.length(); i++){
			char c = s.charAt(i);
			if(c == '('){
				stack.push(i);
			}
			else if( c == ')'){
				stack.pop();
				if(!stack.isEmpty()){
					tmp = i - stack.peek();
					//max = (tmp>max)? tmp :max; // this one is slower than the next one
					max = Math.max(max, tmp);
				}
				else{
					stack.push(i); // the gist of this algorithm is to use index information; also, use invalid ")" to stop dis-continuous String
				}
			}
		}
		return max;
    }
}
