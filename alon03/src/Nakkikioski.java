
import java.util.ArrayList;
import java.util.List;


public class Nakkikioski {
	
	public static void main(String[] args) {
		IO io = new IO();
		int kyselyt = io.nextInt();
		List<Integer> jono = new ArrayList<>();
		for (int i = 0; i < kyselyt; i++) {
			int kysely = io.nextInt();
			if (kysely == 1) {
				jono.add(io.nextInt());
			} else if (kysely == 2) {
				io.println(jono.get(io.nextInt() - 1));
			} else if (kysely == 3) {
				jono.remove(0);
			} else if (kysely == 4) {
				jono.remove(io.nextInt() - 1);
			}
		}
		io.close();
	}
	
}
