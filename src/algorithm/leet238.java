package algorithm;

public class leet238 {
	// done this before on offer. but how to reduce the space to constant?
public int[] productExceptSelf(int[] nums) {
		if(nums == null) return null;
		int N = nums.length;
		if(N <= 1) throw new UnsupportedOperationException();
		int [] pre = new int[N];
		int [] after = new int [N];
		pre[0] = 1;
		after[N-1] = 1;
		for(int i = 1; i<N;i++){
			pre[i] =pre[i-1] * nums[i-1];
			after[N-1 - i] = after[N - i] * nums[N-i];
		}
		
		int [] res = new int[N];
		for(int i = 0; i< N; i++){
			res[i]  = pre[i]*after[i];
		}
		return res;
    }
}
