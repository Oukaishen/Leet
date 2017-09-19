package algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class leet118 {
public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tempList = new LinkedList<>();
        for(int i = 0; i< numRows; i++){
        		tempList.add(0,1);
        		for(int j = 1; j< tempList.size()-1 ; j++){
        			tempList.set(j, tempList.get(j)+tempList.get(j+1));
        		}
        		res.add(new LinkedList<>(tempList));
        }
        return res;
    }
}
