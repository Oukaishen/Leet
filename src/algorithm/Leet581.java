package algorithm;

import java.util.Stack;

public class Leet581 {
  public static void main(String [] args){
    int [] input = new int[]{2, 6, 4, 8, 10, 9, 15};
    Leet581 test = new Leet581();
    System.out.println(test.findUnsortedSubarray(input));
  }

  public int findUnsortedSubarray(int[] nums) {
    if(nums == null || nums.length ==0 )
      return 0;

    /**
     * 自己不会，官方的用堆栈的解法,重点如下：
     */
    Stack<Integer> stack = new Stack();
    int l = Integer.MAX_VALUE , r = Integer.MIN_VALUE;

    for(int i =0; i < nums.length; i++){
      while(!stack.isEmpty() && nums[stack.peek()] > nums[i])
        l = Math.min(l, stack.pop());
//        stack.pop();
//      l = stack.isEmpty()? 0: Math.min(stack.peek(),l);
      stack.push(i);
    }

    stack.clear();

    for(int i = nums.length -1; i >= 0; i--){
      while(!stack.isEmpty() && nums[stack.peek()] < nums[i])
        r = Math.max(r, stack.pop());
//        stack.pop();
//      r = stack.isEmpty()? nums.length-1 : Math.max(stack.peek(),r);
      stack.push(i);
    }

    return r > l? r - l + 1:0;

  }
}
