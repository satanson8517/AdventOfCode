package day_15;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 04/02/2016
 */
public class Day15 implements Day {

	static final String DAY_PATH = "day_15";
	static final String INPUT_FILE = "input_test.txt";

	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE)
				.toRealPath(LinkOption.NOFOLLOW_LINKS);
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			List<int[]> ingreds = new ArrayList<>();
			String line;

			// init ingreds
			while ((line = reader.readLine()) != null) {
				ingreds.add(parse(line));
			}

			Combinations combs = new Combinations(ingreds);
			combs.evaluate();
//			Combinations.combosGen();

		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

	static int[] parse(String line) {
		String[] parsedProps = line.replaceFirst("\\w+:", "")
				.replaceAll(" [a-z]+ ", "").split(",");

		return new int[]{
			Integer.parseInt(parsedProps[0]),
			Integer.parseInt(parsedProps[1]),
			Integer.parseInt(parsedProps[2]),
			Integer.parseInt(parsedProps[3]),
			Integer.parseInt(parsedProps[4])};
	}

}
