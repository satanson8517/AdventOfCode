package day_06;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 15/12/2015
 */
class Position {

	private int x;
	private int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Position(String x, String y) {
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}

	int getX() {
		return x;
	}

	void setX(int x) {
		this.x = x;
	}

	int getY() {
		return y;
	}

	void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Position{" + "x=" + x + ", y=" + y + '}';
	}

}
