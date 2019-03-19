package algorithm;

public class leet50 {
	// this regular idea seems to be time exceed limitation
	// we need to use the x2, x4, x8, x16 to speed up

	public static void main(String [] args){
		leet50 test = new leet50();
		System.out.println(-5 % 2);
		System.out.println(test.myPow2(2,-2));
	}

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

    /**
	 * 重新在练手思考这个问题
    * */
    public double myPow2(double x, int n ){
		if(n == 0) return 1;
		int next = Math.abs(n/2);
		double half = myPow2(x, next);
		double res = half*half;
		if(n % 2 != 0) res *= x;
		return n > 0 ? res: 1/res;
	}
}
