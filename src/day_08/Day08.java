package day_08;

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
 * @author Michal Nedbálek
 */
public class Day08 implements Day {

    static final String DAY_PATH = "day_08";
    static final String INPUT_FILE = "input.txt";

    @Override
    public void run() throws Exception {
        Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            while ((line = reader.readLine()) != null) {
                
                
            }
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }
}
