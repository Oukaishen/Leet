package algorithm;

public class leet84 {
	// try brutal force
	// -.- 95/96 past, time exceed limit.
public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int lo = 0, res = 0;
        	for(int i = 0; i<heights.length; i++){
        		int low = heights[i];
        		res = Math.max(res, low);
        		for(int j = i+1; j< heights.length; j++){
        			low = Math.min(low, heights[j]);
        			res = Math.max(res, (j-i+1)*low);
        		}
        	}
        	return res;
    }
	// cannot do this myself
public int largestRectangleArea1(int[] heights){
	if(heights == null || heights.length == 0) return 0;
	int [] leftidx = new int[heights.length];
	int [] rightidx = new int[heights.length];
	leftidx[0] = -1;
	rightidx[heights.length-1] = heights.length;
	
	for(int i = 1; i< heights.length; i++){
		int p = i-1;
		while(p >= 0 && heights[p] >= heights[i])
			p = leftidx[p];
		leftidx[i] = p;
	}
	
	for(int i = heights.length - 2; i>= 0; i--){
		int p = i+1;
		while(p< heights.length && heights[p]>= heights[i])
			p = rightidx[p];
		rightidx[i] = p;
	}
	
	int res = 0;
	for(int i = 0; i< heights.length; i++){
		res = Math.max(res, heights[i]*(rightidx[i] - leftidx[i]-1));
	}
	return res;
}

}
