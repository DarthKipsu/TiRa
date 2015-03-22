
import java.util.ArrayList;
import java.util.List;

/**
 * Find the furthest nodes from each other from tree with two DFS.
 * 
 * The first input needs to be the number of nodes, n and after that n-1 times
 * the edges between nodes for example:
 * 5
 * 1 2
 * 1 3
 * 3 4
 * 3 5
 * Will produce 3 as the furthest distance between any two nodes in that tree is
 * from node 2 -> 4 which are 3 edges apart.
 */
public class Riita {
	private static IO io;
	private static List<Integer>[] tree;
	private static boolean[] visited;
	private static int distance;
	private static int last;

	public static void main(String[] args) {
		io = new IO();
		createTree();
		visited = new boolean[tree.length];
		distance = 0;
		last = 1;
		depthFirstSearch(1, 0);
		visited = new boolean[tree.length];
		depthFirstSearch(last, 0);
		io.println(distance);
		io.close();
	}

	private static void createTree() {
		int nodes = io.nextInt();
		tree = new ArrayList[nodes + 1];
		for (int i = 0; i <= nodes; i++) {
			tree[i] = new ArrayList();
		}
		for (int i = 1; i < nodes; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			tree[a].add(b);
			tree[b].add(a);
		}
	}

	private static void depthFirstSearch(int node, int dist) {
		if (visited[node]) return;
		visited[node] = true;
		if (dist > distance) {
			last = node;
			distance = dist;
		}
		for (int child : tree[node]) {
			depthFirstSearch(child, dist + 1);
		}
	}
	
}
