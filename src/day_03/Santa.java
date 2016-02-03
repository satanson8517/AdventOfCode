package day_03;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
class Santa {

	private final Position pos = new Position(0, 0);

	void move(char c) {
		switch (c) {
			case '^':
				pos.up();
				break;
			case 'v':
				pos.down();
				break;
			case '<':
				pos.left();
				break;
			case '>':
				pos.right();
				break;
			default:
				System.out.println("Unknown move !!!");
		}
	}

	Position getPos() {
		return pos;
	}

}
