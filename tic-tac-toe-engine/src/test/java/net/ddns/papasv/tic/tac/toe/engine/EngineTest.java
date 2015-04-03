package net.ddns.papasv.tic.tac.toe.engine;

import static org.hamcrest.Matchers.equalTo;
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
	@Test(expected=RuntimeException.class)
	public void badInputShouldThrow1() {
		engine.evaluate("11");
	}
	@Test(expected=RuntimeException.class)
	public void badInputShouldThrow2() {
		engine.evaluate("121");
	}
	
	@Test public void incomplete_games() {
		assertThat(engine.evaluate("1"), equalTo(Result.NOT_FINISHED));
		assertThat(engine.evaluate("53289146"), equalTo(Result.NOT_FINISHED));
	}
	

}
