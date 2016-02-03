package day_12;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 03/02/2016
 */
public class Download implements Day {

	static final String DAY_PATH = "day_12";
	static final String INPUT_FILE = "input.txt";

	@Override
	public void run() throws Exception {
		Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
		
		//match numbers
		Pattern number = Pattern.compile("((-\\d+)|(\\d+))");
		//match arrays and objects
		Pattern combo = Pattern.compile("(\\{[-\\w\\,\\:\\\"]*\\})|(\\[[-\\w\\,\\\"]*\\])");
		
		try (Scanner scanner = new Scanner(inputFile)) {
			String strLine = scanner.nextLine();
			int sum = 0;
			
			//a)
			Matcher m = number.matcher(strLine);
			while (m.find()) {
				//sum all numbers
				sum += Integer.parseInt(m.group(0));
			}
			System.out.println("a: " + sum);
			
			// b)
			Matcher k;
			m = combo.matcher(strLine);
			while (m.find()) {
				int subsum = 0;
				if (!(m.group(0).matches("\\{[-\\w\\,\\:\\\"]*\\}") && m.group(1).matches(".*:\"red\".*"))) //ignore {.:"red".}
				{
					k = number.matcher(m.group(0));
					while (k.find()) //sum up array or object
					{
						subsum += Integer.parseInt(k.group(0));
					}
				}
				strLine = strLine.substring(0, m.start()) + subsum + strLine.substring(m.end());
				m = combo.matcher(strLine);
			}
			System.out.println("b: " + strLine);
		}
	}
}
