
public class Main {
	
	public static int hajautustaulu(String s) {
		int arvo = 0;
		for (int i=0; i<s.length(); i++) {
			arvo = arvo * 123 + s.charAt(i);
		}
		return arvo;
	}

	public static void main(String[] args) {
		System.out.println("Hajautusarvo stringille hajautus: " + hajautustaulu("hajautus"));
		System.out.println("Hajautusarvo stringille a: " + hajautustaulu("a"));
		System.out.println("Hajautusarvo stringille b: " + hajautustaulu("b"));
		System.out.println("Hajautusarvo stringille ba: " + hajautustaulu("ba"));
		System.out.println("Hajautusarvo stringille bÜ: " + hajautustaulu("aÜ"));
		System.out.println("(char) 220 = " + (char) 220);
	}
	
}
