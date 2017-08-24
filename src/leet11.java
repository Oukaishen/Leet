package algorithm;

public class leet11 {
public int maxArea(int[] height) {
		if(height == null || height.length == 0) return 0;
		int left = 0; int right = height.length - 1;
		int res = Integer.MIN_VALUE;
		while(left < right){
			int shortEdge = 0;
			if(height[left] < height[right]){
				shortEdge = height[left];
				res = Math.max(res, shortEdge * (right - left));
				left++;
			}
			else{
				shortEdge = height[right];
				res = Math.max(res, shortEdge * (right - left));
				right--;
			}
		}
		return res;
    }
}
