import java.io.IOException;
/** Experimentation with integers
 * Following CS61B Sp15 by Josh Hug
 */

public class PowerTour {
	private static void powerTour(int x) throws IOException {
		int acc = x;
		while (true) {
			System.out.println(acc);
			System.in.read();
			acc = acc * x;
		}
	}

	public static void main(String[] args) throws IOException {
		powerTour(5);
	}
}