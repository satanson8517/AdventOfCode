package day_11;

import adventofcode.Day;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 02/02/2016
 */
public class Day11 implements Day {

	@Override
	public void run() throws Exception {
		final String input = "vzbxxyzz"; // vzcaabcc
//		final String input = "vzbxkghb"; // vzbxxyzz
//		final String input = "ghijklmn"; // ghjaabcc
//		final String input = "abcdefgh"; // abcdffaa
		char[] inputArr = input.toCharArray();
		boolean rulesMet = false;

		while (!rulesMet) {
			incrementArray(inputArr, inputArr.length - 1);
			rulesMet = rules(inputArr);
		}
		System.out.println(inputArr);
	}

	private boolean rules(char[] arr) {
		boolean firstRule = false,
				secondRule = true,
				thirdRule = false;

		// second rule
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'i'
					|| arr[i] == 'o'
					|| arr[i] == 'l') {
				secondRule = false;
				break;
			}
		}

		// not necessary to continue
		if (!secondRule) {
			return false;
		}

		// first rule
		for (int i = 0; i < arr.length - 2; i++) {
			if ((arr[i] == arr[i + 1] - 1)
					&& (arr[i + 1] == arr[i + 2] - 1)) {
				firstRule = true;
				break;
			}
		}

		// not necessary to continue
		if (!firstRule) {
			return false;
		}

		// third rule
		for (int i = 0; i < arr.length - 3; i++) {
			if (arr[i] == arr[i + 1]) {
				for (int j = i + 2; j < arr.length - 1; j++) {
					if (arr[j] == arr[j + 1]) {
						thirdRule = true;
					}
				}
			}
		}

		return firstRule && secondRule && thirdRule;
	}

	/**
	 * Increments array at given position.
	 *
	 * @param arr
	 * @param pos
	 */
	private void incrementArray(char[] arr, int pos) {
		if (arr[pos] == 'z') {
			arr[pos] = 'a';
			incrementArray(arr, pos - 1);
		} else {
			arr[pos] = (char) (arr[pos] + 1);
		}
	}
}
