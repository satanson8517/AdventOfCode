package day_10;

import adventofcode.Day;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 02/02/2016
 */
public class Day10 implements Day {

	@Override
	public void run() throws Exception {
		final int ITERATIONS = 50;
		String input = "3113322113",
				output = "";

		for (int i = 0; i < ITERATIONS; i++) {
			output = translate(input);
			System.out.println(i + 1 + ". " + output.length());
			input = output;
		}
//		System.out.println(output);
	}

	private String translate(String input) {
		final char[] inputArr = input.toCharArray();
		StringBuilder output = new StringBuilder();

		// initialize on the first element in the array
		int count = 1;
		char c = inputArr[0];

		// continue with the second element
		for (int i = 1; i < inputArr.length; i++) {
			if (inputArr[i] != c) {
				output.append(count).append(c);
				c = inputArr[i];
				count = 1;
			} else {
				count++;
			}
		}
		output.append(count).append(c);

		return output.toString();
	}
}
