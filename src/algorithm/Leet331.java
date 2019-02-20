package algorithm;

import java.util.Stack;

public class Leet331 {

    public static void main(String[] args){
        Leet331 test = new Leet331();
        String preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(test.isValidSerialization2(preorder));
    }

    /**
     * Key idea is to substitute the valid leaves node to a "#".
     * after the left node is okay, use a "#" to replace the whole tree.
     * */
    public boolean isValidSerialization(String preorder) {

        if( preorder == null || preorder.isEmpty()){
            return false;
        }
        Stack<String> layers = new Stack<>();
        String [] arr = preorder.split(",");
        for(int i = 0; i < arr.length; i++){
            String str = arr[i];
            while("#".equals(str) && !layers.isEmpty() && "#".equals(layers.peek())){
                layers.pop();
                if(layers.isEmpty()){
                    return false;
                }
                layers.pop();
            }
            layers.push(str);
        }
        return layers.size() == 1 && "#".equals(layers.peek());
    }


    /**
     * Key idea is use the out degree and in degree
     * */
    public boolean isValidSerialization2(String preorder){
        /**
         * for every non-null node, it will provide 2 out degree and 1 in degree
         * for every null node, it will provide 0 out degree and 1 in degree
         * def ine diff = out - in, for null, diff decrease by 1,
         * for non-null node, diff increase by 1.
         */
        if(preorder == null || preorder.isEmpty()){
            return false;
        }
        int diff = 1;
        String [] arr = preorder.split(",");
        for(String str: arr){
            if("#".equals(str)){
                if(diff <= 0){
                    return false;
                }
                diff -=1;
            }
            else{
                if(diff <= 0){
                    return false;
                }
                diff +=1;
            }
        }
        return diff == 0;
    }

}
