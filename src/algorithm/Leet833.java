package algorithm;

public class Leet833 {
    public static void main(String[] args){
        String S ="ejvzndtzncrelhedwlwiqgdbdgctgubzczgtovufncicjlwsmfdcrqeaghuevyexqdhffikvecuazrelofjmyjjznnjdkimbklrh";
        int[] indexs = {25,35,60,77,69,79,15,19,58,92,27,64,4,11,51,7,72,67,30,0,74,98,17,85,48,32,38,62,43,2,9,55,87};
        String [] sources = new String[]{"gc","tov","vy","re","ikv","lo","dw","iqgdbd","ue","kimbk","tgu","qd","ndt","elhe","crq","zn","ec","ff","bz","ej","ua","rh","lw","jj","mfd","cz","ufn","ex","cjl","vz","cr","agh","znnj"};
        String [] targets = new String[]{"dxs","hn","vfc","wnr","tira","rko","oob","mlitiwj","zrj","onpp","ot","c","lm","hbsje","dgc","ruf","qi","h","vzn","ja","ow","te","km","imq","pia","ixp","xsod","m","eat","yf","lzu","dgy","dyrsc"};
        Leet833 test = new Leet833();
        System.out.println(test.findReplaceString(S,indexs,sources,targets));
    }

    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        if(S == null || S.isEmpty()){
            return S;
        }
        StringBuilder sb = new StringBuilder(S);
        int [] indexesCopy = indexes.clone();
        int curIndex = -1;
        String sourceStr = "";
        String targetStr = "";
        for(int i = 0; i < indexes.length; i++){
            curIndex = indexes[i];
            sourceStr = sources[i];
            targetStr = targets[i];
            if(sourceStr.equals(S.substring(curIndex,curIndex + sourceStr.length()))){
                sb.replace(indexesCopy[i], indexesCopy[i]+sourceStr.length(), targetStr);
                if(sourceStr.length() == targetStr.length()){
                    continue;
                }
                else {
                    for(int j = i+1; j< indexes.length; j++){
                        if(indexesCopy[j] >= indexesCopy[i]) {
                            indexesCopy[j] += targetStr.length() - sourceStr.length();
                        }
                    }
                }

            }
        }
        return sb.toString();
    }
}
