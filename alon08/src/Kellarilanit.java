
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


public class Kellarilanit {
	private static IO io;
	private static int n;
	private static List<Integer>[] computers;
	private static List<Integer>[] compReversed;
	private static List<Deque<Integer>> components;
	private static boolean[] visited;
	private static Deque<Integer> order;
	private static int biggestComponent;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		int connections = io.nextInt();
		visited = new boolean[n + 1];
		order = new ArrayDeque<>();
		computers = new ArrayList[n + 1];
		compReversed = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			computers[i] = new ArrayList<>();
			compReversed[i] = new ArrayList<>();
		}
		for (int i = 0; i < connections; i++) {
			int from = io.nextInt();
			int to = io.nextInt();
			computers[from].add(to);
		}
		findConnectionsOrder();
		reverseGraph();
		findComponents();
		io.println(biggestComponent);
		io.close();
	}

	private static void findConnectionsOrder() {
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) depthFirstSearch(computers, i, order);
		}
		visited = new boolean[n + 1];
	}

	private static void depthFirstSearch(List<Integer>[] graph, int i, Deque<Integer> comp) {
		visited[i] = true;
		for (int j = 0; j < graph[i].size(); j++) {
			if (!visited[graph[i].get(j)]) depthFirstSearch(graph, graph[i].get(j), comp);
		}
		comp.push(i);
	}

	private static void reverseGraph() {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < computers[i].size(); j++) {
				compReversed[computers[i].get(j)].add(i);
			}
		}
	}

	private static void findComponents() {
		biggestComponent = 0;
		components = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int computer = order.poll();
			if (!visited[computer]) {
				Deque<Integer> component = new ArrayDeque<>();
				depthFirstSearch(compReversed, computer, component);
				components.add(component);
				if (component.size() > biggestComponent) biggestComponent = component.size();
			}
		}
	}
	
}
