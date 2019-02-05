package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 这一道题是我的独立解决的。很开心
 * **/
public class Leet241 {
    public static void main(String[] args){
        String input = "2-1-1";
        Leet241 test = new Leet241();
        System.out.print(test.diffWaysToCompute(input));
    }

    public List<Integer> diffWaysToCompute(String input){
        List<Integer> res = new ArrayList<>();
        if (input == null) {
            return res;}
        int numOperators = numOperator(input);
        if (numOperators == 0 ){
            res.add(Integer.parseInt(input));
            return res;
        }
        else if(numOperators == 1){
            res.add(computeSingle(input));
            return res;
        }
        else{
            int index;
            for(index = 0; index < input.length(); index++){
                if(input.charAt(index) == '+' || input.charAt(index) == '-' || input.charAt(index) == '*'){
                    String firstP = input.substring(0,index);
                    String secondP = input.substring(index+1);
                    List<Integer> res1 = diffWaysToCompute(firstP);
                    List<Integer> res2 = diffWaysToCompute(secondP);
                    List<Integer> combine = compute(res1, res2, input.charAt(index));
                    res.addAll(combine);
                 }
            }
            return res;
        }

    }

    private int numOperator(String input){
        int res = 0;
        if(input == null || input.isEmpty()){
            return res;
        }
        for(char c : input.toCharArray()){
            if('+' == c|| '-' == c || '*' == c){
                res++;
            }
        }
        return res;
    }

    private int computeSingle(String input){
        int index;
        char operator = '/';
        for(index = 0; index < input.length(); index ++){
            if(input.charAt(index) == '+' || input.charAt(index) == '-' || input.charAt(index) == '*'){
                operator = input.charAt(index);
                break;
            }
        }
        int firstNum = Integer.parseInt(input.substring(0,index));
        int seconNum = Integer.parseInt(input.substring(index+1));
        int res = -1;
        switch (operator){
            case '+': res = firstNum+seconNum; break;
            case '-': res =  firstNum-seconNum; break;
            case '*': res =  firstNum*seconNum; break;
        }
        return res;
    }

    private List<Integer> compute(List<Integer> res1, List<Integer> res2, char oper){
        if(res1 == null || res2 == null || res1.isEmpty() || res2.isEmpty()){
            return null;
        }
        List<Integer> res = new ArrayList<>();
        for(int num1: res1){
            for(int num2 : res2){
                switch (oper){
                    case '+': res.add(num1+num2); break;
                    case '-': res.add(num1-num2); break;
                    case '*': res.add(num1*num2); break;
                }
            }
        }
        return res;
    }
}
