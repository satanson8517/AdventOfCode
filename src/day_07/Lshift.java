package day_07;

/**
 *
 * @author Michal Nedbálek
 */
public class Lshift implements Gate {

    private final Wire firstInput;
    private final int shift;
    private final Wire output;

    Lshift(Wire firstInput, int shift, Wire output) {
        this.firstInput = firstInput;
        this.shift = shift;
        this.output = output;
    }

    @Override
    public Wire getOutput() {
        return output;
    }

    @Override
    public boolean run() {
        if (firstInput.getSignal() == null) {
            return false;
        }

        output.setSignal(new Int16bit(firstInput.getSignal().value << shift));
        return true;
    }

    @Override
    public String toString() {
        return "Lshift{" + "firstInput=" + firstInput + ", shift=" + shift + ", output=" + output + '}';
    }

    @Override
    public boolean readyToRun() {
        return firstInput != null && firstInput.getSignal() != null;
    }

    @Override
    public boolean alreadyRun() {
        return readyToRun() && output != null && output.getSignal() != null;
    }

}
