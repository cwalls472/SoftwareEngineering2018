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
		//for (int i=0; i<hNumbers.size(); i++) {
		Iterator<Integer> i = hNumbers.iterator();
		while(i.hasNext())	{
			total=total+i.next();
			//System.out.println(total);
		}
		System.out.println(total);
		return total;
	}
}
