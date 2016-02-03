package day_13;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 03/02/2016
 */
class Permutation implements Comparable{

	final List<String> permutation;
	final int happiness;

	Permutation(List<String> permutation) {
		this.permutation = permutation;
		this.happiness = calcHappiness();
	}

	private int calcHappiness() {
		Optional<OrderElem> optRule;
		int sumHappiness = 0;

		// sum all gains/loses in permutation except for the last one in both directions
		for (int i = 0; i < permutation.size() - 1; i++) {
			optRule = searchOrderElem(permutation.get(i), permutation.get(i + 1));
			sumHappiness += optRule.get().gainLose;
		}
		for (int i = permutation.size() - 1; i > 0; i--) {
			optRule = searchOrderElem(permutation.get(i), permutation.get(i - 1));
			sumHappiness += optRule.get().gainLose;
		}

		// add the last gain/lose to the sum in both directions
		optRule = searchOrderElem(permutation.get(permutation.size() - 1), permutation.get(0));
		sumHappiness += optRule.get().gainLose;
		optRule = searchOrderElem(permutation.get(0), permutation.get(permutation.size() - 1));
		sumHappiness += optRule.get().gainLose;
		
		return sumHappiness;
	}

	private static Optional<OrderElem> searchOrderElem(
			String who,
			String nextTo) {
		return Day13.rules.stream()
				.filter(rule -> (rule.who.equals(who)
						&& rule.nextTo.equals(nextTo)))
				.findFirst();
	}
	
	static void getAllPerms() {
		List<String> firstPerm = new LinkedList<>();

		Day13.names.stream().forEach(name -> firstPerm.add(name));
		
		// it is much faster to fix the first name and make permutations from the rest
		// otherwise there would be unnecessarily plenty of them
		permutation(firstPerm, 1, firstPerm.size() - 1);
	}
	
	static int getMax(){
		int max = 0;
		for (Permutation perm : Day13.allPerms) {
			if (perm.happiness > max){
				max = perm.happiness;
			}
		}
		return max;
	}

	private static void permutation(
			List<String> nodes,
			int begin,
			int end) {
		if (begin == end) {
			List<String> perm = new ArrayList<>();
			perm.addAll(nodes);
			Day13.allPerms.add(new Permutation(perm));
		} else {
			for (int i = begin; i <= end; i++) {
				swap(nodes, i, begin);
				permutation(nodes, begin + 1, end);
				swap(nodes, i, begin);
			}
		}
	}
	
	private static void swap(List<String> nodes, int first, int second) {
		String aux = nodes.get(first);
		nodes.set(first, nodes.get(second));
		nodes.set(second, aux);
	}

	@Override
	public String toString() {
		return "Permutation{" + "permutation=" + permutation + ", happiness=" + happiness + '}';
	}

	@Override
	public int compareTo(Object o) {
		return this.happiness - ((Permutation) o).happiness;
	}
	
}
