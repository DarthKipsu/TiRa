
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicLong;


public class LaskePinolla implements Runnable {
	
	private AtomicLong reittienMaara;
	private int sivunPituus;
	private ConcurrentLinkedDeque<Siirto> siirrot;

	@Override
	public void run() {
		long reitit = reittienMaara();
		reittienMaara.addAndGet(reitit);
	}
	
	public long reittienMaara(int sivu, int threadienMaara) {
		reittienMaara = new AtomicLong();
		Siirto lahto = new Siirto(new boolean[sivu*sivu], 0, 0, 1);
		sivunPituus = sivu;
		siirrot = new ConcurrentLinkedDeque<>();
		siirrot.push(lahto);
		
		Thread[] threadit = new Thread[threadienMaara];
		for (int i=0; i<threadienMaara; i++) {
			threadit[i] = new Thread(this);
			threadit[i].start();
		}
		
		for (int i=0; i<threadienMaara; i++) {
			try {
				threadit[i].join();
				System.out.println("Join");
			} catch (InterruptedException ex) {
			}
		}
		
		return reittienMaara.get();
	}
	
	private long reittienMaara() {
		
		long reitit = 0;
		Siirto siirto;
		
		while ((siirto = siirrot.poll()) != null) {
			boolean[] kentta = siirto.kentta();
			int x = siirto.koordinaatit()[0];
			int y = siirto.koordinaatit()[1];
			int mato = siirto.mato();
			kentta[x + y * sivunPituus] = true;
			
			if (x == sivunPituus - 1 && y == 0) {
				if (mato == sivunPituus * sivunPituus) {
					reitit++;
				}
			} else if (kannattaaJatkaa(x, y, kentta)) {
				if (vasen(x, y, kentta)) siirrot.add(new Siirto(kentta, x, y - 1, mato + 1));
				if (oikea(x, y, kentta)) siirrot.add(new Siirto(kentta, x, y + 1, mato + 1));
				if (ylos(x, y, kentta)) siirrot.add(new Siirto(kentta, x - 1, y, mato + 1));
				if (alas(x, y, kentta)) siirrot.add(new Siirto(kentta, x + 1, y, mato + 1));
			}
		}
		return reitit;
	}

	private boolean kannattaaJatkaa(int x , int y, boolean[] kentta) {
		if (sivunPituus > 4) return true;
		if (x > 2 && y < sivunPituus - 3 && kentta[x - 1 + (y + 1) * sivunPituus] &&
				kentta[x - 1 + y * sivunPituus] == false && kentta[x + (y + 1) * sivunPituus] == false) return false;
		if (x > 2 && y > 2 && kentta[x - 1 + (y - 1) * sivunPituus] &&
				kentta[x - 1 + y * sivunPituus] == false && kentta[x + (y - 1) * sivunPituus] == false) return false;
		if (x < sivunPituus - 3 && y > 2 && kentta[x + 1 + (y - 1) * sivunPituus] &&
				kentta[x + 1 + y * sivunPituus] == false && kentta[x + (y - 1) * sivunPituus] == false) return false;
		if (x < sivunPituus - 3 && y < sivunPituus - 3 && kentta[x + 1 + (y + 1) * sivunPituus] &&
				kentta[x + 1 + y * sivunPituus] == false && kentta[x + (y + 1) *sivunPituus] == false) return false;
		return true;
	}
	
	private boolean vasen(int x, int y, boolean[] kentta) {
		if (y == 0 || kentta[x + (y-1) * sivunPituus]) return false;
		if (x==0 || y < sivunPituus - 1 && (x == sivunPituus - 1 ||
				kentta[x-1 + y * sivunPituus] && kentta[x+1 + y * sivunPituus]) && kentta[x+ (y + 1) * sivunPituus] == false) {
			return false;
		}
		return y > 0;
	}
	
	private boolean oikea(int x, int y, boolean[] kentta) {
		if (y == sivunPituus - 1 || kentta[x + (y+1) * sivunPituus]) return false;
		if (x == sivunPituus - 1 || (y > 0 && (x == 0 || kentta[x-1 + y * sivunPituus] && kentta[x+1 + y * sivunPituus])
				&& kentta[x + (y - 1) * sivunPituus] == false)) {
			return false;
		}
		return y < sivunPituus - 1;
	}
	
	private boolean ylos(int x, int y, boolean[] kentta) {
		if (x == 0 || kentta[x - 1 + y * sivunPituus]) return false;
		if (y == 0 || y == sivunPituus - 1 || (kentta[x + (y-1) * sivunPituus] && kentta[x + (y+1) * sivunPituus]
				&& kentta[x + 1 + y * sivunPituus] == false)) {
			return false;
		}
		return x > 0;
	}
	
	private boolean alas(int x, int y, boolean[] kentta) {
		if (x == sivunPituus - 1 || kentta[x + 1 + y * sivunPituus]) return false;
		if (x > 0 && (y == 0 || y == sivunPituus - 1 || kentta[x+ (y-1) * sivunPituus] && kentta[x + (y+1) * sivunPituus])
				&& kentta[x - 1 + y * sivunPituus] == false) {
			return false;
		}
		return x < sivunPituus - 1;
	}
	
}
