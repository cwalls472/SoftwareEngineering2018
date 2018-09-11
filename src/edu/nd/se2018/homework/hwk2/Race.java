package edu.nd.se2018.homework.hwk2;
import java.util.*;
import edu.nd.se2018.homework.hwk2.Horse;
import edu.nd.se2018.homework.hwk2.strategy.*;

public class Race {
	ArrayList<Horse> horseArray = new ArrayList<Horse>();
	int horseAmount = 0;
	String winner;
	Boolean cont = true;
	
	public Race() {}
	
	public void enrollHorse(String n, int num, int ms, Strategy s) {
		horseArray.add(new Horse(n,num,ms,s));
	}
	
	public void startRace() {
		System.out.println(horseArray.size());
		System.out.println(horseArray.get(0).name);
		System.out.println(horseArray.get(0).maxSpeed);
		while (cont) {
			for (int i=0;i<horseArray.size();i++) {
				horseArray.get(i).run();
				if (horseArray.get(i).getpos()>=10) {
					winner = horseArray.get(i).name;
					cont = false;
					break;
				}
			}
		}
		System.out.println("The winner is " + winner);
	}
}
