package day_14;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 03/02/2016
 */
public class Day14 implements Day {

	static final String DAY_PATH = "day_14";
	static final String INPUT_FILE = "input.txt";

	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE)
				.toRealPath(LinkOption.NOFOLLOW_LINKS);
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			final int DISTANCE = 2503;
			
			LineParser parser;
			Reindeer reindeer;
			String line;
			
			System.out.println("Time: " + DISTANCE + "\n");
			
			while((line = reader.readLine()) != null){
				reindeer = new LineParser(line).parse();
				System.out.println(reindeer.name + ": " + reindeer.distance(DISTANCE));
			}
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

}
