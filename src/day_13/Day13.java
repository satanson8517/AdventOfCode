package day_13;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 03/02/2016
 */
public class Day13 implements Day {

	static final String DAY_PATH = "day_13";
	static final String INPUT_FILE = "input.txt";
	static Set<Permutation> allPerms = new HashSet<>();
	static Set<String> names = new HashSet<>();
	static Set<OrderElem> rules = new HashSet<>();

	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE)
				.toRealPath(LinkOption.NOFOLLOW_LINKS);
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			rules = parseInput(reader);
			names = getAllNames();
			Permutation.getAllPerms();

			allPerms.stream().sorted().forEach(perm -> System.out.println(perm));
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

	private Set<String> getAllNames() {
		rules.stream()
				.filter((rule) -> (!names.contains(rule.who)))
				.forEach((rule) -> {
					names.add(rule.who);
				});

		return names;
	}

	private Set<OrderElem> parseInput(BufferedReader reader) throws IOException {
		ParseLine parser;
		OrderElem orderElem;
		String line;
		while ((line = reader.readLine()) != null) {
			parser = new ParseLine(line);
			orderElem = parser.parse();
			rules.add(orderElem);
		}

		return rules;
	}

}
