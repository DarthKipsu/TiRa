import java.util.*;

public class Mediaani {
	
	private PriorityQueue<Integer> pienimmat;
	private  PriorityQueue<Integer> suurimmat;

	public Mediaani() {
		pienimmat = new PriorityQueue<Integer>(Collections.reverseOrder());
		suurimmat = new PriorityQueue<Integer>();
	}
    
    public void lisaaLuku(int luku) {
		if (suurimmat.size() != 0 && suurimmat.peek() < luku) {
			suurimmat.add(luku);
		} else {
			pienimmat.add(luku);
		}
		if (pienimmat.size() > suurimmat.size() + 1) {
			suurimmat.add(pienimmat.poll());
		}
		if (suurimmat.size() > pienimmat.size()) {
			pienimmat.add(suurimmat.poll());
		}
    }
    
    public int mediaani() {
		return pienimmat.peek();
    }
}
