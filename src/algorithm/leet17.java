package algorithm;

import java.util.LinkedList;
import java.util.List;

public class leet17 {
	
	public static void main(String [] args){
		leet17 test = new leet17();
		System.out.println(test.letterCombinations("232"));
	}
	
public static final String [] keyboard = {"","", "abc","def","ghi", "jkl", "mno","pqrs","tuv","wxyz"};
public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList<String>();
        if(digits == null || digits.length() == 0) return res;
        sub(res,"",digits);
        return res;
        
    }

private void sub(List<String> res, String prefix, String remain){
	if(remain == null || remain.length() == 0) {
		res.add(prefix);
		return;
	}
	
	int number = Character.getNumericValue(remain.charAt(0));
	String newRemain = remain.substring(1);
	char [] charr = keyboard[number].toCharArray();
	
	for(int i = 0; i<charr.length; i++){
		String newPrefix = prefix + charr[i];
		sub(res,newPrefix,newRemain);
	}
	
}

}
