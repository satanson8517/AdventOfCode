package day_02;

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
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 15/12/2015
 */
public class Day02 implements Day {

	static final String DAY_PATH = "day_02";
	static final String INPUT_FILE = "input.txt";

	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			String line;
			int wrapper = 0, ribbon = 0;
			while ((line = reader.readLine()) != null) {
				Dimensions dims = parseLine(line);
				wrapper += dims.getWrapper();
				ribbon += dims.getRibbon();
			}
			System.out.println("Wrapper: " + wrapper);
			System.out.println("Ribbon: " + ribbon);
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

    private static Dimensions parseLine(String line){
		String[] dimensions = line.split("x");
		return new Dimensions(dimensions);
	}

}
