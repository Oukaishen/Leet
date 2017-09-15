package algorithm;

import java.util.Stack;

public class leet227 {
	// cannot do it myself
	public int calculate(String s) {
		if(s== null || s.trim().isEmpty()) return 0;
		Stack<Integer> stack = new Stack<>();
		s=s.trim(); int num = 0;
		char sign = '+';
		for(int i = 0; i< s.length(); i++){
			char ch = s.charAt(i);
			if(Character.isDigit(ch)){
				num = num*10 + (ch - '0');
			}
			if(!Character.isDigit(ch) && ch != ' ' || i == s.length()-1){
				if(sign == '+')
					stack.push(num);
				else if(sign == '-')
					stack.push(-num);
				else if(sign == '*')
					stack.push(stack.pop()*num);
				else if(sign == '/')
					stack.push(stack.pop()/num);
				sign = ch;
				num = 0;
			}
		}
		int res = 0;
		for(int i : stack){
			res += i;
		}
		return res;
}


}
