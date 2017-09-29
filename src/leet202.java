package algorithm;

import java.util.HashSet;

public class leet202 {
	HashSet<Integer> set = new HashSet<Integer>();
	public boolean isHappy(int n) {
        set.clear();
        return sub(n);
    }
	private boolean sub(int n){
		if(set.contains(n)) return false;
		int sum = 0; int tmp = n;
		while(tmp != 0){
			int digit = tmp%10;
			tmp /= 10;
			sum += digit*digit;
		}
		if(sum == 1) return true;
		set.add(n);
		return sub(sum);
	}
}
