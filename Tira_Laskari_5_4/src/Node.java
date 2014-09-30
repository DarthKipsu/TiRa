
public class Node {
	
	private int level;
	private int value;
	private Node left;
	private Node right;

	public Node(int value, int level) {
		this.value = value;
		this.level = level;
		
		if (level > LevelCounter.highestLevel) {
			LevelCounter.highestLevel = level;
		}
	}

	public void addChildNode(int value) {
		if (value < this.value) {
			if (left == null) {
				left = new Node(value, level+1);
			} else {
				left.addChildNode(value);
			}
		} else {
			if (right == null) {
				right = new Node(value, level+1);
			} else {
				right.addChildNode(value);
			}
		}
	}
	
}
