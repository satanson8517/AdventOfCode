package adventofcode;

import day_14.Day14;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com>
 */
public class AdventOfCode {

	public static final String VAR_PATH = "./var";

	public static void main(String[] args) {
		try {
			Day day = new Day14();
			day.run();
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

}
