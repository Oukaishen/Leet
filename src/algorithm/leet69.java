package algorithm;

/// newtown's method
public class leet69 {
public int mySqrt(int x) {
        long r = x;
        while(r*r > x){
        		r = (r+x/r)/2;
        }
        return (int) r;
    }
}
