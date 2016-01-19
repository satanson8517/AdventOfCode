package day_07;

/**
 *
 * @author Michal Nedbálek
 */
class Joint implements Gate {

    private final Wire input;
    private final Wire output;

    public Joint(Wire input, Wire output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public Wire getOutput() {
        return output;
    }

    @Override
    public boolean run() {
        if (input.getSignal() == null) {
            return false;
        }

        output.setSignal(new Int16bit(input.getSignal().value));
        return true;
    }

    @Override
    public String toString() {
        return "Joint{" + "input=" + input + ", output=" + output + '}';
    }

    @Override
    public boolean readyToRun() {
        return input != null && input.getSignal() != null;
    }

    @Override
    public boolean alreadyRun() {
        return readyToRun() && output != null && output.getSignal() != null;
    }

}
