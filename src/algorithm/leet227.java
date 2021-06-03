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

	public int calculate_new(String s){

		if(null == s || s.isEmpty()){
			return 0;
		}
		Stack<String> stack = new Stack<>();
		int curNum = 0;
		boolean curNumStart = false;
		int ptr = 0;

		while (ptr >= 0 && ptr < s.length()) {

			char c = s.charAt(ptr);
			if(c - '0' >= 0 && c -'0' <=9 ){
				if(!curNumStart){
					curNumStart = true;
				}
				curNum = curNum * 10 + (c - '0');
				ptr++;
			} else if( c == '+' || c == '-'){
				if(curNumStart){
					stack.push(String.valueOf(curNum));
					curNum = 0;
					curNumStart =false;
				}
				stack.push(String.valueOf(c));
				ptr++;
			} else if( c == '*' || c== '/'){
				if(curNumStart){
					stack.push(String.valueOf(curNum));
					curNum = 0;
					curNumStart =false;
				}
				int nextNum = 0;
				boolean nextNumStart = false;
				while(ptr < s.length()){
					char nextc = s.charAt(ptr);
					if( (nextc -'0' < 0 || nextc-'0' > 9) && nextNumStart){
						break;
					}else if(nextc -'0' >= 0 && nextc-'0' <= 9){
						if(!nextNumStart){
							nextNumStart = true;
						}
						nextNum = nextNum * 10 + (nextc -'0');
					}
					ptr++;
				}
				switch (c){
					case '*': {
						int lastNum = Integer.valueOf(stack.pop());
						stack.push(String.valueOf(lastNum * nextNum));
						break;
					}case '/': {
						int lastNum = Integer.valueOf(stack.pop());
						stack.push(String.valueOf(lastNum / nextNum));
					}
				}
			} else if( c == ' '){
				if(curNumStart){
					stack.push(String.valueOf(curNum));
					curNum = 0;
					curNumStart = false;
				}
				ptr++;
			}

		}

		if(curNumStart){
			stack.push(String.valueOf(curNum));
			curNum = 0;
			curNumStart = false;
		}

		int res = 0;
		while(!stack.isEmpty()){
			curNum = Integer.valueOf(stack.pop());
			if(!stack.isEmpty() && stack.pop().equals("-")){
				curNum = -curNum;
			}
			res += curNum;
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println(new leet227().calculate_new("0*1+ 2* 3"));
	}

}
