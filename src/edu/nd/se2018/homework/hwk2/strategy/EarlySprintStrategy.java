package edu.nd.se2018.homework.hwk2.strategy;

public class EarlySprintStrategy implements Strategy {
	@Override
	public double useStrategy(double c, int ms) {
		System.out.println("Usin dat yung early sprint");
		if(c<=2) {
			System.out.println("c<=2, c=" + c + " ms="+ms);
			return c+(ms/60.0);
		}
		else {
			return c+((ms*.75)/60.0);
		}
	}
}
