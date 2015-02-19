
import java.util.ArrayDeque;
import java.util.Deque;


public class Parkkipaikka {

	private static class Node {
		int steps;
		int from;
		int i;
		int j;

		public Node(int from, int i, int j, int steps) {
			this.steps = steps;
			this.from = from;
			this.i = i;
			this.j = j;
		}
	}

	private static IO io;
	private static int[][][] grid;
	private static int[][] directions;
	private static int height;
	private static int width;

	public static void main(String[] args) {
		io = new IO();
		createDirections();
		int[] u = createGraph();
		Deque<Node> deque = new ArrayDeque<>();
		if (grid[u[0]-1][u[1]-1][0] == 0) deque.add(new Node(8, u[0]-1, u[1]-1, 1));
		if (grid[u[0]-1][u[1]][0] == 0) deque.add(new Node(7, u[0]-1, u[1], 1));
		if (grid[u[0]-1][u[1]+1][0] == 0) deque.add(new Node(6, u[0]-1, u[1]+1, 1));

		while (!deque.isEmpty()) {
			Node node = deque.poll();
			int i = node.i;
			int j = node.j;
			int from = node.from;
			if (grid[i][j][from] == 1) continue;
			int[] dir = directions[node.from];
			int[] dest1 = grid[i + dir[3]][j + dir[4]];
			int[] dest2 = grid[i + dir[5]][j + dir[6]];
			int[] dest3 = grid[i + dir[7]][j + dir[8]];
			if (dest1[0] == 2 || dest2[0] == 2 || dest3[0] == 2) {
				io.print(node.steps);
				io.close();
				return;
			}
			if (dest1[0] == 0) deque.add(new Node(dir[0], i + dir[3], j + dir[4], node.steps + 1));
			if (dest2[0] == 0) deque.add(new Node(dir[1], i + dir[5], j + dir[6], node.steps + 1));
			if (dest3[0] == 0) deque.add(new Node(dir[2], i + dir[7], j + dir[8], node.steps + 1));
			grid[i][j][from] = 1;
		}
		io.println(0);
		io.close();
	}

	private static int[] createGraph() {
		height = io.nextInt() + 2;
		width = io.nextInt() + 2;
		grid = new int[height][width][9];
		int[] uolevi = new int[2];
		for (int i = 0; i < height; i++) {
			String row = "";
			if (i != 0 && i != height - 1) row = io.next();
			for (int j = 0; j < width; j++) {
				if (i == 0 || i == height - 1 || j == 0 || j == width - 1) grid[i][j][0] = 2;
				else {
					char c = row.charAt(j-1);
					if (c == '#') grid[i][j][0] = 1;
					if (c == 'U') {
						uolevi = new int[]{i, j};
						grid[i][j][7] = 1;
					}
				}
			}
		}
		return uolevi;
	}

	private static void createDirections() {
		directions = new int[9][9];
		directions[1] = new int[]{1, 2, 4, 1, 1, 1, 0, 0, 1};
		directions[2] = new int[]{1, 2, 3, 1, 1, 1, 0, 1, -1};
		directions[3] = new int[]{2, 3, 5, 1, 0, 1, -1, 0, -1};
		directions[4] = new int[]{1, 4, 6, 1, 1, 0, 1, -1, 1};
		directions[5] = new int[]{3, 5, 8, 1, -1, 0, -1, -1, -1};
		directions[6] = new int[]{4, 6, 7, 0, 1, -1, 1, -1, 0};
		directions[7] = new int[]{6, 7, 8, -1, 1, -1, 0, -1, -1};
		directions[8] = new int[]{5, 7, 8, 0, -1, -1, 0, -1, -1};
	}

}
