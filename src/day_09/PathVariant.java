package day_09;

import java.util.List;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 01/02/2016
 */
public class PathVariant {

	private final List<String> nodes;
	private int total;

	PathVariant(List<String> nodes) {
		this.nodes = nodes;
	}

	int computeTotal(Graph graph) {
		int sum = 0;
		for (int i = 0; i < nodes.size() - 1; i++) {
			sum += graph.searchEdge(nodes.get(i), nodes.get(i + 1)).length;
		}

		this.total = sum;
		return sum;
	}

	int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		return "PathVariant{" + "nodes=" + nodes + ", total=" + total + '}';
	}

}
