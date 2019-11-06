package algorithm;


import java.util.BitSet;

public class Leet263 {

    public boolean isUgly(int num) {

        if(num <= 0) return false;
        else if( num == 1 ) return true;

        while (num % 2 == 0 ) num >>= 1;
        while (num % 3 == 0) num /= 3;
        while (num % 5 == 0) num /= 5;

        return num == 1;

    }
}
