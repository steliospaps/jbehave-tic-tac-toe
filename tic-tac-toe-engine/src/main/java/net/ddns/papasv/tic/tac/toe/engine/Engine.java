package net.ddns.papasv.tic.tac.toe.engine;

import java.util.Arrays;
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
	@SuppressWarnings("unchecked")
	public Result evaluate(String game) {
		Set<Integer>[] res = game.codePoints()
			.map(a->toNumber(a))
			.sequential()
			.collect( () -> new Set[]{new HashSet<Integer>(),new HashSet<Integer>()},
					(r,i)->accumulate(r,i), 
					(a,b)->doThrow());
		if(isWinner(res[0])){
			return Result.A_WINS;
		}
		if(isWinner(res[1])){
			return Result.B_WINS;
		}
		if((res[0].size()+res[1].size())!=9){
			return Result.NOT_FINISHED;
		}
		return Result.DRAW;
	}

	private boolean isWinner(Set<Integer> set) {
		if(set.containsAll(Arrays.asList(1,2,3))){
			return true;
		}
		if(set.containsAll(Arrays.asList(4,5,6))){
			return true;
		}
		if(set.containsAll(Arrays.asList(7,8,9))){
			return true;
		}
		if(set.containsAll(Arrays.asList(1,4,7))){
			return true;
		}
		if(set.containsAll(Arrays.asList(2,5,8))){
			return true;
		}
		if(set.containsAll(Arrays.asList(3,6,9))){
			return true;
		}
		if(set.containsAll(Arrays.asList(1,5,9))){
			return true;
		}
		if(set.containsAll(Arrays.asList(3,5,7))){
			return true;
		}
		return false;
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
