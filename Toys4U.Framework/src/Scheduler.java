public interface Scheduler {

	/**
	 * 
	 * @param frequency
	 */
	void run(int frequency);

	void increase();

	void decrease();

	/**
	 * 
	 * @param frequency
	 */
	void setFrequency(int frequency);

}