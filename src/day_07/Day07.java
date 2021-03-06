package day_07;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
public class Day07 implements Day {

	static final String DAY_PATH = "day_07";
	// input for the first star: input01.txt
	// input for the first star: input02.txt
	static final String INPUT_FILE = "input02.txt";

	// 40149 - the right answer for the second star after adding line "956 -> b" to input02.txt
	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
		Circuit circuit = new Circuit();
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			String line;
			LineParser lineParser;

			while ((line = reader.readLine()) != null) {
				lineParser = new LineParser(line, circuit);
				lineParser.parse();
			}

			circuit.run();
			circuit.printWires(w -> true); // print all lines

		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

}
