package net.ddns.papasv.tic.tac.toe.engine;

import java.util.HashSet;
import java.util.Set;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

public class Engine {

	/**
	 * 
	 * @param game a string with numbers 1-9 representing the movements. first move is first player, second is second etc.
	 * @return a result see {@link Result}
	 */
	public Result evaluate(String game) {
		game.codePoints()
			.map(a->toNumber(a))
			.sequential()
			.collect( () -> new Set[]{new HashSet<Integer>(),new HashSet<Integer>()},
					(r,i)->accumulate(r,i), 
					(a,b)->doThrow());
		return Result.NOT_FINISHED;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void accumulate(Set[] set, int i) {
		Set<Integer> a = set[0];
		Set<Integer> b = set[1];
		if(a.contains(i) || b.contains(i)){
			throw new RuntimeException("duplicate value "+i);
		}
		Set<Integer> active = a.size()>b.size()?b:a;
		active.add(i);
	}

	private Object doThrow() {
		throw new RuntimeException("I did not expect this to be called");
	}

	private int toNumber(int codePoint) {
		if(Character.isDigit(codePoint)){
			return Character.digit(codePoint, 10);
		}
		throw new RuntimeException("character is not a number "+codePoint+" "+Character.toTitleCase(codePoint));
	}

}
