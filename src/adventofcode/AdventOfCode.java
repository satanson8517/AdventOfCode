package adventofcode;

import day_12.Day12;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com>
 */
public class AdventOfCode {
    
    public static final String VAR_PATH = "./var";

    public static void main(String[] args) {
        try {
            Day day = new Day12();
            day.run();
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

}
