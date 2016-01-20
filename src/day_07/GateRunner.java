package day_07;

import java.util.UUID;

/**
 *
 * @author Michal Nedbálek
 */
class GateRunner {

    private final Circuit circuit;
    private final Operand firstOperand;
    private final Operand secondOperand;
    private final Operand output;
    private final Operator operator;

    public GateRunner(Circuit circuit, Operand firstOperand,
            Operand secondOperand, Operand output, Operator operator) {
        this.circuit = circuit;
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.output = output;
        this.operator = operator;
    }

    void run() {
        Wire firstInputWire, secondInputWire = null, outputWire;

        // parse and initialize the first operand
        if (firstOperand.isNumber()) {
            firstInputWire = new Wire(UUID.randomUUID().toString());
            firstInputWire.setSignal(firstOperand.toInt());
        } else {
            firstInputWire = circuit.getWire(firstOperand.value).orElseGet(
                    () -> {
                        circuit.addWire(firstOperand.value);
                        return circuit.getWire(firstOperand.value).get();
                    }
            );
        }

        // parse and initialize the second operand
        if (secondOperand.isNumber() && !operator.value.contains("SHIFT")) {
            secondInputWire = new Wire((UUID.randomUUID().toString()));
            secondInputWire.setSignal(secondOperand.toInt());
        }

        if (!secondOperand.isNumber()) {
//            secondInputWire = circuit.getWire(secondOperand.value);
            secondInputWire = circuit.getWire(secondOperand.value).orElseGet(
                    () -> {
                        circuit.addWire(secondOperand.value);
                        return circuit.getWire(secondOperand.value).get();
                    });
//            if (secondInputWire == null) {
//                circuit.addWire(secondOperand.value);
//                secondInputWire = circuit.getWire(secondOperand.value);
//            }
        }

        // parse and initialize output wire
        outputWire = circuit.getWire(output.value).orElseGet(
                () -> {
                    circuit.addWire(output.value);
                    return circuit.getWire(output.value).get();
                });
//        if (outputWire == null) {
//            circuit.addWire(output.value);
//            outputWire = circuit.getWire(output.value);
//        }

        // create gate
        Gate gate;
        switch (operator.value) {
            case "AND":
                gate = new And(firstInputWire, secondInputWire, outputWire);
                break;
            case "OR":
                gate = new Or(firstInputWire, secondInputWire, outputWire);
                break;
            case "LSHIFT":
                gate = new Lshift(firstInputWire, secondOperand.toInt(), outputWire);
                break;
            case "RSHIFT":
                gate = new Rshift(firstInputWire, secondOperand.toInt(), outputWire);
                break;
            default:
                throw new IllegalStateException("Unknown binary operator");
        }

        circuit.addGate(gate);
    }

}
