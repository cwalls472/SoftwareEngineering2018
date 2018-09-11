package edu.nd.se2018.homework.hwk2;
import java.util.*;
import edu.nd.se2018.homework.hwk2.Horse;
import edu.nd.se2018.homework.hwk2.strategy.*;

public class Race {
	ArrayList<Horse> horseArray = new ArrayList<Horse>();
	int horseAmount = 0;
	String winner;
	Boolean cont = true;
	int counter=0;
	
	public Race() {}
	
	public void enrollHorse(String n, int num, int ms, Strategy s) {
		horseArray.add(new Horse(n,num,ms,s));
	}
	
	public void changeStrategy(int num, Strategy s) {
		horseArray.get(num).changeStrategy(s);
	}
	
	public void startRace() {
		while (cont) {
			if (counter == 5) {
				for (int i=0;i<horseArray.size();i++) {
					System.out.println(horseArray.get(i).name + " has run " + horseArray.get(i).curpos);
					counter=0;

				}
			}
			for (int i=0;i<horseArray.size();i++) {
				horseArray.get(i).run();
				if (horseArray.get(i).getpos()>=10) {
					winner = horseArray.get(i).name;
					cont = false;
					break;
				}
			}
			counter++;
		}
		System.out.println("The winner is " + winner);
	}
}
