package algorithm;

public class Leet670 {
    public static void main(String [] args){
        Leet670 test = new Leet670();
        System.out.println(test.maximumSwap(2736));
    }

    public int maximumSwap(int num){
        if(num < 0){
            return -1;
        }
        String numString = String.valueOf(num);
        if (numString.length() <= 1){
            return num;
        }
        char [] arr = numString.toCharArray();
        for(int i = 0; i< numString.length(); i++){
            int temp = Integer.MIN_VALUE; int index = -1;
            int digit1 = Integer.parseInt(numString.substring(i,i+1));
            int j = i+1;
            for(; j< numString.length(); j++){
                int digit2 = Integer.parseInt(numString.substring(j,j+1));
                if(digit1 < digit2 && temp <= digit2){
                    temp = Math.max(temp, digit2);
                    index = j;
                }
            }
            if(digit1 < temp){
                swap(arr, i, index);
                break;
            }
        }
        return Integer.parseInt(String.valueOf(arr));
    }

    private void swap(char[] arr, int i, int j ){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
