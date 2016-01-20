package day_08;

/**
 *
 * @author Michal Nedbálek
 */
public class Line {
    
    final String line;
    final int memChars;  
    final int textChars;  

    Line(String line, int memChars, int textChars) {
        this.line = line;
        this.memChars = memChars;
        this.textChars = textChars;
    }

    @Override
    public String toString() {
        return "Line{" + "line=" + line + ", memChars=" + memChars + ", textChars=" + textChars + '}';
    }
}
