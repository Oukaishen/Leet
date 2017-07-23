package algorithm;

import java.util.Stack;

public class leet20 {
public boolean isValid(String s) {
		// easy for fun
        Stack<Character> stack = new Stack<Character>();
        
        for(char c:s.toCharArray()){
        		if( c == '(' || c == '[' || c == '{'){
        			stack.push(c);
        		}
        		if(c == '}'){
        			if(stack.isEmpty()) return false;
        			if(stack.peek() != '{') return false;
        			stack.pop();
        		}
        		if(c == ']'){
        			if(stack.isEmpty()) return false;
        			if(stack.peek() != '[') return false;
        			stack.pop();
        		}
        		if(c == ')'){
        			if(stack.isEmpty()) return false;
        			if(stack.peek() != '(') return false;
        			stack.pop();
        		}
        }
        return stack.isEmpty();
    }
}
