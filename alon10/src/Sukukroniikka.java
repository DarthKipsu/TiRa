
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Sukukroniikka {
	private static class Pair implements Comparable<Pair> {
		int first;
		int second;
		int index;

		public Pair(int first, int second, int index) {
			this.first = first;
			this.second = second;
			this.index = index;
		}

		@Override
		public int compareTo(Pair o) {
			if (first == o.first) return second - o.second;
			return first - o.first;
		}

		@Override
		public boolean equals(Object obj) {
			if (!(obj instanceof Pair)) return false;
			Pair o = (Pair) obj;
			return first == o.first && second == o.second;
		}

	}
	
	private static IO io;
	private static String kroniikka;
	private static int[] suffix;

	public static void main(String[] args) {
		io = new IO();
		createSuffixArray();
//		io.println(Arrays.toString(suffix));
		findRelatives();
		io.close();
	}

	private static void createSuffixArray() {
		kroniikka = io.next();
		int n = kroniikka.length();
		int[] codes = new int[n];
		for (int i = 0; i < n; i++) codes[i] = kroniikka.charAt(i);
		for (int x = 1; x <= n; x *= 2) {
			List<Pair> pairs = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				int second = (i + x < n) ? codes[i + x] : -1;
				pairs.add(new Pair(codes[i], second, i));
			}
			Collections.sort(pairs);
			int count = 0;
			for (int i = 0; i < n; i++) {
				if (i != 0 && !pairs.get(i - 1).equals(pairs.get(i))) count++;
				codes[pairs.get(i).index] = count;
			}
			if (count == n - 1) break;
		}
		suffix = new int[n];
		for (int i = 0; i < n; i++) suffix[codes[i]] = i;
	}

	private static void findRelatives() {
		int queries = io.nextInt();
		for (int i = 0; i < queries; i++) {
			String relative = io.next();
			int start = 0;
			int end = kroniikka.length() - 1;
			for (int j = 0; j < relative.length(); j++) {
				char c = relative.charAt(j);
				while (start <= end) {
					int middle = (start + end) / 2;
					if (suffix[middle] + j >= kroniikka.length()) start = end + 1;
					else if (kroniikka.charAt(suffix[middle] + j) == c) {
						if (j == relative.length() - 1) break;
						start = findStart(start, end, c, j);
						end = findEnd(start, end, c, j);
						break;
					} else if (kroniikka.charAt(suffix[middle] + j) > c) end = middle - 1;
					else start = middle + 1;
				}
				if (start > end) {
					io.println("QAQ");
					break;
				} else if (j == relative.length() - 1) io.println("YAY");
			}
		}
	}

	private static int findStart(int start, int end, char c, int j) {
		while (true) {
			int middle = (start + end) / 2;
			if (end == start) return middle;
			if (suffix[start] + j < kroniikka.length() && kroniikka.charAt(suffix[start] + j) == c) return start;
			if (suffix[middle] + j >= kroniikka.length()) start = middle + 1;
			else if (kroniikka.charAt(suffix[middle] + j) > c) end = middle - 1;
			else if (kroniikka.charAt(suffix[middle] + j) < c) start = middle + 1;
			else if (middle - 1 < 0 || suffix[middle - 1] < 0 || 
					suffix[middle - 1] + j >= kroniikka.length() ||
					kroniikka.charAt(suffix[middle - 1] + j) != c) return middle;
			else end = middle - 1;
		}
	}

	private static int findEnd(int start, int end, char c, int j) {
		while (true) {
			int middle = (start + end) / 2;
			if (end == start) return middle;
			if (suffix[end] + j < kroniikka.length() && kroniikka.charAt(suffix[end] + j) == c) return end;
			if (suffix[middle] + j >= kroniikka.length()) start = middle + 1;
			else if (kroniikka.charAt(suffix[middle] + j) > c) end = middle - 1;
			else if (kroniikka.charAt(suffix[middle] + j) < c) start = middle + 1;
			else if (middle + 1 >= kroniikka.length() || suffix[middle + 1] >= kroniikka.length() || 
					suffix[middle + 1] + j >= kroniikka.length() ||
					kroniikka.charAt(suffix[middle + 1] + j) != c) return middle;
			else start = middle + 1;
		}
	}
	
}
