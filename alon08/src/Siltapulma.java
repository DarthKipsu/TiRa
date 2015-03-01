
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Siltapulma {

	private static class Bridge {
		int dest;
		int count;

		public Bridge(int dest) {
			this.dest = dest;
			count = 1;
		}
		
		public void inc() {
			count++;
		}

		public boolean lastOne() {
			count--;
			return count == 0;
		}
	}

	private static IO io;
	private static Map<Integer, Bridge>[] bridges;
	private static Map<Long, List<Integer>> id;
	private static int bridgeCount;
	private static int prev;

	public static void main(String[] args) {
		io = new IO();
		int islands = io.nextInt();
		bridgeCount = io.nextInt();
		id = new HashMap<>();
		bridges = new HashMap[islands + 1];
		for (int i = 1; i <= islands; i++) bridges[i] = new HashMap<>();
		for (int i = 1; i <= bridgeCount; i++) {
			int from = io.nextInt();
			int to = io.nextInt();
			if (bridges[from].containsKey(to)) bridges[from].get(to).inc();
			else bridges[from].put(to, new Bridge(to));
			if (bridges[to].containsKey(from)) bridges[to].get(from).inc();
			else bridges[to].put(from, new Bridge(to));
			long min = Math.min(from, to);
			long max = Math.max(from, to);
			long key = (min << 16) | max;
			if (!id.containsKey(key)) id.put(key, new LinkedList<>());
			id.get(key).add(i);
		}
		if (pairedNumberOfEdges()) printPath(1);
		else io.println("QAQ");
		io.close();
	}

	private static boolean pairedNumberOfEdges() {
		for (int i = 1; i < bridges.length; i++) {
			int edges = 0;
			for (Bridge bridge : bridges[i].values()) {
				edges += bridge.count;
			}
			if (edges % 2 != 0) return false;
		}
		prev = 1;
		return true;
	}

	private static void printPath(int start) {
		List<Integer> route = new ArrayList<>();
		int from = start;
		do {
			int to = (int) bridges[from].keySet().iterator().next();
			if (bridges[from].get(to).lastOne()) bridges[from].remove(to);
			if (bridges[to].get(from).lastOne()) bridges[to].remove(from);
			from = to;
			route.add(from);
		} while (from != start);
		for (Integer bridge : route) {
			long min = Math.min(prev, bridge);
			long max = Math.max(prev, bridge);
			io.println(id.get((min << 16) | max).remove(0));
			prev = bridge;
			if (bridges[bridge].size() > 0) printPath(bridge);
		}
	}
	
}
