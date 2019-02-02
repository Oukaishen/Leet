package algorithm;

import java.util.Stack;

public class leet557 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		leet557 test = new leet557();
		System.out.println(test.reverseWords("fuck you"));
	}
	public String reverseWords(String s) {
		// easy question, stack can solve 
        if(s == null || s.length()==0) return s;
        s = s+" ";
		Stack<Character> stack = new Stack<Character>();
		StringBuffer res = new StringBuffer();
		for(int i = 0; i<s.length();i++){
			char c = s.charAt(i);
			if(c == ' ' && !stack.isEmpty()){
				while(!stack.isEmpty())
					res.append(stack.pop());
				res.append(c);
			}
			else{
				stack.push(c);
			}
		}
		return res.deleteCharAt(res.length()-1).toString();
    }
}
