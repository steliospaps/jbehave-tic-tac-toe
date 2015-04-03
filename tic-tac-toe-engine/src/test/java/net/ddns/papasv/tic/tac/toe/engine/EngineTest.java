package net.ddns.papasv.tic.tac.toe.engine;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EngineTest {

	private Engine engine;

	@Before
	public void setup(){
		engine = new Engine();
	}
	
	@Test(expected=RuntimeException.class)
	public void badInputShouldThrow() {
		engine.evaluate("foo");
	}

}
