package algorithm;

public class leet42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] height = {5,4,1,2};
		leet42 test = new leet42();
		System.out.println(test.trap(height));
	}
	//this is my own method. but its too complicated and not very concise.
	// hope to leanr form others and make more easy methods.
	public int trap(int[] height) {
        	if(height == null || height.length <3)
        		return 0;
        	int i = 0;
        	int j = 0;
        	int res = 0;
        	while(i<= height.length-3){
        		if(height[i] <= height[i+1]){
        			i++;
        			continue;
        		}
        		
        		// can we find a j that height[j] >=  height[i] first
        		j = i + 1; int tmp = j;
        		while(j < height.length && height[j]< height[i]){
        			if(height[j] > height[tmp]) tmp = j;
        			j++; // find the next max index
        			}
        		//cannot find then
        		if(j > height.length-1 ){
        			if( tmp == i+1 ){
        				i++; 
        				continue;
        			}
        			j = tmp;
        		}
        		
        		int left = height[i];
        		int right = height[j];
        		if(right >= left){
        			for(int k = i+1; k<j;k++){
        				res += left - height[k];
        			}
        			i = j;
        			continue;
        		}
        		else if(right < left ){
        			int low = height[i+1];
        			if(j == height.length-1 && right <= low)
        				{	i++;
        					continue;
        				}
        			for(int k = i+1;k<j;k++){
        				res += right - height[k];
        			}
        			i = j;
        			continue;
        		}
        	}
        	return res;
    }

	//others two pointer method, very concise
	public int trap1(int[] height){
		int i = 0;
		int j = height.length-1;
		int leftmax = 0;
		int rightmax = 0;
		int res = 0;
		if(height == null) return res;
		while(i<j){
			if(height[i] > height[j]){
					if(height[j] >= rightmax)
						rightmax = height[j];
					else
						res += rightmax - height[j];
					j--;
			}
			else{
				if(height[i] >= leftmax)
					leftmax = height[i];
				else
					res += leftmax - height[i];
				i++;
			}
		}
		return res;
	}
}
