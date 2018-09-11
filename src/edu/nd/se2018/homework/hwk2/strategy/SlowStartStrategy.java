package edu.nd.se2018.homework.hwk2.strategy;

public class SlowStartStrategy implements Strategy {
	@Override
	public double useStrategy(double c, int ms) {
		
		if(c<=6) {
			return c+((ms*.75)/60.0);
		}
		else if(c<=9) {
			return c+((ms*.9)/60.0);
		}
		else {
			return c+(ms/60.0);
		}
	}
}
