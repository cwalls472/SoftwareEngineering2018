package edu.nd.se2018.homework.hwk1;
import java.util.*;

public class Question2 {

	public Question2(){}
	
	public String getMostFrequentWord(String input, String stopwords){
		String[] words = input.split(" ");
		HashMap<String,Integer> hWords = new HashMap<String,Integer>();
		for (String word : words) {
			if (hWords.containsKey(word)) {
				hWords.put(word,hWords.get(word)+1);
			}
			else {
			hWords.put(word,1);
			}
		}
		System.out.println(hWords);
		String[] stopWords = stopwords.split(" ");
		for (String word : stopWords) {
			hWords.remove(word);
		}
		System.out.println(hWords);
		int maxVal = Collections.max(hWords.values());
		String maxWord = "";
		int counter = 0;
		for (String word : hWords.keySet()) {
			if (hWords.get(word).equals(maxVal)) {
				counter++;
				maxWord = word;
			}
		}
		if (counter > 1) {
			return null;
		}
		return maxWord;
	}
}
