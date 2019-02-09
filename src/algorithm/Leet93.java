package algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Leet93 {
    public static void main(String[] args){
        Leet93 test = new Leet93();
        String input = "19216811";
        System.out.println(test.restoreIpAddress(input));
    }

    int minDigit;
    public List<String> restoreIpAddress(String s){
        Set<String> temp = new HashSet<>();
        List<String> res = new ArrayList<>();
        if(s == null || s.isEmpty()) {
            return res;
        }
        minDigit = 1;
        dfs(temp, "",  s);
        for ( String ip: temp){
            if(ip.split("\\.").length == 4){
                res.add(ip);
            }
        }
        return res;
    }

    public void dfs(Set<String> res, String prefix, String s){
        if(prefix.split("\\.").length > 5){
            return;
        }
        if(s.isEmpty()){
            res.add(prefix.substring(1));
            return;
        }
        for(int i = minDigit; i <= 3 && i<=s.length(); i++){
            String number = s.substring(0, i);
            if(number.startsWith("0") && number.length() >1 ){
                return;
            }
            if( Integer.parseInt(number) > 255 || Integer.parseInt(number) < 0 ){
                return;
            }
            String newPrefix = prefix + "." + number;
            dfs(res, newPrefix, s.substring(i));
        }
    }
}
