package adventofcode;

import day_15.Day15;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com>
 */
public class AdventOfCode {

	public static final String VAR_PATH = "./var";

	public static void main(String[] args) {
		try {
			Day day = new Day15();
			day.run();
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

}
