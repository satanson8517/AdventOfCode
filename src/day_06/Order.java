package day_06;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
class Order {

	private Verb verb;
	private Position min;
	private Position max;

	Order() {
	}

	Verb getVerb() {
		return verb;
	}

	void setVerb(Verb verb) {
		this.verb = verb;
	}

	Position getMin() {
		return min;
	}

	void setMin(Position min) {
		this.min = min;
	}

	Position getMax() {
		return max;
	}

	void setMax(Position max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "Order{" + "verb=" + verb + ", min=" + min + ", max=" + max + '}';
	}

}
