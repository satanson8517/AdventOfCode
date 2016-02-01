package day_09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 01/02/2016
 */
public class ArrayGraph extends Graph {

	final List<String> nodes = new ArrayList<>();
	final List<Edge> edges = new ArrayList<>();
	final Set<ArrayPathVariant> allPerms = new HashSet<>();

	@Override
	void addEdge(Edge edge) {
		edges.add(edge);
	}

	@Override
	void addNode(Edge edge) {
		addNodeF.accept(edge.getFrom());
		addNodeF.accept(edge.getTo());
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
		nodes.stream().sorted().forEach(node -> System.out.println(node));
		return nodes;
	}

	@Override
	void initFinished() {
		String[] nodesArr = new String[nodes.size()];
		nodesArr = nodes.toArray(nodesArr);

		permutation(nodesArr, 0, nodes.size() - 1);
		evaluateEdges();
	}

	void evaluateEdges() {
		for (ArrayPathVariant pv : allPerms) {
			pv.computeTotal(this);

//			System.out.println(pv);
		}
	}

	@Override
	PathVariant getMaxPath() {
		Integer max = 0;
		ArrayPathVariant maxPv = null;

		for (ArrayPathVariant pv : allPerms) {
			if (pv.getTotal() > max) {
				max = pv.getTotal();
				maxPv = pv;
			}
		}

		return maxPv;
	}

	@Override
	ArrayPathVariant getMinPath() {
		Integer min = Integer.MAX_VALUE;
		ArrayPathVariant minPv = null;

		for (ArrayPathVariant pv : allPerms) {
			if (pv.getTotal() < min) {
				min = pv.getTotal();
				minPv = pv;
			}
		}

		return minPv;
	}

	@Override
	Edge searchEdge(String from, String to) {
		// try to find the edge
		for (Edge edge : edges) {
			if (edge.getFrom().equals(from) && edge.getTo().equals(to)) {
				return edge;
			}
		}

		// if not edge found try to swap from-to values
		for (Edge edge : edges) {
			if (edge.getFrom().equals(to) && edge.getTo().equals(from)) {
				return edge;
			}
		}

		throw new IllegalArgumentException("Edge not found: from: "
				+ from + "; to: " + to + " !!!");
	}

	private void permutation(String[] nodes, int begin, int end) {
		if (begin == end) {
			String[] arrCopy = new String[nodes.length];
			System.arraycopy(nodes, 0, arrCopy, 0, nodes.length);

			ArrayPathVariant pv = new ArrayPathVariant(arrCopy);
			allPerms.add(pv);
			
//			System.out.println(pv);
		} else {
			for (int i = begin; i <= end; i++) {
				swap(nodes, i, begin);
				permutation(nodes, begin + 1, end);
				swap(nodes, i, begin);
			}
		}
	}

	private void swap(String[] nodes, int first, int second) {
		String aux = nodes[first];
		nodes[first] = nodes[second];
		nodes[second] = aux;

	}
}
