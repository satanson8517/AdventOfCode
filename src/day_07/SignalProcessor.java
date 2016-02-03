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
		Optional<Wire> optOutputWire = circuit.getWire(output.value);

		// left side is a number
		if (input.isNumber()) {
			int signal = input.toInt();

			if (optOutputWire.isPresent()) {
				optOutputWire.get().setSignal(signal);
			} else {
				circuit.addWire(output.value, signal);
			}

			// left side is a wire (string)
		} else {
			Wire inputWire = circuit.getWire(input.value).orElseGet(() -> {
				circuit.addWire(input.value);
				return circuit.getWire(input.value).get();
			});

			if (optOutputWire.isPresent()) {
				circuit.getWire(output.value).get().setSignal(inputWire.getSignal());
			} else {
				circuit.addWire(output.value, inputWire.getSignal());
				optOutputWire = circuit.getWire(output.value);
			}

			Joint joint = new Joint(inputWire, optOutputWire.get());
			circuit.addGate(joint);
		}
	}

}
