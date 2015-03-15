
import java.util.HashMap;

public class Palikkapino {
	private static IO io;
	private static HashMap<Character, Node> words;
	private static int nodes;
	
	private static class Node {
		char value;
		HashMap<Character, Node> children;

		public Node(char value) {
			this.value = value;
			children = new HashMap<>();
			nodes++;
		}

		public Node addChild(char childValue) {
			if (!children.containsKey(childValue)) children.put(childValue, new Node(childValue));
			return children.get(childValue);
		}
	}	
	
	public static void main(String[] args) {
		io = new IO();
		words = new HashMap<>();
		nodes = 0;
		int wordCount = io.nextInt();
		for (int i = 0; i < wordCount; i++) {
			String word = io.next();
			char c = word.charAt(word.length() - 1);
			if (!words.containsKey(c)) words.put(c, new Node(c));
			Node parent = words.get(c);
			for (int j = word.length() - 2; j >= 0; j--) {
				c = word.charAt(j);
				parent = parent.addChild(c);
			}
		}
		io.println(nodes * 2);
		io.close();
	}
}
