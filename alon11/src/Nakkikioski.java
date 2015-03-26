
import java.util.ArrayList;
import java.util.List;

/**
 * Calculates the amount of stalls in a route from node a to b in a tree structure.
 * The first input is the number of nodes n in the tree, following pairs representing
 * edges between nodes. The count of edges is n-1 to make a complete tree. Then 
 * a number of stalls in the tree and each node containing a stall is given.
 * 
 * Finally the next input is the number of queries to be made for the tree, following
 * a start and end node, to calculate the number of stalls between them two. For
 * example the input:
 * 
 * 4
 * 1 2
 * 2 3
 * 2 4
 * 2
 * 1 3
 * 3
 * 1 4
 * 1 3
 * 2 4
 * 
 * Will produce output of:
 * 1
 * 2
 * 0
 * 
 * Showing that the route from 1->4 has 1 stall, the route between 1->3 has two
 * stalls and the final route 2->4 has none.
 */
public class Nakkikioski {

	private static IO io;
	private static List<Integer>[] children;
	private static int[] lca;
	private static int[] nodesLca;
	private static int[] levels;
	private static int[] stalls;
	private static int[] sAbove;
	private static int lcaI;
	private static int lcaN;
	private static int n;

	public static void main(String[] args) {
		io = new IO();
		createTree();
		countStalls();
		io.close();
	}

	private static void createTree() {
		n = io.nextInt();
		children = new ArrayList[n + 1];
		stalls = new int[n + 1];
		sAbove = new int[n + 1];
		levels = new int[n + 1];
		nodesLca = new int[n + 1];
		levels[0] = Integer.MAX_VALUE;
		for (int i = 0; i <= n; i++) {
			children[i] = new ArrayList<>();
		}
		for (int i = 2; i <= n; i++) {
			int a = io.nextInt();
			int b = io.nextInt();
			children[a].add(b);
			children[b].add(a);
		}
		int stallCount = io.nextInt();
		for (int i = 0; i < stallCount; i++) {
			stalls[io.nextInt()] = 1;
		}
		sAbove[1] = stalls[1];
		if ((n & (n - 1)) == 0) lcaN = n;
		else lcaN = (int)Math.pow(2, 1 + (int)(Math.log(n) / Math.log(2)));
		lca = new int[lcaN * 4];
		lca[lcaN * 2] = 1;
		lcaI = lcaN * 2 + 1;
		nodesLca[1] = lcaN * 2;
		for (Integer child : children[1]) {
			addParents(child, 1, 1);
			lca[lcaI] = 1;
			lcaI++;
		}
		createRestOfTheLCAtree();
	}

	private static void addParents(int node, int level, int parent) {
		sAbove[node] = sAbove[parent] + stalls[node];
		levels[node] = level;
		lca[lcaI] = node;
		if (nodesLca[node] == 0) nodesLca[node] = lcaI;
		lcaI++;
		for (Integer child : children[node]) {
			if (child != parent) {
				addParents(child, level + 1, node);
				lca[lcaI] = node;
				lcaI++;
			}
		}
	}	

	private static void createRestOfTheLCAtree() {
		for (int i = lcaN; i > 0; i /= 2) {
			for (int j = 0; j < i; j++) {
				int k = i + j;
				int a = lca[k * 2];
				int b = lca[k * 2 + 1];
				lca[k] = levels[a] < levels[b] ? a : b;
			}
		}
	}

	private static void countStalls() {
		int queries = io.nextInt();
		for (int i = 0; i < queries; i++) {
			int start = io.nextInt();
			int end = io.nextInt();
			int ancestor = lowestCommonAncestor(
					Math.min(nodesLca[start], nodesLca[end]),
					Math.max(nodesLca[start], nodesLca[end]));
			io.println(sAbove[start] + sAbove[end] - 2 * sAbove[ancestor] + stalls[ancestor]);
		}
	}

	private static int lowestCommonAncestor(int a, int b) {
		int ancestor = lca[a];
		while(a <= b) {
			if (a % 2 == 1) ancestor = levels[lca[a++]] < levels[ancestor] ? lca[a - 1] : ancestor;
			if (b % 2 == 0) ancestor = levels[lca[b--]] < levels[ancestor] ? lca[b + 1] : ancestor;
			a /= 2;
			b /= 2;
		}
		return ancestor;
	}
}
