package adventofcode;

import day_11.Day11;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com>
 */
public class AdventOfCode {
    
    public static final String VAR_PATH = "./var";

    public static void main(String[] args) {
        try {
            Day day = new Day11();
            day.run();
        } catch (Exception ex) {
            Logger.getLogger(AdventOfCode.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
