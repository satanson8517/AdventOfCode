package day_07;

/**
 *
 * @author Michal Nedbálek
 */
class LineParser {

    private final Circuit circuit;
    private final String leftSide;
    private final String rightSide;

    public LineParser(String line, Circuit circuit) {
        String[] sides = line.split(" -> ");
        this.leftSide = sides[0];
        this.rightSide = sides[1];
        this.circuit = circuit;
    }

    public void parse() {
        String[] words = leftSide.split(" ");

        switch (words.length) {
            case 1:
                Operand leftOperand = new Operand(leftSide),
                 rightOperand = new Operand(rightSide);
                SignalProcessor sp = new SignalProcessor(circuit, leftOperand, rightOperand);
                sp.sendSignal();
                break;
            case 2:
                leftOperand = new Operand(words[1]);
                rightOperand = new Operand(rightSide);
                Negator negator = new Negator(circuit, leftOperand, rightOperand);
                negator.negate();
                break;
            case 3:
                Operand firstOperand = new Operand(words[0]),
                        secondOperand = new Operand(words[2]);
                rightOperand = new Operand(rightSide);
                Operator operator = new Operator(words[1]);
                GateRunner gr = new GateRunner(circuit, firstOperand, secondOperand, rightOperand, operator);
                gr.run();
                break;
            default:
                throw new IllegalStateException("Illegal left side.");

        }
    }

}
