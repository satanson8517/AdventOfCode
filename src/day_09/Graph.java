package day_09;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 27/01/2016
 */
public class Graph {

	final List<String> nodes = new ArrayList<>();
	final List<Edge> edges = new ArrayList<>();

	void addEdge(Edge edge) {
		edges.add(edge);
	}

	void addNode(Edge edge) {
		addNodeF.accept(edge.from);
		addNodeF.accept(edge.to);
	}

	/**
	 * Function that adds node to list of nodes if it is not there yet.
	 */
	private final Consumer<String> addNodeF = (String nodeAdd) -> {
		if (nodes.stream().noneMatch(node -> node.equals(nodeAdd))) {
			nodes.add(nodeAdd);
		}
	};

	List<String> getNodes() {
		nodes.stream().forEach(edge -> System.out.println(edge));
		return nodes;
	}

	List<Edge> minPath() {
		// sort all edges by their length - lowest to highest
		edges.stream().sorted().forEach(edge -> System.out.println(edge));
		return edges;
	}

}
