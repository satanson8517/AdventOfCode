package day_07;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
public class Wire implements Comparable<Wire> {

    private final String name;
    private Int16bit signal;

    Wire(String name) {
        this.name = name;
    }

    Wire(String name, int signal) {
        this.name = name;
        this.signal = new Int16bit(signal);
    }

    Wire(String name, Int16bit signal) {
        this.name = name;
        this.signal = signal;
    }

    String getName() {
        return name;
    }

    Int16bit getSignal() {
        return signal;
    }

    void setSignal(Int16bit signal) {
        this.signal = signal;
    }

    void setSignal(int signal) {
        this.signal = new Int16bit(signal);
    }
	
	void reset(){
		this.signal = null;
	}

    @Override
    public String toString() {
        return "Wire{" + "name=" + name + ", signal=" + signal + '}';
    }

    @Override
    public int compareTo(Wire o) {
        final int BEFORE = -1,
                EQUAL = 0,
                AFTER = 1;
        // reflection
        if (this.equals(o)) {
            return EQUAL;
        }

        // compare products
        if (this.getName().compareTo(o.getName()) < 0) {
            return BEFORE;
        }
        if (this.getName().compareTo(o.getName()) > 0) {
            return AFTER;
        }

        return EQUAL;
    }

}
