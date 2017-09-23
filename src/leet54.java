package algorithm;

import java.util.ArrayList;
import java.util.List;

public class leet54 {
	//cannot do this myself. dont like this kind of problem
public List<Integer> spiralOrder(int[][] matrix) {
        
		List<Integer> res = new ArrayList<>();
		
		if(matrix.length == 0 ) return res;
		int rowBegin = 0;
		int rowEnd = matrix.length-1;
		int colBegin = 0;
		int colEnd = matrix[0].length-1;
		
		while(rowBegin <= rowEnd && colBegin <= colEnd){
			//traverse to right 
			for(int j = colBegin; j<=colEnd; j++){
				res.add(matrix[rowBegin][j]);
			}
			rowBegin++;
			
			//traverse down
			for(int j = rowBegin; j<= rowEnd; j++){
				res.add(matrix[j][colEnd]);
			}
			colEnd--;
			
			if(rowBegin<=rowEnd){
			//traverse left
				for(int j = colEnd; j>=colBegin;j--){
					res.add(matrix[rowEnd][j]);
				}
				rowEnd--;
			}
			
			if(colBegin <= colEnd){
				//traverse up
				for(int j = rowEnd; j >=rowBegin; j--){
					res.add(matrix[j][colBegin]);
				}
				colBegin++;
			}
		}
		return res;
    }
}
