package algorithm;

public class leet4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// this question is so fucking difficult, need to redo after two weeks on July 27, 2017
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
		int m = nums1.length;
		int n = nums2.length;
		
		int imin = 0; int imax = m;
		int half = (m + n + 1)/2;
		
		while(imin <= imax){
			int i = (imin + imax)/2;  int j = half - i;
			
			if( i < m  && nums2[j-1] > nums1[i]){
				// i is too samll, need to increase
				imin = i +1; // cut half of the min
			}
			else if(i > 0 && nums1[i-1] > nums2[j]){
				// i is too large, need to decrease
				imax = i-1;
			}
			else{
				// hit the perfect i 
				// think about these if-else. always think how to represent more concisely
				// less situation, use "else" to do as much as possible
				double maxOfLeft;
				double minOfRight;
				
				if (i == 0)
					maxOfLeft = (double) nums2[j-1];
				else if(j == 0)
					maxOfLeft = (double) nums1[i-1];
				else{
					maxOfLeft = (double) Math.max(nums1[i-1], nums2[j-1]);
				}
				
				if((m+n) %2 == 1)
					return maxOfLeft;
				
				if (i==m) minOfRight = nums2[j];
				else if(j == n) minOfRight = nums1[i];
				else{
					minOfRight = (double) Math.min(nums1[i], nums2[j]);
				}
				return (maxOfLeft+minOfRight) / 2.0;
			}
			
			
		}
		return -1;
    }
}
