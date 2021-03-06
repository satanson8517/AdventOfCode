package day_08;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Michal Nedbálek
 */
public class Day08 implements Day {

	static final String DAY_PATH = "day_08";
	static final String INPUT_FILE = "input.txt";

	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
		int lineNo = 0;
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			String l;
			int memChars = 0,
					textChars = 0;
			while ((l = reader.readLine()) != null) {
				lineNo++;
				Line line = new LineParser(l).parse02();
				memChars += line.memChars;
				textChars += line.textChars;
			}

			System.out.println("Memory: " + memChars);
			System.out.println("Plain text:" + textChars);
			System.out.println("Diff: " + (memChars - textChars));
//            System.out.println(textChars - memChars);
		} catch (Exception x) {
			System.err.format("%d, IOException: %s%n", lineNo, x);
		}
	}
}
