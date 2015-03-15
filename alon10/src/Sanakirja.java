
import java.util.HashMap;


public class Sanakirja {

	private static class Node {
		char value;
		int childCount;
		HashMap<Character, Node> children;

		public Node(char value) {
			this.value = value;
			childCount = 0;
			children = new HashMap<>();
		}

		public Node addChild(char childValue) {
			childCount++;
			if (!children.containsKey(childValue)) children.put(childValue, new Node(childValue));
			return children.get(childValue);
		}

		public boolean isUnambigious() {
			return childCount < 2;
		}

		public Node getChild(char childValue) {
			if (childCount == 0) return null;
			return children.get(childValue);
		}
	}

	private static IO io;
	private static HashMap<Character, Node> dictionary;

	public static void main(String[] args) {
		io = new IO();
		fillDictionary();
		io.println(countTypedLetters());
		io.close();
	}

	private static void fillDictionary() {
		dictionary = new HashMap<>();
		int words = io.nextInt();
		for (int i = 0; i < words; i++) {
			String word = io.next();
			char c = word.charAt(0);
			if (!dictionary.containsKey(c)) dictionary.put(c, new Node(c));
			Node parent = dictionary.get(c);
			for (int j = 1; j < word.length(); j++) {
				c = word.charAt(j);
				parent = parent.addChild(c);
			}
		}
	}

	private static int countTypedLetters() {
		int messageWords = io.nextInt();
		int letterCount = 0;
		for (int i = 0; i < messageWords; i++) {
			String word = io.next();
			char c = word.charAt(0);
			Node parent = dictionary.get(c);
			letterCount++;
			if (word.length() == 1) letterCount++;
			if (parent.isUnambigious()) continue;
			for (int j = 1; j < word.length(); j++) {
				c = word.charAt(j);
				letterCount++;
				parent = parent.getChild(c);
				if (parent == null || parent.isUnambigious()) break;
			}
		}
		return letterCount;
	}
	
}
