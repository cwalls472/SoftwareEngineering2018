package edu.nd.se2018.homework.hwk1;
import java.util.*;


public class Question1 {
		
	public Question1(){}
	
	public int getSumWithoutDuplicates(int[] numbers){
		int total=0;
		HashSet<Integer> hNumbers = new HashSet<Integer>();
		for (int num : numbers) {
			hNumbers.add(num);
		}
		Iterator<Integer> i = hNumbers.iterator();
		while(i.hasNext())	{
			total=total+i.next();
		}
		return total;
	}
}
