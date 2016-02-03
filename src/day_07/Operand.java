package day_07;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 17/12/2015
 */
class Operand {

	final String value;

	public Operand(String value) {
		this.value = value;
	}

	boolean isNumber() {
		return value.matches("\\d*");
	}

	int toInt() {
		return Integer.parseInt(value);
	}

}
