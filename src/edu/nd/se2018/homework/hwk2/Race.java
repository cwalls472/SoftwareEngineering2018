package edu.nd.se2018.homework.hwk2;
import java.util.*;
import edu.nd.se2018.homework.hwk2.Horse;
import edu.nd.se2018.homework.hwk2.strategy.*;

public class Race {
	ArrayList<Horse> horseArray = new ArrayList<Horse>();
	int horseAmount = 0;
	
	public Race() {}
	
	public void enrollHorse(String n, int num, int ms, Strategy s) {
		horseArray.add(new Horse(n,num,ms,s));
	}
	
	public void startRace() {
		System.out.println(horseArray.size());
	}
}
