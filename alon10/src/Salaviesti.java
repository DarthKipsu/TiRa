
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Salaviesti {
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
	private static String paper;
	private static int[] suffix;

	public static void main(String[] args) {
		io = new IO();
		createSuffixArray();
//		io.println(Arrays.toString(suffix));
		countNeededMessageParts();
		io.close();
	}

	private static void createSuffixArray() {
		paper = io.next();
		int n = paper.length();
		int[] codes = new int[n];
		for (int i = 0; i < n; i++) codes[i] = paper.charAt(i);
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

	private static void countNeededMessageParts() {
		String message = io.next();
		int parts = 1;
		int n = paper.length();
		int start = 0;
		int end = n - 1;
		int offset = 0;
		for (int i = 0; i < message.length(); i++) {
			char c = message.charAt(i);
			while (start <= end) {
				int middle = (start + end + 1) / 2;
				if (suffix[middle] + offset >= n) {
					start = middle + 1;
				} else if (paper.charAt(suffix[middle] + offset) == c) {
					start = findStart(start, end, c, offset);
					end = findEnd(start, end, c, offset);
					break;
				} else if (paper.charAt(suffix[middle] + offset) > c) {
					end = middle - 1;
				} else {
					start = middle + 1;
				}
			}
			if (start > end) {
				start = 0;
				end = n - 1;
				offset = 0;
				parts++;
				i--;
			} else offset++;
		}
		io.println(parts);
	}

	private static int findStart(int start, int end, char c, int offset) {
		while (true) {
			if (end == start) return start;
			if (suffix[start] + offset < paper.length() && paper.charAt(suffix[start] + offset) == c) return start;
			int middle = (start + end) / 2;
			if (suffix[middle] + offset >= paper.length()) start = middle + 1;
			else if (paper.charAt(suffix[middle] + offset) > c) end = middle - 1;
			else if (paper.charAt(suffix[middle] + offset) < c) start = middle + 1;
			else if (middle - 1 < 0 || suffix[middle - 1] < 0 || 
					suffix[middle - 1] + offset >= paper.length() ||
					paper.charAt(suffix[middle - 1] + offset) != c) return middle;
			else end = middle - 1;
		}
	}

	private static int findEnd(int start, int end, char c, int offset) {
		while (true) {
			if (end == start) return end;
			if (suffix[end] + offset < paper.length() && paper.charAt(suffix[end] + offset) == c) return end;
			int middle = (start + end) / 2;
			if (suffix[middle] + offset >= paper.length()) end = middle - 1;
			else if (paper.charAt(suffix[middle] + offset) > c) end = middle - 1;
			else if (paper.charAt(suffix[middle] + offset) < c) start = middle + 1;
			else if (middle + 1 >= paper.length() || suffix[middle + 1] >= paper.length() || 
					suffix[middle + 1] + offset >= paper.length() ||
					paper.charAt(suffix[middle + 1] + offset) != c) return middle;
			else start = middle + 1;
		}
	}
}
