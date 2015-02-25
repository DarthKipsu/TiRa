
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;


public class Seuranhaku {

	private static IO io;
	private static int n;
	private static long[][] capacity;
	private static List<Integer>[] graph;
	private static char[] editors;
	private static long[][] residual;
	private static int[] parent;
	private static Map<Integer, Integer> pairs;
	private static long maxFlow;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		capacity = new long[n + 2][n + 2];
		graph = new ArrayList[n + 2];
		int pairCount = io.nextInt();
		editors = new char[n + 1];
		graph = new ArrayList[n + 2];
		pairs = new HashMap<>();
		for (int i = 0; i < n + 2; i++) graph[i] = new ArrayList<>();
		for (int i = 1; i <= n; i++) editors[i] = io.next().charAt(0);
		for (int i = 1; i <= n; i++) {
			if (editors[i] == 'E') {
				graph[0].add(i);
				graph[i].add(0);
				capacity[0][i] = 1;
			} else {
				graph[i].add(n + 1);
				graph[n + 1].add(i);
				capacity[i][n + 1] = 1;
			}
		}
		for (int i = 0; i < pairCount; i++) {
			int p1 = io.nextInt();
			int p2 = io.nextInt();
			if (editors[p1] == editors[p2]) continue;
				graph[p1].add(p2);
				graph[p2].add(p1);
			if (editors[p1] == 'E') capacity[p1][p2] = 1;
			else capacity[p2][p1] = 1;
		}
		maxFlow();
		io.println(pairs.size());
		Iterator keys = pairs.keySet().iterator();
		while(keys.hasNext()) {
			int key = (int) keys.next();
			io.println(key + " " + pairs.get(key));
		}
		io.close();
	}

	protected static void maxFlow() {
		residual = new long[n + 2][n + 2];
		maxFlow = 0;
		while (true) {
			long flow = breadthFirstSearch();
			if (flow == 0) return;
			maxFlow += flow;
			int where = parent[n + 1];
			residual[where][n + 1] += flow;
			while (where != 0) {
				int from = parent[where];
				pairs.put(where, from);
				residual[from][where] += flow;
				residual[parent[from]][parent[where]] += flow;
				residual[where][from] -= flow;
				residual[parent[where]][parent[from]] -= flow;
				where = parent[from];
			}
		}
	}

	private static long breadthFirstSearch() {
		parent = new int[n + 2];
		for (int i = 1; i < n + 2; i++) parent[i] = -1;
		parent[0] = -2;
		long[] foundCap = new long[n + 2];
		foundCap[0] = Long.MAX_VALUE;
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(0);
		while (!queue.isEmpty()) {
			int from = queue.poll();
			for (Integer where : graph[from]) {
				if (capacity[from][where] - residual[from][where] > 0 && parent[where] == -1) {
					parent[where] = from;
					foundCap[where] = Math.min(foundCap[from], capacity[from][where] - residual[from][where]);
					if (where != n + 1) {
						queue.add(where);
					} else {
						return foundCap[n + 1];
					}
				}
			}
		}
		return 0;
	}
}