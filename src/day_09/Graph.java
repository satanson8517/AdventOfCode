package day_09;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com>
 */
abstract class Graph {

	abstract Edge searchEdge(String from, String to);

	abstract void addEdge(Edge edge);

	abstract void addNode(Edge edge);

	abstract void initFinished();

	abstract PathVariant getMaxPath();

	abstract PathVariant getMinPath();

}
