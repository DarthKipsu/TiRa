
import java.util.ArrayList;
import java.util.List;

/**
 * Continuing from the last algorithm, this one will also keep track of any stalls
 * that have been removed from the original tree. Works in the same fashion, 
 * except for when making queries, it's also possible to remove a stall. For this,
 * all queries contain either number 1 (normal query) or 2 (remove the following
 * stall) before the rest of the parameters, for example:
 * 4
 * 1 2
 * 2 3
 * 2 4
 * 2
 * 1 3
 * 5
 * 1 1 4
 * 1 1 3
 * 1 2 4
 * 2 3
 * 1 1 3
 * Will produce output of:
 * 1
 * 2
 * 0
 * 1
 * Where the last number is 1 because a stall number 3 has been removed since
 * the last query.
 */
public class Tuhopolttaja {
	
	private static IO io;
	private static List<Integer>[] children;
	private static int[] lca;
	private static int[] nodesLca;
	private static int[] levels;
	private static int[] stalls;
	private static int[] sAbove;
	private static int[] nodesS;
	private static int[] nodesNS;
	private static int sI;
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
		levels = new int[n + 1];
		nodesS = new int[n + 1];
		nodesNS = new int[n + 1];
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
		if ((n & (n - 1)) == 0) lcaN = n;
		else lcaN = (int)Math.pow(2, 1 + (int)(Math.log(n) / Math.log(2)));
		lcaN *= 2;
		lca = new int[lcaN * 2];
		sAbove = new int[lcaN];
		lca[lcaN] = 1;
		lcaI = lcaN + 1;
		nodesLca[1] = lcaN;
		lcaN /= 2;
		nodesS[1] = 1;
		sI = 2;
		for (Integer child : children[1]) {
			addParents(child, 1, 1);
			lca[lcaI] = 1;
			lcaI++;
		}
		nodesNS[1] = sI - 1;
		int stallCount = io.nextInt();
		for (int i = 0; i < stallCount; i++) {
			stalls[nodesS[io.nextInt()]] = 1;
		}
		sAbove[lcaN] = stalls[1];
		for (Integer child : children[1]) {
			addParentStalls(child, 1);
		}
		createRestOfTheLCAtree();
	}

	private static void addParents(int node, int level, int parent) {
		levels[node] = level;
		lca[lcaI] = node;
		nodesS[node] = sI;
		sI++;
		if (nodesLca[node] == 0) nodesLca[node] = lcaI;
		lcaI++;
		for (Integer child : children[node]) {
			if (child != parent) {
				addParents(child, level + 1, node);
				lca[lcaI] = node;
				lcaI++;
			}
		}
		nodesNS[node] = sI - 1;
	}	

	private static void addParentStalls(int node, int parent) {
		sAbove[lcaN + nodesS[node] - 1] = sAbove[lcaN + nodesS[parent] - 1] + stalls[nodesS[node]];
		for (Integer child : children[node]) {
			if (child != parent) {
				addParentStalls(child, node);
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
			int type = io.nextInt();
			if (type == 1) {
				int start = io.nextInt();
				int end = io.nextInt();
				int ancestor = lowestCommonAncestor(
						Math.min(nodesLca[start], nodesLca[end]),
						Math.max(nodesLca[start], nodesLca[end]));
				printStallCount(start, end, ancestor);
			} else {
				int remove = io.nextInt();
				stalls[nodesS[remove]] = 0;
				changeStall(remove);
			}
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

	private static void printStallCount(int start, int end, int ancestor) {
		io.println(stallCoutn(nodesS[start]) + 
				   stallCoutn(nodesS[end]) - 2 *
				   stallCoutn(nodesS[ancestor]) +
				   stalls[nodesS[ancestor]]);
	}

	private static int stallCoutn(int b) {
		b += lcaN - 1;
		int count = sAbove[b];
		for (b /= 2; b > 0; b /= 2) {
			count += sAbove[b];
		}
		return count;
	}

	private static void changeStall(int del) {
		int until = lcaN + nodesNS[del] - 1;
		del = lcaN + nodesS[del] - 1;
		while (del <= until) {
			if (del % 2 == 1) sAbove[del++] -= 1;
			if (until % 2 == 0) sAbove[until--] -= 1;
			del /= 2;
			until /= 2;
		}
	}
}