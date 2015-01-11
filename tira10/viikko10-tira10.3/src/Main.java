import java.util.*;

public class Main {

	private static int[][] kartta;

	public static int lyhinReitti(int[][] uusiKartta) {
		kartta = uusiKartta;
		for (int i = 1; i < kartta.length; i++) {
			for (int j = 1; j < kartta[i].length; j++) {
				if (kartta[i][j] == 2) {
					return etsi(i, j);
				}
			}
		}
		return -1;
	}

	private static int etsi(int i, int j) {
		ArrayDeque<int[]> suunnat = new ArrayDeque<int[]>();
		kartta[i][j] = 1;

		if (kartta[i + 1][j] != 1) {
			if (kartta[i + 1][j] == 3) return 1;
			kartta[i + 1][j] = 1;
			suunnat.addFirst(new int[]{i + 1, j, 1});
		}
		if (kartta[i - 1][j] != 1) {
			if (kartta[i - 1][j] == 3) return 1;
			kartta[i - 1][j] = 1;
			suunnat.addFirst(new int[]{i - 1, j, 1});
		}
		if (kartta[i][j + 1] != 1) {
			if (kartta[i][j + 1] == 3) return 1;
			kartta[i][j + 1] = 1;
			suunnat.addFirst(new int[]{i, j + 1, 1});
		}
		if (kartta[i][j - 1] != 1) {
			if (kartta[i][j - 1] == 3) return 1;
			kartta[i][j - 1] = 1;
			suunnat.addFirst(new int[]{i, j - 1, 1});
		}

		while (!suunnat.isEmpty()) {
			int[] suunta = suunnat.pollLast();

			if (kartta[suunta[0] + 1][suunta[1]] != 1) {
				if (kartta[suunta[0] + 1][suunta[1]] == 3) return suunta[2] + 1;
				kartta[suunta[0] + 1][suunta[1]] = 1;
				suunnat.addFirst(new int[]{suunta[0] + 1, suunta[1], suunta[2] + 1});
			}
			if (kartta[suunta[0] - 1][suunta[1]] != 1) {
				if (kartta[suunta[0] - 1][suunta[1]] == 3) return suunta[2] + 1;
				kartta[suunta[0] - 1][suunta[1]] = 1;
				suunnat.addFirst(new int[]{suunta[0] - 1, suunta[1], suunta[2] + 1});
			}
			if (kartta[suunta[0]][suunta[1] + 1] != 1) {
				if (kartta[suunta[0]][suunta[1] + 1] == 3) return suunta[2] + 1;
				kartta[suunta[0]][suunta[1] + 1 ] = 1;
				suunnat.addFirst(new int[]{suunta[0], suunta[1] + 1, suunta[2] + 1});
			}
			if (kartta[suunta[0]][suunta[1] - 1] != 1) {
				if (kartta[suunta[0]][suunta[1] - 1] == 3) return suunta[2] + 1;
				kartta[suunta[0]][suunta[1] - 1] = 1;
				suunnat.addFirst(new int[]{suunta[0], suunta[1] - 1, suunta[2] + 1});
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[][] kartta = {{1, 1, 1, 1, 1, 1, 1, 1},
		{1, 0, 3, 1, 0, 0, 0, 1},
		{1, 0, 1, 1, 0, 1, 0, 1},
		{1, 0, 0, 0, 0, 2, 0, 1},
		{1, 1, 1, 1, 1, 1, 1, 1}};
		System.out.println(lyhinReitti(kartta));
	}
}
