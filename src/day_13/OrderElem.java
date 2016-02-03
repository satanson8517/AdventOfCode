package day_13;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 03/02/2016
 */
class OrderElem {
	
	final String who;
	final String nextTo;
	final int gainLose;

	OrderElem(String who, String nextTo, int gainLose) {
		this.who = who;
		this.nextTo = nextTo;
		this.gainLose = gainLose;
	}

	@Override
	public String toString() {
		return "OrderElem{" + "who=" + who + ", nextTo=" + nextTo + ", gainLose=" + gainLose + '}';
	}
	
}
