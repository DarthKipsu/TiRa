
import java.util.ArrayList;
import java.util.List;

/**
 * Find the sum of distances from every node to every other node in a tree.
 * Input is the number of nodes in a tree following by edges between nodes,
 * for example:
 * 4
 * 1 2
 * 2 3
 * 2 4
 * Will produce an outcome of:
 * 5 
 * 3 
 * 5 
 * 5
 * Where each integer represents the distance from the i:th node to all the rest
 * of the nodes in the tree.
 */
public class Yhteismatka {

	private static IO io;
	private static int n;
	private static List<Integer>[] children;
	private static int[] subs;
	private static int[] dist;

	public static void main(String[] args) {
		io = new IO();
		n = io.nextInt();
		subs = new int[n + 1];
		dist = new int[n + 1];
		createTree();
		countSubTrees(1, 0, 0);
		for (Integer child : children[1]) {
			countDistances(child, 1);
		}
		printResults();
		io.close();
	}

	private static void createTree() {
		children = new List[n + 1];
		for (int i = 1; i <= n; i++) {
			children[i] = new ArrayList<>();
		}
		for (int i = 1; i < n; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			children[a].add(b);
			children[b].add(a);
		}
	}

	private static void countSubTrees(int node, int parent, int distance) {
		subs[node] = 1;
		dist[1] += distance;
		for (Integer child : children[node]) {
			if (child != parent) {
				countSubTrees(child, node, distance + 1);
				subs[node] += subs[child];
			}
		}
	}

	private static void countDistances(int node, int parent) {
		dist[node] = dist[parent] - subs[node] + subs[1] - subs[node];
		for (Integer child : children[node]) {
			if (child != parent) {
				countDistances(child, node);
			}
		}
	}

	private static void printResults() {
		for (int i = 1; i <= n; i++) {
			io.println(dist[i]);
		}
	}

}
