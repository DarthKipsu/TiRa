
public class Ruudukko {

	public static void main(String[] args) {
		IO io = new IO();
		int size = io.nextInt();
		String[][] merkit = new String[size][size];
		for (int i = 0; i < size; i++) {
			String rivi = io.next();
			for (int j = 0; j < size; j++) {
				String reitti;
				if (i == 0) {
					if (j == 0) reitti = "";
					else reitti = merkit [i][j - 1];
				} else {
					if (j == 0) reitti = merkit[i - 1][j];
					else if (merkit[i - 1][j].compareTo(merkit[i][j - 1]) < 0) reitti = merkit[i - 1][j];
					else reitti = merkit[i][j - 1];
				}
				merkit[i][j] = reitti + rivi.charAt(j);
			}
		}
		io.println(merkit[size - 1][size - 1]);
		io.close();
	}
	
}
