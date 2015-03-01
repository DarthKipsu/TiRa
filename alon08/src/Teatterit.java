
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Teatterit {
	private static IO io;
	private static int n;
	private static List<Integer>[] computers;
	private static List<Integer>[] compReversed;
	private static List<Deque<Integer>> components;
	private static boolean[] visited;
	private static Deque<Integer> order;
	private static boolean locationFound;

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
		io.close();
	}

	private static void findConnectionsOrder() {
		for (int i = 1; i <= n; i++) {
			if (!visited[i]) depthFirstSearch(i);
		}
		visited = new boolean[n + 1];
	}

	private static void depthFirstSearch(int i) {
		visited[i] = true;
		for (int j = 0; j < computers[i].size(); j++) {
			if (!visited[computers[i].get(j)]) depthFirstSearch(computers[i].get(j));
		}
		order.push(i);
	}

	private static void reverseGraph() {
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < computers[i].size(); j++) {
				compReversed[computers[i].get(j)].add(i);
			}
		}
	}

	private static void findComponents() {
		locationFound = false;
		components = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int computer = order.poll();
			if (!visited[computer]) {
				Deque<Integer> component = new ArrayDeque<>();
				Set<Integer> thisComponent = new HashSet<>();
				depthFirstSearch(compReversed, computer, component, thisComponent);
				components.add(component);
				if (!locationFound && component.size() == 1 && computers[component.peek()].size() == 0) {
					if (component.peek() > 1) io.println(component.peek() + " " + 1);
					else io.println(component.peek() + " " + 2);
					return;
				}
			}
		}
	}

	private static void depthFirstSearch(List<Integer>[] graph, int i, Deque<Integer> comp, Set<Integer> thisComponent) {
		visited[i] = true;
		thisComponent.add(i);
		for (int j = 0; j < graph[i].size(); j++) {
			if (locationFound) return;
			if (!visited[graph[i].get(j)]) depthFirstSearch(graph, graph[i].get(j), comp, thisComponent);
			else if (!thisComponent.contains(graph[i].get(j))) {
				io.println(i+ " " + graph[i].get(j));
				locationFound = true;
			};
		}
		comp.push(i);
	}	
}
