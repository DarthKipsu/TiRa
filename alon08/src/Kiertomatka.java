
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Kiertomatka {
	private static IO io;
	private static int n;
	private static List<Integer>[] edges;
	private static List<Integer>[] edgesRev;
	private static List<Deque<Integer>> components;
	private static List<Integer>[] compEndges;
	private static int[] compLocation;
	private static boolean[] visited;
	private static int[] reach;
	private static Deque<Integer> order;
	private static int maxCities;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		int edgeCount = io.nextInt();
		visited = new boolean[n + 1];
		order = new ArrayDeque<>();
		edges = new ArrayList[n + 1];
		edgesRev = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			edges[i] = new ArrayList<>();
			edgesRev[i] = new ArrayList<>();
		}
		for (int i = 0; i < edgeCount; i++) {
			int from = io.nextInt();
			int to = io.nextInt();
			edges[from].add(to);
			edgesRev[to].add(from);
		}
		findConnectionsOrder();
		findComponents();
		sumCities();
		io.println(maxCities);
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
		for (int j = 0; j < edges[i].size(); j++) {
			if (!visited[edges[i].get(j)]) depthFirstSearch(edges[i].get(j));
		}
		order.push(i);
	}

	private static void findComponents() {
		components = new ArrayList<>();
		compEndges = new ArrayList[n + 1];
		compLocation = new int[n + 1];
		int currentComponent = 0;
		for (int i = 0; i < n; i++) {
			int computer = order.poll();
			if (!visited[computer]) {
				Deque<Integer> component = new ArrayDeque<>();
				Set<Integer> thisComponent = new HashSet<>();
				compEndges[currentComponent] = new ArrayList<>();
				depthFirstSearch(edgesRev, computer, component, thisComponent, currentComponent);
				components.add(component);
				currentComponent++;
			}
		}
	}

	private static void depthFirstSearch(List<Integer>[] graph, int i, Deque<Integer> comp, Set<Integer> thisComponent, int location) {
		compLocation[i] = location;
		visited[i] = true;
		thisComponent.add(i);
		for (int j = 0; j < graph[i].size(); j++) {
			if (!visited[graph[i].get(j)]) depthFirstSearch(graph, graph[i].get(j), comp, thisComponent, location);
			else if (!thisComponent.contains(graph[i].get(j))) {
				compEndges[compLocation[graph[i].get(j)]].add(location);
			};
		}
		comp.push(i);
	}

	private static void sumCities() {
		visited = new boolean[components.size()];
		reach = new int[components.size()];
		maxCities = 0;
		for (int i = 0; i < components.size(); i++) {
			int sum = findSum(i);
			if (sum > maxCities) maxCities = sum;
		}
	}

	private static int findSum(int i) {
		if (reach[i] > 0) return reach[i];
		else if (compEndges[i].isEmpty()) {
			reach[i] = components.get(i).size();
			return reach[i];
		} else if (compEndges[i].size() == 1) {
			reach[i] = components.get(i).size() + findSum(compEndges[i].get(0));
			return components.get(i).size() + findSum(compEndges[i].get(0));
		} else {
			int biggest = 0;
			for (int j = 0; j < compEndges[i].size(); j++) {
				int targetSize = findSum(compEndges[i].get(j));
				if (targetSize > biggest) biggest = targetSize;
			}
			return components.get(i).size() + biggest;
		}
	}
}
