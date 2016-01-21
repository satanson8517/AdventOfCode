package day_08;

/**
 *
 * @author Michal Nedbálek
 */
public class LineParser {

    private String line;
    private int memChars = 0;
    private int textChars = 0;

    LineParser(String line) {
        this.line = line;
    }

    Line parse02() {
        textChars += line.length();
        memChars = 2;

        byte[] lineBytes = line.getBytes();
        for (int i = 0; i < lineBytes.length; i++) {
            memChars++;
            if (lineBytes[i] == (byte) '\\'
                    || lineBytes[i] == (byte) '"') {
                memChars++;
            }
        }

        return new Line(line, memChars, textChars);
    }

    Line parse01() {
        line = line.substring(1, line.length() - 1);
        textChars = 2;
        textChars += line.length();
        memChars = 0;

        byte[] lineBytes = line.getBytes();
        for (int i = 0; i < lineBytes.length; i++) {
            memChars++;
            if (lineBytes[i] == (byte) '\\') {
                if (lineBytes[i + 1] == (byte) 'x') {
                    i += 3;
                } else {
                    i++;
                }
            }
        }

        return new Line(line, memChars, textChars);
    }

    int getTextChars() {
        return textChars;
    }

    int getMemChars() {
        return memChars;
    }

}
