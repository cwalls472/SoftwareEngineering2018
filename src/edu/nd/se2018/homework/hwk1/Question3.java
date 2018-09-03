package edu.nd.se2018.homework.hwk1;
public class Question3 {
	
	public Question3(){}	
	
    public int getMirrorCount(int[] numbers){
    	int[] mirrorNumbers = new int[numbers.length];
    	for (int i = numbers.length - 1;i>=0; i--) {
    		mirrorNumbers[numbers.length -1 -i] = numbers[i];
    	}
    	int longestSeq = 0;
    	int currentSeq = 0;
    	for (int i = numbers.length - 1;i>=0; i--) {
    		if(numbers[i]==mirrorNumbers[i]) {
    			currentSeq++;
    		}
    		else {
    			if (longestSeq<currentSeq) {
    				longestSeq=currentSeq;
    			}
    			currentSeq=0;
    		}
    	}
    	if (longestSeq<currentSeq) {
			longestSeq=currentSeq;
		}
		return longestSeq;	
	}
}
