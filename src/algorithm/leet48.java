package algorithm;

import java.util.Arrays;

public class leet48 {
	public static void main(String[] args){
		leet48 test = new leet48();
		int [][] matrix = {{1,2},{3,4}};
		test.rotate(matrix);
		System.out.println(Arrays.deepToString(matrix));
		
		
	}
public void rotate(int[][] matrix) {
		for(int i = 0; i< matrix.length/2; i++){
        		int[] temp = matrix[i];
        		matrix[i] = matrix[matrix.length-1 - i];
        		matrix[matrix.length -1 -i] = temp;
        }
        for(int i = 0; i < matrix.length; i++){
        		for(int j = i+1; j< matrix[0].length; j++){
        			matrix[i][j] = matrix[i][j] + matrix[j][i];
        			matrix[j][i] = matrix[i][j] - matrix[j][i];
        			matrix[i][j] = matrix[i][j] - matrix[j][i];
        		}
        }
    }
}
