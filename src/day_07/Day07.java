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
    static final String INPUT_FILE = "input.txt";

    @Override // 23753, 956, 14146, 31185, 29904, 14742?
    public void run() throws Exception {
        Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
        Circuit circuit = new Circuit();
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            String line;
            int lineNumber = 0;
            LineParser lineParser;

            while ((line = reader.readLine()) != null) {
                lineParser = new LineParser(line, circuit);
                lineParser.parse();
//                circuit.run();
            }

//            circuit.reset();
//            for (int j = 0; j < 100; j++) {
//                for (int i = 0; i < j; i++) {
//                    circuit.run();
//                    System.out.println(j + ".");
//                    circuit.printWires();
//                }
//            }

            circuit.printWires();
            circuit.printGates();
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

}
