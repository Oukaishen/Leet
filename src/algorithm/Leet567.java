package algorithm;

import java.util.HashSet;
import java.util.Set;

public class Leet567 {

    public static void main(String [] args){

    }
    public boolean checkInclusion(String s1, String s2) {
        /*
         * 思路2：将S1的字母统计出来放在hash中，对S2每个长度的字串判断。
         * 牛逼，实现出来了。
         * */
        if(s1.length() > s2.length()){return false;}
        int [] charArr = new int[26];
        for(int i = 0 ; i<26; i++){
            charArr[i] = 0;
        }
        for(int i = 0; i<s1.length(); i++){
            charArr[ s1.charAt(i) - 'a' ] += 1;
        }
        for(int i = 0; i <= s2.length() - s1.length(); i++){
            if(i == 0){
                for(int j =0 ; j< s1.length(); j++){
                    charArr[s2.charAt(j) - 'a'] -= 1;
                }
                if(checkArr(charArr)){
                    return true;
                }
            }
            else {
                charArr[s2.charAt(i-1) - 'a'] += 1;
                charArr[s2.charAt(i + s1.length() - 1) - 'a'] -=1;
                if(checkArr(charArr)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkArr(int [] a){
        for(int i = 0; i<a.length; i++){
            if(a[i] != 0){
                return false;
            }
        }
        return true;
    }

    Set<String> permute;
    public boolean checkInclusion1(String s1, String s2) {
        /*
        * 思路1：将S1的全排列找出来，然后存放在HASH中，对S2每个长度的字串判断命中。
        * 但是显然，这个思路出现了TLE
        * */
        permute = new HashSet<>();
        dfs("", s1);
        for(int i = 0; i <= s2.length() - s1.length(); i++){
            if(permute.contains(s2.substring(i,i+s1.length()))){
                return true;
            }
        }
        return false;
    }

    private void dfs(String prefix, String str){
        if(str.equals("")){
            permute.add(prefix);
        }
        for(int i = 0; i<str.length(); i++){
            String newPrefix = prefix + str.charAt(i);
            String newStr = str.substring(0,i) + str.substring(i+1);
            dfs(newPrefix, newStr);
        }
    }
}
