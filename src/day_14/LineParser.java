package day_14;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 04/02/2016
 */
class LineParser {
	
	String line;

	LineParser(String line) {
		this.line = line;
	}
	
	Reindeer parse(){
		String[] parsedLine = line.replace(".", "").split(" ");
		return new Reindeer(
				parsedLine[0], 
				Integer.parseInt(parsedLine[3]),
				Integer.parseInt(parsedLine[6]),
				Integer.parseInt(parsedLine[13]));
	}

}
