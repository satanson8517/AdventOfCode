package day_07;

/**
 *
 * @author Michal Nedbálek
 */
public class Int16bit {
    
    static final int MAX_VALUE = 65536;
    
    final int value;

    public Int16bit(int value) {
        value = value % MAX_VALUE;
        this.value = value < 0 ? MAX_VALUE + value : value;
    }

    @Override
    public String toString() {
        return "" + value;
    }

}
