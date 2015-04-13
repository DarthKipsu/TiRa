
public class Suorakulmio {
	public static void main(String[] args) {
		IO io = new IO();
		int x = io.nextInt();
		int y = io.nextInt();
		if ((x + y > 2) && (x == 1 || y == 1 || x!= y)) io.println("Maija");
		else io.println("Uolevi");
		io.close();
	}
}
