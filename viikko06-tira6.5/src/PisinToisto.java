import java.util.*;
 
public class PisinToisto {
	
	private TreeMap<Integer, Integer> indeksit;
	private int viimeinen;
    
    public PisinToisto(String mjono) {
		indeksit = new TreeMap<Integer, Integer>();
		viimeinen = mjono.length() - 1;
		luoPuu(mjono);
    }
	
	private void luoPuu(String mjono) {
		int alku = 0;
		for (int i=1; i<mjono.length(); i++) {
			if (mjono.charAt(i) != mjono.charAt(i-1)) {
				indeksit.put(alku, i-alku);
				alku = i;
			}
		}
		indeksit.put(alku, mjono.length() - alku);
	}
	
    public void muutaMerkki(int kohta) {
		Integer edellinen = indeksit.lowerKey(kohta);
		Integer seuraava = indeksit.higherKey(kohta);
		boolean onAlku = indeksit.containsKey(kohta);
		
		if (kohta == 0) {
			if (indeksit.containsKey(1)) {
				indeksit.replace(0, indeksit.get(1) + 1);
				indeksit.remove(1);
			} else {
				indeksit.put(1, indeksit.get(0) - 1);
				indeksit.replace(0, 1);
			}
		} else if (kohta == viimeinen) {
			if (indeksit.containsKey(kohta)) {
				indeksit.remove(kohta);
				indeksit.replace(edellinen, indeksit.get(edellinen) + 1);
			} else {
				indeksit.replace(edellinen, indeksit.get(edellinen) - 1);
				indeksit.put(kohta, 1);
			}
		} else if (onAlku) {
			if (seuraava != null && seuraava == kohta + 1) {
				indeksit.replace(edellinen, indeksit.get(seuraava) + indeksit.get(edellinen) + 1);
				indeksit.remove(kohta);
				indeksit.remove(kohta + 1);
			} else {
				indeksit.replace(edellinen, indeksit.get(edellinen) + 1);
				indeksit.put(kohta + 1, indeksit.get(kohta) - 1);
				indeksit.remove(kohta);
			}
		} else {
			indeksit.replace(edellinen, kohta - edellinen);
			if (seuraava != null && seuraava != kohta + 1) {
				indeksit.put(kohta, 1);
				indeksit.put(kohta + 1, seuraava - kohta - 1);
			} else if (seuraava == null) {
				indeksit.put(kohta, 1);
				indeksit.put(kohta + 1, viimeinen - kohta);
			} else {
				indeksit.put(kohta, indeksit.get(kohta + 1));
				indeksit.remove(kohta + 1);
			}
		}
	}

    public int pisinToisto() {
		List<Integer> pituudet = new ArrayList<Integer>(indeksit.values());
		Collections.sort(pituudet);
		return pituudet.get(pituudet.size() - 1);
    }
}
