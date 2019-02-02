package algorithm;

public class leet338 {
	// naive me thinks this is the good solution.
public int[] countBits(int num) {
        int [] result = new int [num+1];
        result[0] = 0;
        for(int i = 1; i<=num; i++){
        		int count = 0;
        		int tmp = i;
        		while(tmp != 0){
        			count++;
        			tmp = tmp & (tmp-1);
        		}
        		result[i] = count;
        }
        return result;
    }

	// those fucker genius got the dp solution as below.
    // this >> have to be careful to work on negative number.

}
