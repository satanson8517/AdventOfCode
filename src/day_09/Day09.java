package day_09;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 *
 * @author Michal Nedbálek
 */
public class Day09 implements Day {

    static final String DAY_PATH = "day_09";
    static final String INPUT_FILE = "input.txt";

    @Override
    public void run() throws IOException {
        Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			Date start = new Date();
			
            String line;
//			Graph graph = new ListGraph();
			Graph graph = new ArrayGraph();
			Edge edge;
            while ((line = reader.readLine()) != null) {
				edge = new ParseLine(line).parse();
				graph.addEdge(edge);
				graph.addNode(edge);
            }

			graph.initFinished();
			
			System.out.println("Minimal distance: " + graph.getMinPath());
			System.out.println("Maximal distance: " + graph.getMaxPath());
			
			System.out.println("Total time elapsed: " + (new Date().getTime() - start.getTime()));
			
        } catch (Exception ex) {
			ex.printStackTrace(System.out);
        }
    }
}
