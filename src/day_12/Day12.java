package day_12;

import adventofcode.AdventOfCode;
import adventofcode.Day;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 02/02/2016
 */
public class Day12 implements Day {

    static final String DAY_PATH = "day_12";
    static final String INPUT_FILE = "input.txt";

    @Override
    public void run() throws Exception {
        Path inputFile = Paths.get(AdventOfCode.VAR_PATH, DAY_PATH, INPUT_FILE).toRealPath(LinkOption.NOFOLLOW_LINKS);
        try (BufferedReader reader = Files.newBufferedReader(inputFile)) {
//			System.out.println(count(reader));
//			String jsonString = reader.readLine().replaceAll("([{][^\\[{]*\"red\"[^\\[]*[}])", "X");
            String jsonString = reader.readLine();
//            System.out.println(jsonString.length());

            Pattern p = Pattern.compile("([{][^\\[{]*\"red\"[^\\[]*?[}])");
            Matcher m = p.matcher(jsonString);
            int i = 0, sumObjBrace = 0;
            String subs;
            char[] subsArr;
            while (m.find()) {
                i++;
                subs = m.group();
                subsArr = subs.toCharArray();
                sumObjBrace = 0;
                for (int j = 0; j < subsArr.length; j++){
                    if (subsArr[j] == '{'){
                        sumObjBrace++;
                    } 
                    if (subsArr[j] == '}'){
                        sumObjBrace--;
                    } 
                }
                System.out.println(m.group() + ", " + sumObjBrace);
            }

            StringReader sr = new StringReader(jsonString);
            System.out.println(count(sr));
        } catch (Exception ex) {
            ex.printStackTrace(System.out);
        }
    }

    private int redCount(Reader reader) throws IOException {
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
