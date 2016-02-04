package day_14;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 04/02/2016
 */
class Reindeer {

	final String name;
	final int velocity;
	final int timeFly;
	final int timeRest;

	Reindeer(String name, int velocity, int timeFly, int timeRest) {
		this.name = name;
		this.velocity = velocity;
		this.timeFly = timeFly;
		this.timeRest = timeRest;
	}

	int distance(int time) {
		int timeBlockOfMovement = timeFly + timeRest,
				timeBlocks = time / timeBlockOfMovement,
				timeRemaining = time - timeBlocks * timeBlockOfMovement,
				distanceBlockOfMovement = velocity * timeFly,
				total = timeBlocks * distanceBlockOfMovement;

		if (timeFly <= timeRemaining) {
			total += velocity * timeFly;
		} else {
			total += velocity * timeRemaining;
		}

		return total;
	}

	@Override
	public String toString() {
		return "Reindeer{" + "name=" + name + ", velocity=" + velocity
				+ ", timeFly=" + timeFly + ", timeRest=" + timeRest + '}';
	}

}
