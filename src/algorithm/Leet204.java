package algorithm;

public class Leet204 {
    public static void main(String[] args){
        Leet204 test = new Leet204();
        System.out.println(test.countPrimes(3));
    }
    public int countPrimes(int n){
        if(n <= 2){
            return 0;
        }
        int[] helper = new int[n];
        for(int i = 2; i <= Math.floor(Math.sqrt(n)); i++){
            int k = i;
            while(k*i < n){
                helper[k*i] = -1;
                k++;
            }
        }
        int res = 0;
        for(int i = 2; i<n; i++){
            if(helper[i] == 0) {
                res++;
            }
        }
        return res;
    }
}
