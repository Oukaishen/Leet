package algorithm;

import java.util.Arrays;

public class leet165 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String version1 = "7.5.2.4", version2 = "7.5.3";
		System.out.println(Arrays.asList(version1.split("\\.")));
		System.out.println(new leet165().compareVersion(version1,version2));
		System.out.println(new leet165().compareVersion1(version1,version2));
	}
	
	public int compareVersion(String version1, String version2) {
       String [] v1 = version1.split("\\.");
       String [] v2 = version2.split("\\.");
       int length = Math.max(v1.length, v2.length);
       for(int i=0; i<length; i++){
    	   		int num1 = i< v1.length? Integer.parseInt(v1[i]):0;
    	   		int num2 = i< v2.length? Integer.parseInt(v2[i]):0;
    	   		if(num1 > num2)
    	   			return 1;
    	   		else if(num1 < num2)
    	   			return -1;
       }
       return 0;
    }
	
	
	public int compareVersion1(String version1, String version2) {
		
		int N = version1.length();
		int M = version2.length();
		
		int i=0, j=0;
		
		while(i < N || j < M){
			int num1 = 0, num2 = 0;
			while(i < N && Character.isDigit(version1.charAt(i))){
				num1 = num1*10 + version1.charAt(i) - '0';
				i++;
			}
			
			while(j < M && Character.isDigit(version2.charAt(j))){
				num2 = num2*10 + version2.charAt(j) - '0';
				j++;
			}
			
			if(num1 > num2) return 1;
			else if(num1 < num2) return -1;
			
			i++;
			j++;
		}
		
		
	    return 0;
	}
	
}
