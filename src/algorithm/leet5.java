package algorithm;

public class leet5 {
	int lo, hi,max;
public String longestPalindrome(String s) {
        int N = s.length();
        if(N < 2 ) return s;
        else {
        		for(int i = 0; i< N; i++){
        			Palindrome(s,i,i); // this is an odd one
        			Palindrome(s,i,i+1); // this is an even one
        		}
        		return s.substring(lo, hi);
        }
    }

public void Palindrome(String s,int i, int j){
	// the key point for this question is that 
	// we need not to from two side to find the palindrom
	// but what we do is to expand from specific character to see how long it can reach
	while(j< s.length() && i>=0 && s.charAt(i) == s.charAt(j)  ){
		j++;
		i--;
	}
	if(max < j-i-1){
		max = j-i-1;
		hi = j;
		lo = i+1;
	}
}

}
