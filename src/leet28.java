package algorithm;

public class leet28 {
public int strStr(String haystack, String needle) {
        // first try brutal force
		int M = haystack.length();
		int N = needle.length();
		if( M < N) return -1;
		if( M == 0 || N == 0) return 0;
		for(int i = 0; i <= M - N; i++){
			int tmp = 0;
			while(haystack.charAt(i + tmp) == needle.charAt(tmp))
				{tmp++;
				 if(tmp == needle.length())
					 return i;
				}
		}
		return -1;
    }
}
