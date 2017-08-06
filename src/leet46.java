
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class leet46 {
public List<List<Integer>> permute(int[] nums) {
        List<Integer> prefix = new LinkedList<>();
        ArrayList<Integer> remain = new ArrayList<>();
        for(int num:nums){
        	remain.add(num);
        }
        List<List<Integer>> result = new LinkedList<>();
        sub(prefix,remain,result);
        return result;
    }

private void sub(List<Integer> prefix, ArrayList<Integer> remain, List<List<Integer>> result){
	if(remain.isEmpty()) {
		result.add(prefix);
	}
	
	for(int i = 0; i< remain.size();i++){
		Integer item = remain.get(i);
		List<Integer> newPrefix = new LinkedList<Integer>(prefix);
		newPrefix.add(item);
		ArrayList<Integer> newRemain = new ArrayList<Integer>(remain);
		newRemain.remove(item);
		sub(newPrefix,newRemain,result);
	}
	
}

}
