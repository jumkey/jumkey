package meetmanager.utils;

public class RandomAwardToolkits {
	private static Object mutex = new Object();
	private static int MIN = 2000;

	/**
	 * 
	 * @return
	 */
	synchronized public static int next() {
		synchronized (mutex) {
			MIN = MIN + 1;
		}
		return MIN;
	}
}
