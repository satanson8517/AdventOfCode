package day_09;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 01/02/2016
 */
public class ArrayPathVariant implements PathVariant {

	private final String[] nodes;
	private int total;

	ArrayPathVariant(String[] nodes) {
		this.nodes = nodes;
	}

	int computeTotal(Graph graph) {
		int sum = 0;
		for (int i = 0; i < nodes.length - 1; i++) {
			sum += graph.searchEdge(nodes[i], nodes[i + 1]).length;
		}

		this.total = sum;
		return sum;
	}

	int getTotal() {
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nodes.length; i++) {
			sb.append(nodes[i]).append(";");
		}

		return "PathVariant{" + "nodes=" + sb.toString() + ", total=" + total + '}';
	}
}
