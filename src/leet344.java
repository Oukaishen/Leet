package algorithm;

public class leet344 {
public String reverseString(String s) {
      if(s == null || s.length() == 0) return s;
      int N = s.length();
      StringBuilder sb = new StringBuilder();
      for(int i = N-1 ; i>=0; i--){
    	  		sb.append(s.charAt(i));
      }
      return sb.toString();
    }
}
