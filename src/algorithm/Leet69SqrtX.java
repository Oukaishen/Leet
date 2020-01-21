package algorithm;

public class Leet69SqrtX {
    public int mySqrt(int x) {
        long r = x;
        while(r*r > x){
            r = x/2/r + r/2;
        }
        return (int)r;
    }
}
