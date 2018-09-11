package edu.nd.se2018.homework.hwk2;

//import org.junit.Test;

import org.junit.jupiter.api.Test;
import edu.nd.se2018.homework.hwk2.strategy.*;

class Test3 {

	@Test
	public void test() {
		Race race = new Race();
		race.enrollHorse("Sam",0,15,new EarlySprintStrategy());
		race.enrollHorse("Molly",1,15,new EarlySprintStrategy());
		race.changeStrategy(1,new SlowStartStrategy());
		race.startRace();
	}

}
