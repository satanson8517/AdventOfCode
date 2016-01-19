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
        Wire inputWire = circuit.getWire(input.value),
                outputWire = circuit.getWire(output.value);
        
        // left side is always a wire (string)
        if (inputWire == null) {
            circuit.addWire(input.value);
            inputWire = circuit.getWire(input.value);
        }
        if (outputWire == null) {
            circuit.addWire(output.value);
            outputWire = circuit.getWire(output.value);
        }
        
        Not not = new Not(inputWire, outputWire);
        circuit.addGate(not);
    }

}
