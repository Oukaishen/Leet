package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class leet395 {
	 // cannot do this myself
	 public int longestSubstring(String s, int k) {
	      if(s == null || s.isEmpty()) return 0;
	      if(k == 0 || k == 1) return s.length();
	      
	      char [] arr = s.toCharArray();
	      return sub(arr, 0, arr.length, k);
	 }

	 private int sub(char [] arr, int start, int end, int k){
		 if(end - start < k) return 0;
		 int[] count = new int[26];
		 for(int i = start; i<end; i++){
			 int index = arr[i] - 'a';
			 count[index]++;
		 }
		 for(int i = 0; i< 26; i++){
			 if(count[i] < k && count[i] > 0){
				 for(int j = start; j < end; j++){
					 if(arr[j] - 'a' == i){
						 int left = sub(arr, start, j, k);
						 int right = sub(arr, j+1, end, k);
						 return Math.max(left, right);
					 }
				 }
			 }
		 }
		 return end - start;
	 }
	 
}
