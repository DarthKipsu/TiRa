
public class Main {

	public static void main(String[] args) {
		Puu puu = new Puu(1,
				new Puu(3,
						new Puu(2, null, null),
						null),
				new Puu(3,
						new Puu(3, null, null),
						new Puu(2, null, null)));

		BTreePrinter.printNode(puu);
	}

}
