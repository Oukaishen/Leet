package algorithm;

public class leet50 {
	// this regular idea seems to be time exceed limitation
	// we need to use the x2, x4, x8, x16 to speed up
public double myPow(double x, int n) {
	double res = 1; long nn = n;
    if( new Double(x).equals(0) ) return 0;
	if(n == 0) return 1;
	
	if(nn < 0){
		nn = -nn;
		x = 1/x;
	}
	
	while(nn > 0){
		if( (nn & 1) > 0 ) res *= x;
		x *= x;
		nn >>= 1;
	}
	return res;
    }
}
