package day_07;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
class And implements Gate {

    private final Wire firstInput;
    private final Wire secondInput;
    private final Wire output;

    And(Wire firstInput, Wire secondInput, Wire output) {
        this.firstInput = firstInput;
        this.secondInput = secondInput;
        this.output = output;
    }

    Wire getFirstInput() {
        return firstInput;
    }

    Wire getSecondInput() {
        return secondInput;
    }

    @Override
    public Wire getOutput() {
        return output;
    }

    @Override
    public boolean run() {
        if (firstInput.getSignal() == null || secondInput.getSignal() == null) {
            return false;
        }

        output.setSignal(new Int16bit(firstInput.getSignal().value
                & secondInput.getSignal().value));
        return true;
    }

    @Override
    public String toString() {
        return "And{" + "firstInput=" + firstInput + ", secondInput=" + secondInput + ", output=" + output + '}';
    }

    @Override
    public boolean readyToRun() {
        return firstInput != null && firstInput.getSignal() != null
                && secondInput != null && secondInput.getSignal() != null;
    }

    @Override
    public boolean alreadyRun() {
        return readyToRun() && output != null && output.getSignal() != null;
    }

}
