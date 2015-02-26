
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Lentoasema {

	private static IO io;
	private static int n;
	private static long[][] capacity;
	private static List<Integer>[] graph;
	private static long[][] residual;
	private static int[] route;
	private static long maxFlow;
	
	public static void main(String[] args) {
		long INF = Long.MAX_VALUE;
		io = new IO();
		n = 2 * io.nextInt();
		int passages = io.nextInt();
		capacity = new long[n + 1][n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++) graph[i] = new ArrayList<>();
		for (int i = 1; i < n / 2 + 1; i++) {
			long cap = io.nextLong();
			if (cap == -1) capacity[i * 2 - 1][i * 2] = INF;
			else capacity[i * 2 - 1][i * 2] = cap;
			graph[i * 2 - 1].add(i * 2);
			graph[i * 2].add(i * 2 - 1);
		}
		for (int i = 0; i < passages; i++) {
			int from = io.nextInt();
			int where = io.nextInt();
			capacity[from * 2][where * 2 - 1] = INF;
			graph[from * 2].add(where * 2 - 1);
			graph[where * 2 - 1].add(from * 2);
		}
		maxFlow();
		io.print(maxFlow);
		io.close();
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
				int from = route[where];
				residual[from][where] += flow;
				residual[where][from] -= flow;
				where = from;
			}
		}
	}

	private static long breadthFirstSearch() {
		route = new int[n + 1];
		for (int i = 1; i < n + 1; i++) route[i] = -1;
		route[1] = -2;
		long[] foundCap = new long[n + 1];
		foundCap[1] = Long.MAX_VALUE;
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(1);
		while (!queue.isEmpty()) {
			int from = queue.poll();
			for (Integer where : graph[from]) {
				if (capacity[from][where] - residual[from][where] > 0 && route[where] == -1) {
					route[where] = from;
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
	
}
