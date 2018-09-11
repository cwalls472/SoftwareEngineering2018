package edu.nd.se2018.homework.hwk2;

//import org.junit.Test;

import org.junit.jupiter.api.Test;
import edu.nd.se2018.homework.hwk2.strategy.*;

class Test2 {

	@Test
	public void test() {
		Race race = new Race();
		race.enrollHorse("Racer",0,22,new EarlySprintStrategy());
		race.enrollHorse("Jack",1,25,new SlowStartStrategy());
		race.enrollHorse("Blizzard",2,25,new SlowStartStrategy());
		race.startRace();
	}

}
