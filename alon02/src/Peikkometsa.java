
public class Peikkometsa {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		int[][] forest = new int[io.nextInt() + 1][io.nextInt() + 1];
		for (int i = 1; i < forest.length; i++) {
			String trolls = io.nextLine();
			for (int j = 1; j < forest[i].length; j++) {
				if (trolls.charAt(j - 1) == '.') {
					forest[i][j] = forest[i][j-1] + forest[i-1][j] - forest[i-1][j-1];
				}
				else forest[i][j] = forest[i-1][j] + forest[i][j-1] - forest[i-1][j-1] + 1;
			}
		}
		
		int queries = io.nextInt();
		int safe = 0;
		for (int i = 0; i < queries; i++) {
			int fY = io.nextInt();
			int fX = io.nextInt();
			int sY = io.nextInt();
			int sX = io.nextInt();
			int area = forest[sY][sX] - forest[sY][fX-1] - forest[fY-1][sX] + forest[fY-1][fX-1];
			if (area == 0) safe++;
		}
		io.println(safe);
		io.close();
	}
	
}
