package day_07;

/**
 *
 * @author Michal Nedbálek
 */
interface Gate {

	public Wire getOutput();

	public boolean run();

	public boolean readyToRun();

	public boolean alreadyRun();
}
