package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class leet22 {
	// 
	public static void main(String [] args){
		leet22 test = new leet22();
		System.out.println(test.generateParenthesis(2));
	}
	// cannot do it myself, it two specific problem
public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<String>();
        if(n <= 0) return res;
        
        sub(res,"",0,0, n);
        return res;
    }

private void sub(List<String> list, String prefix, int open, int close, int max){
	if(prefix.length() == max*2)
		list.add(prefix);
	else{
		if(open < max) 
			sub(list, prefix+"(",open+1, close, max);
		if(close < open)
			sub(list, prefix+")", open, close+1, max);
	}
}

}
