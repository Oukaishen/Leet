package algorithm;

public class Leet493ReversePair {

    public static void main(String [] args) {
        int [] input = new int[]{5,5,-5,-5,-5,5};
        Leet493ReversePair test = new Leet493ReversePair();
        System.out.println(test.reversePairs(input));
    }


    /**
     * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j]
     * @param nums
     * @return
     */
    // 尝试自己做归并排序
    public int reversePairs(int[] nums) {

        int res = 0;

        if(nums == null || nums.length == 0 )
            return res;

        auxArray = new int[nums.length];
        res = mergeSort(nums, 0, nums.length - 1, 0);

        return  res;
    }

    int [] auxArray;
    // 归并排序
    public int mergeSort(int [] nums, int start, int end, int tmpRes ){
        if( start >= end ){
            return tmpRes;
        }

        //先分别sort,然后再merge
        int mid = (start + end) / 2;
        int left = mergeSort(nums, start, mid, tmpRes);
        int right = mergeSort(nums, mid +1 , end, tmpRes);
        int res = merge(nums, start, end, mid, left + right);
        return res;
    }

    public int merge(int [] nums, int start, int end, int mid, int tmpRes){
        int i = mid, j = end;
        for(int k = start; k <= end; k++){
            auxArray[k] = nums[k];
        }

        for(int k =  end; k >= start; k--){
            if(j <= mid) nums[k] = auxArray[i--];
            else if(i < start) nums[k] = auxArray[j--];
            else if(auxArray[i] > auxArray[j]){
                if(auxArray[i] > 2 * auxArray[j])
                    tmpRes += ( j - (mid +1 ) + 1);
                else {
                    for(int tmp = j; tmp > mid; tmp--){
                        if(auxArray[i] >2 * auxArray[tmp]){
                            tmpRes += ( tmp - (mid +1 ) + 1);
                            break;
                        }
                    }
                }
//                if(tmpRes >= 1000000007)
//                    tmpRes %= 1000000007;
                nums[k] = auxArray[i--];
            }
            else{
                if(auxArray[i]/2  >  auxArray[j])
                    tmpRes += ( j - (mid +1 ) + 1);
                nums[k] = auxArray[j--];
            }
        }
        return tmpRes;
    }
}
