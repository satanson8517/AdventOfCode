package day_09;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 21/01/2016
 */
class Edge implements Comparable {

	private String from;
	private String to;
	final int length;

	public Edge(String from, String to, int lenght) {
		this.from = from;
		this.to = to;
		this.length = lenght;
	}

//	public Edge(String from, String to, int lenght) {
//		this(new Node(from), new Node(to), lenght);
//	}
	@Override
	public String toString() {
		return "Edge{" + "from=" + from + ", to=" + to + ", length=" + length + '}';
	}

	@Override
	public int compareTo(Object o) {
		return this.from.compareTo(((Edge) o).from);
	}
//	@Override
//	public int compareTo(Object o) {
//		return this.length - ((Edge) o).length;
//	}

	public void orderEdge() {
		if (this.from.compareTo(this.to) > 0) {
			String aux = this.from;
			this.from = this.to;
			this.to = aux;
		}
	}

	public String getFrom() {
		return from;
	}

	public String getTo() {
		return to;
	}

}
