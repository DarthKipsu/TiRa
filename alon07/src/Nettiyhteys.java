
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Nettiyhteys {

	private static IO io;
	private static int n;
	private static long[][] capacities;
	private static List<Integer>[] neighbours;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		capacities = new long[n + 1][n + 1];
		neighbours = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) neighbours[i] = new ArrayList<>();
		int edges = io.nextInt();
		for (int i = 0; i < edges; i++) {
			int from = io.nextInt();
			int where = io.nextInt();
			long capacity = io.nextInt();
			capacities[from][where] = capacity;
			neighbours[from].add(where);
		}
		maxFlow();
	}

	protected static void maxFlow() {
		long[][] used = new long[n + 1][n + 1];
		while (true) {
			int[] visited = new int[n + 1];
			long[] flow = new long[n + 1];
			visited[1] = -1;
			flow[1] = Integer.MAX_VALUE;
			Queue<Integer> queue = new PriorityQueue<>();
			queue.add(1);
			findARoute(used, queue, visited, flow);
			if (visited[n] == 0) {
				long sum = 0;
				for (int i = 1; i <= n; i++) {
					sum += used[1][i];
				}
				io.print(sum);
				io.close();
				return;
			}
		}
	}

	private static void findARoute(long[][] used, Queue<Integer> queue, int[] visited, long[] flow) {
		while (!queue.isEmpty()) {
			int from = queue.poll();
			for (Integer where : neighbours[from]) {
				if (capacities[from][where] - used[from][where] > 0 && visited[where] == 0) {
					visited[where] = from;
					flow[where] = Math.min(flow[from], capacities[from][where] - used[from][where]);
					if (where != n) {
						queue.add(where);
					} else {
						while (visited[where] != -1) {
							from = visited[where];
							used[from][where] += flow[n];
							where = from;
						}
						return;
					}
				}
			}
		}
	}

}
