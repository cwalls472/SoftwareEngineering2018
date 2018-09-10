package edu.nd.se2018.homework.hwk2;
import java.util.*;
import edu.nd.se2018.homework.hwk2.strategy.*;

public class Horse {
	public int number;
	public String name;
	public int maxSpeed;
	public Strategy strategy;
	public Horse(String n, int num, int ms, Strategy s) {
		name = n;
		number = num;
		maxSpeed = ms;
		strategy = s;
	}
}
