package algorithm;

public class Leet769 {
    public static void main(String[] args){
        Leet769 test = new Leet769();
        int [] input = {1,2,0,3};
        System.out.println(test.maxChunksToSorted(input));
    }
    public int maxChunksToSorted(int[] arr) {
        int res = 0; int curMax = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            curMax = Math.max(curMax, arr[i]);
            if( curMax == i){
                res++;
            }
        }
        return res;
    }
}
