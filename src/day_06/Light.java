package day_06;

/**
 *
 * @author Michal Nedbálek <michal.nedbalek@avg.com> on 16/12/2015
 */
class Light {

	private int brightness = 0;

	Light() {
	}

	int getBrightness() {
		return brightness;
	}

	void increaseBrightness() {
		brightness++;
	}

	void decreaseBrightness() {
		if (brightness > 0) {
			brightness--;
		}
	}

}
