
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class Postitus {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		io.nextInt();
		String[] residents = io.nextLine().split(" ");
		String[] wrongLetters = io.nextLine().split(" ");
		
		io.println(rounds(residents, wrongLetters));
		io.close();
	}

	public static int rounds(String[] residents, String[] wrongLetters) {
		Map<Integer, Integer> letters = new HashMap<>();
		int rounds = 0;
		for (int i = 0; i < residents.length; i++) {
			int res = Integer.parseInt(residents[i]);
			int let = Integer.parseInt(wrongLetters[i]);
			if (res == let) continue;
			if (letters.containsKey(res) && letters.get(res) == let) {
				rounds = 1;
			}
			else if (letters.containsKey(res)) {
				return 2;
			} else letters.put(let, res);
		}
		
		return rounds;
	}
	
}
