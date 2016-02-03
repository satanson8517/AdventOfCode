package day_03;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 15/12/2015
 */
class Position implements Cloneable {

	private int x;
	private int y;

	Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	void up() {
		this.y++;
	}

	void down() {
		this.y--;
	}

	void left() {
		this.x--;
	}

	void right() {
		this.x++;
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
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Position{" + "x=" + x + ", y=" + y + '}';
	}

	@Override
	public int hashCode() {
		int hash = 5;
		hash = 59 * hash + this.x;
		hash = 59 * hash + this.y;
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Position other = (Position) obj;
		if (this.x != other.x) {
			return false;
		}
		if (this.y != other.y) {
			return false;
		}
		return true;
	}

}
