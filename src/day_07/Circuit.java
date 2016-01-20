package day_07;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;

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

	Optional<Wire> getWire(String name) {
//	Wire getWire(String name) {
//		for (Wire wire : wires) {
//			if (wire.getName().equals(name)) {
//				return wire;
//			}
//		}
//		return null;
		return wires.stream()
				.filter(w -> w.getName().equals(name))
				.findFirst();
	}

	void reset() {
		wires.stream().forEach(resetter);
	}

	private static final Consumer<Wire> resetter = (Wire wire) -> {
		if (wire.getName().equals("b")) {
			wire.setSignal(956);
		} else {
			wire.setSignal(null);
		}
	};

//	private static Consumer<Wire> resetter = new Consumer<Wire>() {
//		@Override
//		public void accept(Wire wire) {
//			if (wire.getName().equals("b")){
//				wire.setSignal(956);
//			} else {
//				wire.setSignal(null);
//			}
//		}
//	};
	void run() {
		while (wires.stream()
				.filter(w -> w.getSignal() == null)
				.count() != 0) {
			gates.stream()
					.filter(g -> !g.alreadyRun())
					.filter(g -> g.readyToRun())
					.map(g -> g.run())
					.forEach(g -> {
					});
		}
	}

	void printWires(Predicate<Wire> predicate) {
		wires.stream()
				.sorted()
				.filter(predicate)
				.forEach(w -> System.out.println(w));
	}

	void printGates(Predicate<Gate> predicate) {
		gates.stream()
				.filter(predicate)
				.forEach(g -> System.out.println(g));
	}

}
