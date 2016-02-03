package day_13;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 03/02/2016
 */
class ParseLine {
	
	final String line;

	ParseLine(String line) {
		this.line = line;
	}
	
	OrderElem parse(){
		String[] parsedLine = line.replace(".", "").split(" ");
		
		return new OrderElem(
				parsedLine[0],
				parsedLine[parsedLine.length - 1],
				gainLose(parsedLine[2], Integer.parseInt(parsedLine[3])));
	}
	
	private static int gainLose(String gainLose, int howMuch){
		if ("gain".equals(gainLose)){
			return howMuch;
		} else if ("lose".equals(gainLose)){
			return -howMuch;
		}
		throw new IllegalArgumentException("Unknown gain/lose state: " + gainLose);
	}

}
