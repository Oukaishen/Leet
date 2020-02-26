package algorithm;

import java.util.ArrayList;
import java.util.Random;

public class Interview20190221 {
  public static void main(String [] args){
    System.out.println(count0(10010));
  }


  public static int[] shuffle(int [] cards){
    if(cards == null || cards.length != 52){
      return null;
    }
    Random rand = new Random();
    for(int i = 51; i > 1; i--){
      while (cards[i] == i){
        int nextIndex = rand.nextInt(i);
        int temp = cards[nextIndex];
        cards[nextIndex] = cards[i];
        cards[i] = temp;
      }
    }
    return cards;
  }

  public static int findDuplicate(int [] nums){
    if(nums == null || nums.length <= 0){
      return -1;
    }
    for(int i = 0; i < nums.length; i++){
      while( nums[i] != i){
        if(nums[i] == nums[nums[i]]){
          return nums[i];
        }
        int temp = nums[i];
        nums[i] = nums[nums[i]];
        nums[nums[i]] = temp;
      }
    }
    // shuould here
    return -1;
  }

  public static boolean isMirrored(int num){
    int reverse = 0; int temp = num;
    while(temp > 0){
      reverse = reverse * 10 + temp % 10;
      temp = temp /10;
    }
    return reverse == num;
  }

  public static int count0(int num){
    if(num == 0)
      return 1;
    int count = 0;
    while(num != 0) {
      if( num %10 == 0)
        count++;
      num /= 10;
    }
    return count;
  }

  static int res = 0;
  public static void findPathForTarget(TreeNode node, int target){
    if(node == null)
    {
      return;
    }
    target -= node.val;
    if(target == 0 && node.left == null && node.right == null){
      res = 1;
    }
    else {
      findPathForTarget(node.left, target);
      findPathForTarget(node.right, target);
    }
  }
  public static int find(TreeNode node, int target){
    findPathForTarget(node, target);
    return res;
  }
}