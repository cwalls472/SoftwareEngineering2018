package edu.nd.se2018.homework.hwk2;

//import org.junit.Test;

import org.junit.jupiter.api.Test;
import edu.nd.se2018.homework.hwk2.strategy.*;

class Test1 {

	@Test
	public void test() {
		Race race = new Race();
		race.enrollHorse("Jim",0,21,new EarlySprintStrategy());
		race.enrollHorse("Tom",1,24,new SlowStartStrategy());
		race.enrollHorse("Billy",2,25,new EarlySprintStrategy());
		race.enrollHorse("Racer",3,25,new SlowStartStrategy());
		race.enrollHorse("Spinner",4,25,new SteadyRunStrategy());
		race.startRace();
		assert(race.winner=="Racer");
	}

}
