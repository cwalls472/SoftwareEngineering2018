package edu.nd.se2018.homework.hwk2;
import edu.nd.se2018.homework.hwk2.strategy.*;

public class Horse {
	public int number;
	public String name;
	public int maxSpeed;
	public Strategy strategy;
	public double curpos;
	
	public Horse(String n, int num, int ms, Strategy s) {
		name = n;
		number = num;
		maxSpeed = ms;
		strategy = s;
		curpos = 0;
	}
	
	public void run() {
		curpos = strategy.useStrategy(curpos, maxSpeed);
	}
	
	public double getpos() {
		return curpos;
	}
	
	public void changeStrategy(Strategy s) {
		strategy = s;
	}
	
}
