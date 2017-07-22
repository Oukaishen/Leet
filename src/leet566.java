package algorithm;

public class leet566 {
public int[][] matrixReshape(int[][] nums, int r, int c) {
		// just for fun 
        	if(nums == null) return nums;
        	int origRow = nums.length;
        	int origCol = nums[0].length;
        	if( origRow * origCol != r*c) return nums;
        	
        	int [][] result = new int[r][c];
        	
        	for(int i = 0 ; i < origRow; i++){
        		for(int j = 0; j< origCol; j++){
        			int number = i*origCol + j;
        			int newRow = number/c;
        			int newCol = number%c;
        			result[newRow][newCol] = nums[i][j];
        		}
        	}
        	return result;
    }
}
