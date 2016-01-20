package day_08;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Michal Nedbálek
 */
public class LineParser {

    private final String line;
    private int memChars = 0;
    private int textChars = 0;

    LineParser(String line) {
        this.line = line.substring(1, line.length() - 1);
        textChars = 2;
    }

    Line parse() {
        textChars += line.length();
        memChars = textChars;

        Pattern p = Pattern.compile("(\\\\)");
        Matcher m = p.matcher(line);
        memChars = textChars - m.groupCount();

        return new Line(line, memChars, textChars);
    }

    int getTextChars() {
        return textChars;
    }

    int getMemChars() {
        return memChars;
    }

}
