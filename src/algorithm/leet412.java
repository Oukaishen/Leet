package algorithm;

import java.util.ArrayList;
import java.util.List;

public class leet412 {
public List<String> fizzBuzz(int n) {
		List<String> res = new ArrayList<>(n);
        for(int i = 1; i<=n; i++){
        		if(i%15 == 0)
        			res.add("FizzBuzz");
        		else if(i%5 == 0)
        			res.add("Fizz");
        		else if(i%3 == 0)
        			res.add("Buzz");
        		else 
        			res.add(String.valueOf(i));
        }
        return res;
    }

// one more better solution
public List<String> fizzBuzz1(int n){
	List<String> res = new ArrayList<>(n);
	for(int i = 1, Fizz= 0, Buzz = 0; i<=n; i++){
		Fizz++;
		Buzz++;
		if(Buzz == 3 && Fizz == 5)
			{ Fizz = 0;
			  Buzz = 0;
			  res.add("FizzBuzz");}
		else if(Buzz == 3)
		{
			Buzz = 0;
			res.add("Buzz");
		}
		else if(Fizz == 5){
			Fizz = 0;
			res.add("Fizz");
		}
		else
			res.add(String.valueOf(i));
	}
	return res;
}
}
