
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Jattipizza {
	private static IO io;
	private static int n;
	private static List<Integer>[] nodes;
	private static List<Integer>[] reversed;
	private static List<Set<Integer>> components;
	private static boolean[] visited;
	private static Deque<Integer> order;
	private static char[] signs;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		int edgeCount = io.nextInt();
		visited = new boolean[n * 2 + 1];
		order = new ArrayDeque<>();
		nodes = new ArrayList[n * 2 + 1];
		reversed = new ArrayList[n * 2 + 1];
		for (int i = 1; i <= n * 2; i++) {
			nodes[i] = new ArrayList<>();
			reversed[i] = new ArrayList<>();
		}
		for (int i = 0; i < edgeCount; i++) {
			String sign = io.next();
			int from = io.nextInt() * 2;
			int fromNeg = from;
			if (sign.equals("-")) from--;
			else fromNeg--;
			sign = io.next();
			int to = io.nextInt() * 2;
			int toNeg = to;
			if (sign.equals("-")) to--;
			else toNeg--;
			nodes[fromNeg].add(to);
			nodes[toNeg].add(from);
			reversed[to].add(fromNeg);
			reversed[from].add(toNeg);
		}
		findConnectionsOrder();
		findComponents();
		if (truthSentenceCanBeFound()) {
			for (int i = 2; i <= n * 2; i += 2) {
				io.print(signs[i]);
				io.print(' ');
			}
		} else io.println("QAQ");
		io.close();
	}

	private static void findConnectionsOrder() {
		for (int i = 1; i <= n * 2; i++) {
			if (!visited[i]) depthFirstSearch(i);
		}
		visited = new boolean[n * 2 + 1];
	}

	private static void depthFirstSearch(int i) {
		visited[i] = true;
		for (int j = 0; j < nodes[i].size(); j++) {
			if (!visited[nodes[i].get(j)]) depthFirstSearch(nodes[i].get(j));
		}
		order.push(i);
	}

	private static void reverseGraph() {
		for (int i = 1; i <= n * 2; i++) {
			for (int j = 0; j < nodes[i].size(); j++) {
				reversed[nodes[i].get(j)].add(i);
			}
		}
	}

	private static void findComponents() {
		components = new ArrayList<>();
		for (int i = 0; i < n * 2; i++) {
			int computer = order.poll();
			if (!visited[computer]) {
				Set<Integer> component = new HashSet<>();
				depthFirstSearch(reversed, computer, component);
				components.add(component);
			}
		}
	}	
	
	private static void depthFirstSearch(List<Integer>[] graph, int i, Set<Integer> comp) {
		visited[i] = true;
		for (int j = 0; j < graph[i].size(); j++) {
			if (!visited[graph[i].get(j)]) depthFirstSearch(graph, graph[i].get(j), comp);
		}
		comp.add(i);
	}

	private static boolean truthSentenceCanBeFound() {
		signs = new char[n * 2 + 1];
		for (int i = 0; i < components.size(); i++) {
			char sign;
			int first = components.get(i).iterator().next();
			if (signs[first] == '\u0000') sign = '-';
			else sign = signs[first];
			for (Integer node : components.get(i)) {
				if (signs[node] == '\u0000') {
					signs[node] = '-';
					if (node % 2 == 0) signs[node - 1] = '+';
					else signs[node + 1] = '+';
				} else if (signs[node] != sign) return false;
			}
		}
		return true;
	}
}
