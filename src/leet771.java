package algorithm;

public class leet771 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String J = "aA", S = "aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
	}
	
	public static int numJewelsInStones(String J, String S) {
        // try not to use hash set
		int [] chars = new int[255];
		for(int i = 0; i < 255; i++){
			chars[i] = 0;
		}
		for(char c : J.toCharArray()){
			chars[c] = 1;
		}
		
		int res = 0;
		for(char c:S.toCharArray()){
			if(chars[c] == 1)
				res += 1;
		}
		
		return res;
    }
	
}
