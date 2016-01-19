package day_03;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.LinkOption;
import java.nio.file.Paths;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 15/12/2015
 */
public class Day03 implements Day {

    static final String DAY_PATH = "day_03";
    static final String INPUT_FILE = "input.txt";
    private final Queue<House> houses = new LinkedBlockingQueue<>();

    @Override
    public void run() throws Exception {
        String inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS).toString();
        try (FileInputStream fis = new FileInputStream(inputFile)) {
            int c, charPosition = 1;
            Santa santa = new Santa(),
                    roboSanta = new Santa();

            houses.add(new House(new Position(0, 0)));
            while ((c = fis.read()) != -1) {
                char cc = (char) c;
                if (charPosition % 2 == 1) {
                    santa.move(cc);
                    logPosition(santa);
                } else {
                    roboSanta.move(cc);
                    logPosition(roboSanta);
                }
                charPosition++;
            }

            System.out.println(houses.size());

        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private void readLog() {
        for (House house : houses) {
            System.out.println(house.toString());
        }
    }

    private void logPosition(Santa santa) {
        for (House house : houses) {
            if (santa.getPos().equals(house.getPos())) {
                house.visit();
                return;
            }
        }
        houses.add(new House(new Position(santa.getPos().getX(), santa.getPos().getY())));
    }
}
