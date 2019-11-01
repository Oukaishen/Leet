package algorithm;

public class Leet306 {
    public static void main(String [] args){
        String input = "112358";
        Leet306 obj = new Leet306();
        System.out.println(obj.isAdditiveNumber(input));
    }

    public boolean isAdditiveNumber(String num) {
        boolean res = false;
//        输入参数的校验
        if(num == null || num.isEmpty())
            return res;

        for(int i = 1; i<num.length()-1; i++){
            for(int j = i + 1; j<num.length(); j++){
                long first = parseNum(num.substring(0,i));
                long second = parseNum(num.substring(i,j));
                if(first == -1 || second == -1)
                    continue;
                if(dfs(num.substring(j), first, second))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(String num , long a, long b){
        if(num.length() == 0)
            return true;
        String target = String.valueOf(a+b);
        if(!num.startsWith(target) )
            return false;
        return dfs(num.substring(target.length()),b, a+b);
    }

    private long parseNum(String str){
        if(!str.equals("0") && str.startsWith("0"))
            return  -1;
      return  Long.parseLong(str);
    }

}
