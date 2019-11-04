package algorithm;

public class Leet357 {
    public static void main(String [] args){

        Leet357 test = new Leet357();
        System.out.println(test.countNumbersWithUniqueDigits(2));

    }

    public int countNumbersWithUniqueDigits(int n) {
        if(n < 0) return  -1;
        else if(n == 0) return 1;

        int res [] = new int [n+1];
        int f [] = new int [n+1];
        f[0] = 1;
        res[0] = 1;

        for(int i = 1; i<= Math.min(n,10); i++){
            f[i] =  (i==1) ? 9: f[i-1] * (11-i);
            res[i] = res[i-1] + f[i];
        }

        return (n > 10)? res[10]: res[n];
    }
}
