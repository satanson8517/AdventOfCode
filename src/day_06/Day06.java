package day_06;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
public class Day06 implements Day {

    static final String DAY_PATH = "day_06";
    static final String INPUT_FILE = "input.txt";
//    private final boolean[][] grid = new boolean[1000][1000];
    private final Light[][] grid = new Light[1000][1000];

    @Override
    public void run() throws Exception {
        Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
            initializeGrid();
            String line;
            while ((line = reader.readLine()) != null) {
                Order order = parseLine(line);
//                System.out.println(order.toString());
                processLights(order);
            }
            System.out.println(sumLightsOn());
        } catch (IOException x) {
            System.err.format("IOException: %s%n", x);
        }
    }

    private Order parseLine(String line) {
        String[] words = line.split(" "), posMin, posMax;
        Order order = new Order();

        if (words.length == 4) {
            order.setVerb(Verb.TOGGLE);
            posMin = words[1].split(",");
            posMax = words[3].split(",");
        } else {
            if (words[1].equals("on")) {
                order.setVerb(Verb.TURN_ON);
            } else {
                order.setVerb(Verb.TURN_OFF);
            }
            posMin = words[2].split(",");
            posMax = words[4].split(",");
        }

        order.setMin(new Position(posMin[0], posMin[1]));
        order.setMax(new Position(posMax[0], posMax[1]));

        return order;
    }

    private void processLights(Order order) {
        for (int x = order.getMin().getX(); x <= order.getMax().getX(); x++) {
            for (int y = order.getMin().getY(); y <= order.getMax().getY(); y++) {
                toggleLight(grid[x][y], order);
//                grid[x][y] = toggleLight(grid[x][y], order);
            }
        }
    }

    private void toggleLight(Light light, Order order) {
        switch (order.getVerb()) {
            case TOGGLE:
                light.increaseBrightness();
                light.increaseBrightness();
                break;
            case TURN_ON:
                light.increaseBrightness();
                break;
            case TURN_OFF:
                light.decreaseBrightness();
                break;
            default:
                throw new IllegalStateException("Unknown verb !!!");
        }
    }
//    private boolean toggleLight(boolean light, Order order) {
//        switch (order.getVerb()) {
//            case TOGGLE:
//                return !light;
//            case TURN_ON:
//                return true;
//            case TURN_OFF:
//                return false;
//            default:
//                throw new IllegalStateException("Unknown verb !!!");
//        }
//    }

    private long sumLightsOn() {
        long sum = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                sum += grid[x][y].getBrightness();
//                if (grid[x][y]) {
//                    sum++;
//                }
            }
        }
        return sum;
    }

    private void initializeGrid() {
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                grid[x][y] = new Light();
            }
        }
    }

}
