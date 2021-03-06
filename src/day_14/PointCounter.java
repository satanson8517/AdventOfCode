package day_14;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 04/02/2016
 */
class PointCounter {

	final Set<Reindeer> herd;

	PointCounter(Set<Reindeer> herd) {
		this.herd = herd;
	}

	int getWinner(int time) {
		int max = 0;
		
		for (int moment = 1; moment <= time; moment++) {
			// add points to winners
			Set<Reindeer> winners = getMax(moment);
			winners.forEach(winner -> {
				winner.addPoint();
			});
		}
		
		for (Reindeer reindeer : herd) {
			if (reindeer.getPoints() > max){
				max = reindeer.getPoints();
			}
		}

		return max;
	}

	/**
	 * Gets winner/-s in the given time.
	 *
	 * @param time
	 * @return
	 */
	Set<Reindeer> getMax(int time) {
		int max = 0;
		Set<Reindeer> winners = new HashSet<>();

		// set momental distance to all reindeers
		herd.stream().forEach((reindeer) -> {
			reindeer.setMomentalDistance(time);
		});

		// get winner/-s
		for (Reindeer reindeer : herd) {
			int rmd = reindeer.getMomentalDistance();

			if (rmd > max) {
				max = rmd;
				winners.clear();
				winners.add(reindeer);
			} else if (rmd == max) {
				winners.add(reindeer);
			}
		}

		return winners;
	}

}
