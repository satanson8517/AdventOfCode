package day_07;

import java.util.Optional;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 17/12/2015
 */
class SignalProcessor {

    private final Circuit circuit;
    private final Operand input;
    private final Operand output;

    SignalProcessor(Circuit circuit, Operand input, Operand output) {
        this.circuit = circuit;
        this.input = input;
        this.output = output;
    }

    void sendSignal() {
//        Wire outputWire = circuit.getWire(output.value);
        Optional<Wire> outputWire = circuit.getWire(output.value);

        // left side is a number
        if (input.isNumber()) {
            int signal = input.toInt();
			
            if (outputWire != null) {
                outputWire.setSignal(signal);
            } else {
                circuit.addWire(output.value, signal);
            }

            // left side is a wire (string)
        } else {
            Wire inputWire = circuit.getWire(input.value);
            if (inputWire == null) {
                circuit.addWire(input.value);
                inputWire = circuit.getWire(input.value);
            }

            if (outputWire != null) {
                circuit.getWire(output.value).setSignal(inputWire.getSignal());
            } else {
                circuit.addWire(output.value, inputWire.getSignal());
                outputWire = circuit.getWire(output.value);
            }

            Joint joint = new Joint(inputWire, outputWire);
            circuit.addGate(joint);
        }
    }

}
