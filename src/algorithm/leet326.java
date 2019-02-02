package algorithm;

public class leet326 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new leet326().isPowerOfThree(243));
	}
	
	public boolean isPowerOfThree(int n) {
		return (Math.log10(n)/ Math.log10(3)) %1 == 0;
    }
}
