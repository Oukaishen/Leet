package algorithm;

public class leet459 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(leet459.repeatedSubstringPattern("bb"));
	}
	
    public static boolean repeatedSubstringPattern(String s) {
    		
    		if(s == null || s.isEmpty()) 
    			return false;
    		int N = s.length();
    		for(int k=1; k <=N/2; k++){
    			if( N%k != 0 )
    				continue;
    			StringBuffer sb = new StringBuffer();
    			for(int i = 0; i< N/k; i++){
    				sb.append(s.substring(0, k));
    			}
    			if(s.equals(sb.toString()))
    				return true;
    		}
    	
    		return false;
    }
}
