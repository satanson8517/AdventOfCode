package day_12;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 02/02/2016
 */
public class Day12 implements Day {

	static final String DAY_PATH = "day_12";
	static final String INPUT_FILE = "input.txt";
	int parseDepth = 0,
			sumInt = 0,
			reds = 0;

	// wrong answers - 86033, 107861, 54288
	// right 68466
	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
		try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
			String jsonString = reader.readLine();
			ObjectMapper mapper = new ObjectMapper();

			JsonNode rootNode = mapper.readTree(jsonString);

			parseObject(rootNode);

			System.out.println("Sum int: " + sumInt);
			System.out.println("Reds: " + reds);
		} catch (Exception ex) {
			ex.printStackTrace(System.out);
		}
	}

	private int parseObject(JsonNode node) {
		Iterator<Entry<String, JsonNode>> fieldsIterator = node.fields();

		int subTotal = 0;
		while (fieldsIterator.hasNext()) {
			Entry<String, JsonNode> field = fieldsIterator.next();
			JsonNode value = field.getValue();

			for (int i = 0; i < parseDepth; i++) {
				System.out.print("--");
			}
			System.out.print("Key: " + field.getKey() + "; Value:"
					+ (value.isObject() ? "\n" : ""));
			if (value.isInt()) {
				subTotal += value.asInt();
			}
			
			if (value.isTextual() && value.asText().equals("red")) {
				reds++;
				fieldsIterator.forEachRemaining(n -> {
				});
				subTotal = 0;
			}

			subTotal += handleNode(value);
		}

		if (!fieldsIterator.hasNext()) {
			sumInt += subTotal;
			subTotal = 0;
		}

		return subTotal;
	}

	private int parseArray(ArrayNode arr) {
		for (int i = 0; i < parseDepth; i++) {
			System.out.print("--");
		}
		System.out.println("[");
		int subTotal = 0;

		Iterator<JsonNode> elementsIterator = arr.elements();
		while (elementsIterator.hasNext()) {
			JsonNode value = elementsIterator.next();
			if (value.isInt()) {
				subTotal += value.asInt();
			}
			handleNode(value);
		}

		for (int i = 0; i < parseDepth; i++) {
			System.out.print("--");
		}
		System.out.println("]");
		return subTotal;
	}

	private int handleNode(JsonNode node) {
		int subTotal = 0;

		if (node.isObject()) {
			parseDepth++;
			subTotal = parseObject(node);
			parseDepth--;
		} else if (node.isArray()) {
			parseDepth++;
			subTotal = parseArray((ArrayNode) node);
			parseDepth--;
		} else {
			for (int i = 0; i < parseDepth; i++) {
				System.out.print("--");
			}
			if (node.isValueNode()) {
				System.out.println("Value: " + node);
			}
		}

		return subTotal;
	}

	private int count(Reader reader) throws IOException {
		int c, sum = 0;
		StringBuilder sb = new StringBuilder();

		while ((c = reader.read()) != -1) {
			if (c == '-' || (c >= '0' && c <= '9')) {
				sb.append((char) c);
			} else {
				if (sb.length() != 0) {
					sum += Integer.parseInt(sb.toString());
					sb = new StringBuilder();
				}
			}
		}
		return sum;
	}

}

/*
 Uh oh - the Accounting-Elves have realized that they double-counted everything red.

 Ignore any object (and all of its children) which has any property with the value "red".
 Do this only for objects ({...}), not arrays ([...]).

 [1,2,3] still has a sum of 6.
 [1,{"c":"red","b":2},3] now has a sum of 4, because the middle object is ignored.
 {"q":[1,{"c":"red","b":2},3]}
 {"d":"red","e":[1,2,3,4],"f":5} now has a sum of 0, because the entire structure is ignored.
 [1,"red",5] has a sum of 6, because "red" in an array has no effect.
 {"q":[1,"red",5]}
 */
