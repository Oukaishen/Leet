package algorithm;

import java.util.Stack;

public class leet394 {
	public static void main(String [] args){
		System.out.println(leet394.decodeString("1[a]2[c]"));
	}
public static String decodeString(String s) {
		// fuck his mom that there is something like 110[a], the number is not ensured to be one digit
		// not very concise, but it works -.-
       Stack<Integer> stack1 = new Stack<>();
       Stack<StringBuffer> stack2 = new Stack<>();
       char[] array = s.toCharArray();
       
       StringBuffer res = new StringBuffer();
       
       for(int i = 0; i < array.length; i++){
    	   		if( array[i] == '['){
    	   			int j = i;
    	   			while(j> 0 && Character.getNumericValue(array[j-1]) < 10 && Character.getNumericValue(array[j-1]) >= 0) j--;
    	   			
    	   			if(stack2.isEmpty())
//    	   				res.deleteCharAt(res.length()-1);
    	   				res.delete(res.length()-i+j, res.length());
    	   			else
    	   				{
    	   					StringBuffer temp = stack2.peek();
    	   					//temp.deleteCharAt(temp.length()-1);
    	   					temp.delete(temp.length()-i+j, temp.length());
    	   				}
    	   			int num = Integer.parseInt(s.substring(j,i));
    	   			stack1.push(num);
    	   			stack2.push(new StringBuffer());
    	   		}
    	   		else if( array[i] == ']'){
    	   			StringBuffer temp= stack2.pop();
    	   			int num = stack1.pop();
    	   			StringBuffer clone = new StringBuffer(temp);
    	   			for(int j = 1; j<num ;j++){
    	   				temp.append(clone);
    	   			}
    	   			if(!stack2.isEmpty()){
    	   				stack2.peek().append(temp);
    	   			}
    	   			else
    	   				res.append(temp);
    	   		}
    	   		else {
    	   			if(stack2.isEmpty())
    	   				res.append(array[i]);
    	   			else
    	   				stack2.peek().append(array[i]);
    	   		}
       }
       return res.toString();
    }


}
