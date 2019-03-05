package algorithm;

public class Leet696 {
    public static void main(String[] args){
        Leet696 test = new Leet696();
        String s = "00110011";
        System.out.println(test.countBinarySubstrings(s));
    }

    public int countBinarySubstrings(String s) {
        int res = 0;
        if(s == null || s.isEmpty() || s.length() <= 1){
            return res;
        }
        for(int begin = 0; begin < s.length() - 1; begin++){
            int end = begin + 1;
            int cnt = 1;
            char left = s.charAt(begin);
            boolean alreadyTurn = false;
            while(end < s.length()){
                char cur = s.charAt(end);
                if(cur == left){
                    if(alreadyTurn){
                        break;
                    }
                    cnt++;
                }
                else{
                    if(!alreadyTurn){
                        alreadyTurn = true;
                    }
                    cnt--;
                    if(cnt == 0){
                        res++;
                        break;
                    }
                }
                end++;
            }
        }
        return res;
    }
}
