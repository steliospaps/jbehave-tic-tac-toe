package net.ddns.papasv.tic.tac.toe.engine;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

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
	@Test public void draw() {
		assertThat(engine.evaluate("532891467"), equalTo(Result.DRAW));
	}
	@Test public void Awin() {
		assertThat(engine.evaluate("14253"), equalTo(Result.A_WINS));
		assertThat(engine.evaluate("41526"), equalTo(Result.A_WINS));
		assertThat(engine.evaluate("71829"), equalTo(Result.A_WINS));
		assertThat(engine.evaluate("12437"), equalTo(Result.A_WINS));
		assertThat(engine.evaluate("21538"), equalTo(Result.A_WINS));
		assertThat(engine.evaluate("31629"), equalTo(Result.A_WINS));
		assertThat(engine.evaluate("12539"), equalTo(Result.A_WINS));
		assertThat(engine.evaluate("31527"), equalTo(Result.A_WINS));	
	}
	@Test public void bwin() {
		assertThat(engine.evaluate("914253"), equalTo(Result.B_WINS));
		assertThat(engine.evaluate("941526"), equalTo(Result.B_WINS));
		assertThat(engine.evaluate("471829"), equalTo(Result.B_WINS));
		assertThat(engine.evaluate("912437"), equalTo(Result.B_WINS));
		assertThat(engine.evaluate("921538"), equalTo(Result.B_WINS));
		assertThat(engine.evaluate("431629"), equalTo(Result.B_WINS));
		assertThat(engine.evaluate("412539"), equalTo(Result.B_WINS));
		assertThat(engine.evaluate("431527"), equalTo(Result.B_WINS));	
	}
	

}
