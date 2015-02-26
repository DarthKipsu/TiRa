
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class Pakomatka {

	private static IO io;
	private static int n;
	private static long[][] capacity;
	private static List<Integer>[] neighbours;
	private static long[][] residual;
	private static int[] parent;
	private static long maxFlow;
	private static Map<Integer, Set<Integer>> cuts;
	private static boolean[] visited;
	private static Set<Integer> x;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		capacity = new long[n + 1][n + 1];
		neighbours = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) neighbours[i] = new ArrayList<>();
		int edges = io.nextInt();
		for (int i = 0; i < edges; i++) {
			int from = io.nextInt();
			int where = io.nextInt();
			long cap= io.nextInt();
			capacity[from][where] = cap;
			neighbours[from].add(where);
			neighbours[where].add(from);
		}
		maxFlow();
		findCut();
		printSolution();
	}

	protected static void maxFlow() {
		residual = new long[n + 1][n + 1];
		maxFlow = 0;
		while (true) {
			long flow = breadthFirstSearch();
			if (flow == 0) return;
			maxFlow += flow;
			int where = n;
			while (where != 1) {
				int from = parent[where];
				residual[from][where] += flow;
				residual[where][from] -= flow;
				where = from;
			}
		}
	}

	private static long breadthFirstSearch() {
		parent = new int[n + 1];
		for (int i = 1; i <= n; i++) parent[i] = -1;
		parent[1] = -2;
		long[] foundCap = new long[n + 1];
		foundCap[1] = Long.MAX_VALUE;
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int from = queue.poll();
			for (Integer where : neighbours[from]) {
				if (capacity[from][where] - residual[from][where] > 0 && parent[where] == -1) {
					parent[where] = from;
					foundCap[where] = Math.min(foundCap[from], capacity[from][where] - residual[from][where]);
					if (where != n) {
						queue.add(where);
					} else {
						return foundCap[n];
					}
				}
			}
		}
		return 0;
	}

	private static void findCut() {
		cuts = new HashMap<>();
		visited = new boolean[n + 1];
		Queue<Integer> queue = new PriorityQueue<>();
		x = new HashSet<>();
		queue.add(1);
		x.add(1);
		while (!queue.isEmpty()) {
			int node = queue.poll();
			if (visited[node]) continue;
			else visited[node] = true;
			if (cuts.containsKey(node)) cuts.remove(node);
			for (Integer nextNode : neighbours[node]) {
				if (capacity[node][nextNode] - residual[node][nextNode] == 0 &&
						capacity[node][nextNode] != 0 && !visited[nextNode]) {
					if (!cuts.containsKey(nextNode)) cuts.put(nextNode, new HashSet<>());
					cuts.get(nextNode).add(node);
				} else {
					if (capacity[node][nextNode] != 0 || residual[node][nextNode] < 0) {
						queue.add(nextNode);
						x.add(nextNode);
					}
				}
			}
		}
	}

	private static void printSolution() {
		io.println(maxFlow);
		int cutCount = 0;
		for (Integer node : cuts.keySet()) cutCount += cuts.get(node).size();
		io.println(cutCount);
		for (Integer node : cuts.keySet()) {
			for (Integer nextNode : cuts.get(node)) {
				io.println(nextNode + " " + node);
			}
		}
		io.close();
		return;
	}
}