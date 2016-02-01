package day_09;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 27/01/2016
 */
public class ListGraph extends Graph {

	final List<String> nodes = new ArrayList<>();
	final List<Edge> edges = new ArrayList<>();
	final Set<ListPathVariant> allPerms = new HashSet<>();

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
		permutation(nodes, 0, nodes.size() - 1);
		evaluateEdges();
	}

	void evaluateEdges() {
		for (ListPathVariant pv : allPerms) {
			pv.computeTotal(this);
			
//			System.out.println(pv);
		}
	}

	@Override
	ListPathVariant getMaxPath(){
		Integer max = 0;
		ListPathVariant maxPv = null;

		for (ListPathVariant pv : allPerms){
			if (pv.getTotal() > max){
				max = pv.getTotal();
				maxPv = pv;
			}
		}

		return maxPv;
	}

	@Override
	ListPathVariant getMinPath(){
		Integer min = Integer.MAX_VALUE;
		ListPathVariant minPv = null;

		for (ListPathVariant pv : allPerms){
			if (pv.getTotal() < min){
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

	private void permutation(List<String> nodes, int begin, int end) {
		if (begin == end) {
			List<String> listCopy = new LinkedList<>();
			listCopy.addAll(nodes);
			ListPathVariant pv = new ListPathVariant(listCopy);
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

	private void swap(List<String> nodes, int first, int second) {
		String aux = nodes.get(first);
		nodes.set(first, nodes.get(second));
		nodes.set(second, aux);
	}

}
