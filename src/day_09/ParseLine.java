package day_09;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 21/01/2016
 */
class ParseLine {
	String line;

	ParseLine(String line) {
		this.line = line;
	}
	
	void parse(){
		String from, to, cities;
		String[] split1, split2;
		int dist;
		
		split1 = line.split(" = ");
		split2 = split1[0].split(" to ");
		
		dist = Integer.parseInt(split1[1]);
		from = split2[0];
		to = split2[1];
	}
	
}
