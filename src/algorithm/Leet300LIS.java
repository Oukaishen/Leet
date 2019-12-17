package algorithm;



public class Leet300LIS {

    public static void main(String [] args){
        int[] input = new int[]{1,3,6,7,9,4,10,5,6};
        Leet300LIS test = new Leet300LIS();
        int res = test.lengthOfLIS2(input);
        System.out.println(res);
    }

    //时间度是o（N2）的算法
    //dp[i] 代表的是nums[0....i]的最长递增序列的长度
    public int lengthOfLIS(int[] nums) {
        if(nums ==null || nums.length == 0)
            return 0;
        int [] dp = new int[nums.length];
        dp[0] = 1;

        for(int i = 1; i<nums.length;i++){
            int count = 1;
            for(int j = 0; j < i ; j++){
                if(nums[i] > nums[j]){
                    count = Math.max(count, dp[j]+1);
                }
            }
            dp[i] = count;
        }
        return dp[nums.length -1 ];
    }

    //时间度是O(nlogn)的解法
    //end[0..right]是有效区域
    //end[b]=c, 表示历遍到目前为止，在所有长度为b+1的递增序列中，最小的结尾数是c
    //end[0]=10,表示历遍到目前为止，长度为1的递增序列中，最小的结尾数字是10
    public int lengthOfLIS2(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int res = 1;
        int [] ends = new int[nums.length];
        int [] dp = new int[nums.length];
        ends[0] = nums[0]; dp[0] = 1;
        int right = 0;
        int low = 0;
        int high = 0;
        int mid = 0;
        for(int i =1; i < nums.length; i++){
            //二分法找到有效区域里面最左边大于arr[i]的数字
            low = 0;
            high = right;
            while(low <= high){
                mid = (low+high)/2;
                if(nums[i] > ends[mid]){
                    low = mid + 1;
                }
                else{
                    high = mid -1 ;
                }
            }
            right = Math.max(right, low);
            ends[low] = nums[i];
            dp[i] = low +1;
            res = Math.max(res,dp[i]);
        }

        return res;
    }
}
