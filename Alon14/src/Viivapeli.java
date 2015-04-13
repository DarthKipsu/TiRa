
public class Viivapeli {
	public static void main(String[] args) {
		IO io = new IO();
		int x = io.nextInt();
		int y = io.nextInt();
		if ((x + y) % 2 == 0) io.println("Uolevi");
		else io.println("Maija");
		io.close();
	}
	
}
