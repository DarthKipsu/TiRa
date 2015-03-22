
import java.util.ArrayList;
import java.util.List;

/**
 * Find the n:th parent for a node in a tree.
 * 
 * The first input displays the number of nodes n and the following n-1 inputs
 * display the closest parent for a n:th node.
 * 
 * Next there's a number displaying how many queries q of parents there is and
 * the q next input pairs contain the node to start from and the number of nodes
 * to travel up. If there's no parent that high up, the program will print "QAQ"
 * for example:
 * 
 * 5
 * 1 1 3 3
 * 5
 * 4 2
 * 2 1
 * 5 3
 * 1 1
 * 5 1
 * 
 * Will produce the following output:
 * 
 * 1
 * 1
 * QAQ
 * QAQ
 * 3
 */
public class Henkilosto {
	
	private static IO io;
	private static List<Integer>[] parents;
	private static List<Integer>[] children;
	private static int n;

	public static void main(String[] args) {
		io = new IO();
		createTree();
		findParents();
		io.close();
	}

	private static void createTree() {
		n = io.nextInt();
		parents = new ArrayList[n + 1];
		children = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			parents[i] = new ArrayList<>();
			children[i] = new ArrayList<>();
		}
		for (int i = 2; i <= n; i++) {
			int parent = io.nextInt();
			parents[i].add(parent);
			children[parent].add(i);
		}
		for (Integer child : children[1]) {
			addParents(child);
		}
	}

	private static void addParents(int node) {
		for (int i = 1; parents[parents[node].get(i - 1)].size() > i - 1; i++) {
			parents[node].add(parents[parents[node].get(i - 1)].get(i - 1));
		}
		for (Integer child : children[node]) {
			addParents(child);
		}
	}

	private static void findParents() {
		int queries = io.nextInt();
		for (int i = 0; i < queries; i++) {
			int from = io.nextInt();
			int steps = io.nextInt();
			int iUp = (int)(Math.log(steps) / Math.log(2));
			steps -= Math.pow(2, iUp);
			while (steps > 0) {
				if (parents[from].size() <= iUp) break;
				from = parents[from].get(iUp);
				iUp = (int)(Math.log(steps) / Math.log(2));
				steps -= Math.pow(2, iUp);
			}
			if (parents[from].size() > iUp) {
				io.println(parents[from].get(iUp));
			} else  {
				io.println("QAQ");
			}
		}
	}
}
