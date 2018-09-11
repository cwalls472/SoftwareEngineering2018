package edu.nd.se2018.homework.hwk2.strategy;

public class SteadyRunStrategy implements Strategy{
	@Override
	public double useStrategy(double c, int ms) {
		return c+((ms*.8)/60.0);
	}
}
