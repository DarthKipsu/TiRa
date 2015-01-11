
import java.util.Locale;

/**
 * Returns how much gas is needed to travel to a location between 1-400 km away.
 * The formula used to calculate the result is distance = e^x + sqrt(x).
 */
public class Mummola {
	
	public static void main(String[] args) {
		IO io = new IO();
		io.println(getGasFor(io.nextDouble()));
		io.close();
	}
	
	public static String getGasFor(double distance) {
		if (distance == 1) return "0.00000000";
		double start = 0;
		double end = 6;
		while (start <= end) {
			double middle = (start + end) / 2;
			double distanceTravelledWithMiddle = Math.pow(Math.E, middle) + Math.sqrt(middle);
			if (Math.abs(distance - distanceTravelledWithMiddle) < 0.000001) {
				return String.format(Locale.ENGLISH, "%.9g", middle);
			} else if (distanceTravelledWithMiddle > distance) {
				end = middle - 0.000000001;
			} else {
				start = middle + 0.000000001;
			}
		}
		return "Not inside the correct range";
	}
	
}
