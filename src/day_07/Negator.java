package day_07;

/**
 *
 * @author Michal Nedbálek
 */
class Negator {

	private final Circuit circuit;
	private final Operand input;
	private final Operand output;

	Negator(Circuit circuit, Operand input, Operand output) {
		this.circuit = circuit;
		this.input = input;
		this.output = output;
	}

	void negate() {
		Wire inputWire, outputWire;
//        Wire inputWire = circuit.getWire(input.value),
//                outputWire = circuit.getWire(output.value);

		// left side is always a wire (string)
		inputWire = circuit.getWire(input.value).orElseGet(() -> {
			circuit.addWire(input.value);
			return circuit.getWire(input.value).get();
		});
		outputWire = circuit.getWire(output.value).orElseGet(() -> {
			circuit.addWire(output.value);
			return circuit.getWire(output.value).get();
		});

//        if (inputWire == null) {
//            circuit.addWire(input.value);
//            inputWire = circuit.getWire(input.value);
//        }
//        if (outputWire == null) {
//            circuit.addWire(output.value);
//            outputWire = circuit.getWire(output.value);
//        }
		Not not = new Not(inputWire, outputWire);
		circuit.addGate(not);
	}

}
