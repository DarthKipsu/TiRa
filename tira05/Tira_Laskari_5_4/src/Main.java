
import java.util.*;

public class Main {
	
	public static Node createTree(List<Integer> nodes) {
		Node root = new Node(nodes.get(0), 1);
		
		for (int i=1; i<nodes.size(); i++) {
			root.addChildNode(nodes.get(i));
		}
		
		return root;
	}

	public static void main(String[] args) {
		List<Integer> nodes1 = new ArrayList<>();
		List<Integer> nodes2 = new ArrayList<>();
		
		for (int i=0; i<10000; i++) {
			nodes1.add(i);
			nodes2.add(i);
		}
		
		Collections.shuffle(nodes2);
		
		LevelCounter.resetHighestLevel();
		Node tree1 = createTree(nodes1);
		System.out.println("Järjestetyssä puussa tasoja on: " + 
			LevelCounter.highestLevel);
		
		LevelCounter.resetHighestLevel();
		Node tree2 = createTree(nodes2);
		System.out.println("Sekoitetussa puussa tasoja on: " + 
			LevelCounter.highestLevel);
	}
	
}