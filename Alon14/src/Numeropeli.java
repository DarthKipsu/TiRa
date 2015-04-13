
public class Numeropeli {

	public static void main(String[] args) {
		IO io = new IO();
		int luku = io.nextInt();
		if (luku % 10 == 0) {
			io.println("Uolevi");
		} else {
			io.println("Maija");
		}
		io.close();
	}
	
}
