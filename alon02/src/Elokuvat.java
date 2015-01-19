
import java.util.HashSet;
import java.util.Set;


public class Elokuvat {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		int size = io.nextInt();
		String[] movies = io.nextLine().split(" ");
		int[] moviesAsInt = new int[size];
		for (int i = 0; i < movies.length; i++) {
			moviesAsInt[i] = Integer.parseInt(movies[i]);
		}
		
		io.println(longestDistanceWithoutDoubles(moviesAsInt));
		io.close();
	}
	
	public static int longestDistanceWithoutDoubles(int[] movies) {
		int longest = 1;
		Set<Integer> moviesSeen = new HashSet<>();
		moviesSeen.add(movies[0]);
		for (int i = 1, i2 = 0; i < movies.length; i++) {
			if (moviesSeen.contains(movies[i])) {
				while (movies[i2] != movies[i]) {
					moviesSeen.remove(movies[i2]);
					i2++;
				}
				i2++;
			} else {
				moviesSeen.add(movies[i]);
				if (moviesSeen.size() > longest) {
					longest = moviesSeen.size();
				}
			}
		}
		return longest;
	}
}
