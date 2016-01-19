package day_07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Michal Nedbálek
 */
class Circuit {

    private final List<Wire> wires;
    private final List<Gate> gates;

    Circuit() {
        this.wires = new ArrayList<>();
        this.gates = new ArrayList<>();
    }

    void addWire(String name) {
        wires.add(new Wire(name));
    }

    void addWire(String name, int signal) {
        wires.add(new Wire(name, signal));
    }

    void addWire(String name, Int16bit signal) {
        wires.add(new Wire(name, signal));
    }

    void addGate(Gate gate) {
        gates.add(gate);
    }

    Wire getWire(String name) {
        for (Wire wire : wires) {
            if (wire.getName().equals(name)) {
                return wire;
            }
        }
        return null;
    }

    void reset() {
        for (Wire wire : wires) {
            if (wire.getName().matches("[^b]")) {
                wire.setSignal(null);
            }
        }
    }

    void run() {
//        for (Wire wire : wires) {
//            if (wire.getSignal() == null) {
//                for (Gate gate : gates) {
//                    gate.run();
//                }
//            }
//        }
        boolean allRun = false;

        while (allRun == false) {
            // go through all gates that are ready to run
            for (Gate gate : gates) {
                if (gate.readyToRun() && !gate.alreadyRun()) {
                    gate.run();
                }
            }
            
            // presume all gates have already run
            allRun = true;
            
            // check if all gates have actually run
            for (Gate gate : gates){
                if (!gate.alreadyRun()){
                    allRun = false;
                }
            }
        }
    }

    void printWires() {
        Collections.sort(wires);
        for (Wire wire : wires) {
            System.out.println(wire.toString());
        }
//        System.out.println(wires.get(0));
    }

    void printGates() {
        for (Gate gate : gates) {
            System.out.println(gate.toString());
        }
    }

}
