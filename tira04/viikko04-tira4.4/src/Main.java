import java.util.*;

public class Main {

	public static boolean vaunusiirto(int[] vaunut) {
		Deque<Integer> raide = new ArrayDeque<Integer>();
		Deque<Integer> väliraide = new ArrayDeque<Integer>();
		int vaunu = vaunut.length - 1;
		int siirrettavaVaunu = vaunut.length;

		while (siirrettavaVaunu > 0) {
			if (!väliraide.isEmpty() && väliraide.getFirst() == siirrettavaVaunu) {
				raide.addLast(väliraide.pop());
				siirrettavaVaunu--;
			} else {
				if (vaunu < 0) {
					return false;
				} else if (vaunut[vaunu] == siirrettavaVaunu) {
					raide.addLast(vaunut[vaunu]);
					siirrettavaVaunu--;
				} else {
					väliraide.addLast(vaunut[vaunu]);
				}
				vaunu--;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		System.out.println(vaunusiirto(new int[]{1, 2, 3, 4}));
		System.out.println(vaunusiirto(new int[]{1, 3, 2, 4}));
		System.out.println(vaunusiirto(new int[]{4, 1, 2, 3}));
		System.out.println(vaunusiirto(new int[]{4, 3, 2, 1}));
		System.out.println(vaunusiirto(new int[]{4, 1, 3, 2}));
		System.out.println(vaunusiirto(new int[]{2, 3, 1}));

	}
}
