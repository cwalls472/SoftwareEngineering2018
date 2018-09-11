package edu.nd.se2018.homework.hwk2.strategy;

public class EarlySprintStrategy implements Strategy {
	@Override
	public double useStrategy(double c, int ms) {
		if(c<=2) {
			return c+(ms/60.0);
		}
		else {
			return c+((ms*.75)/60.0);
		}
	}
}
