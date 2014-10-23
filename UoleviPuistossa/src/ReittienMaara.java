
public class ReittienMaara implements Runnable {
	
	private final int kentta;
	private final int alkuX;
	private final int alkuY;
	private final int alkuMato;

	public ReittienMaara(int kentta, int x, int y, int alkuMato) {
		this.kentta = kentta;
		alkuX = x;
		alkuY = y;
		this.alkuMato = alkuMato;
	}

	@Override
	public void run() {
		reittienMaara(alkuX, alkuY, alkuMato);
	}
	
    public void reittienMaara(int x, int y, int mato) {
		Puisto.kentat[kentta][x][y] = true;
        if (y == 1 && x == Puisto.sivunPituus) {
//			tulosta(kentta);
            if (mato == Puisto.sivunPituus * Puisto.sivunPituus) {
                Puisto.vaihtoehdot[kentta]++;
            }
        } else if (ylanurkatOK(x, y)) {
            if (alas(x, y)) reittienMaara(x + 1, y, mato + 1);
            if (ylos(x,y)) reittienMaara(x - 1, y, mato + 1);
			if (oikealle(x, y)) reittienMaara(x, y + 1, mato + 1);
            if (vasemmalle(x, y)) reittienMaara(x, y - 1, mato + 1);
        }
		Puisto.kentat[kentta][x][y] = false;
    }
	
	private boolean ylanurkatOK(int x, int y) {
		if (Puisto.kentat[kentta][x - 1][y + 1] && Puisto.kentat[kentta][x - 1][y] == false 
				&& Puisto.kentat[kentta][x][y + 1] == false) return false;
		if (Puisto.kentat[kentta][x - 1][y - 1] && Puisto.kentat[kentta][x - 1][y] == false 
				&& Puisto.kentat[kentta][x][y - 1] == false) return false;
		if (Puisto.kentat[kentta][x + 1][y - 1] && Puisto.kentat[kentta][x + 1][y] == false && 
				Puisto.kentat[kentta][x][y - 1] == false) return false;
		return !(Puisto.kentat[kentta][x + 1][y + 1] && Puisto.kentat[kentta][x + 1][y] == false && 
				Puisto.kentat[kentta][x][y + 1] == false);
	}
	
	private boolean alas(int x, int y) {
		if (Puisto.kentat[kentta][x + 1][y]) return false;
		return !(Puisto.kentat[kentta][x][y-1] && Puisto.kentat[kentta][x][y+1] && Puisto.kentat[kentta][x - 1][y] == false);
	}

	private boolean ylos(int x, int y) {
		if (Puisto.kentat[kentta][x - 1][y]) return false;
		return !(Puisto.kentat[kentta][x][y-1] && Puisto.kentat[kentta][x][y+1] && Puisto.kentat[kentta][x + 1][y] == false);
	}

	private boolean oikealle(int x, int y) {
		if (Puisto.kentat[kentta][x][y + 1]) return false;
		return !(Puisto.kentat[kentta][x-1][y] && Puisto.kentat[kentta][x+1][y] && Puisto.kentat[kentta][x][y - 1] == false);
	}

	private boolean vasemmalle(int x, int y) {
		if (Puisto.kentat[kentta][x][y - 1]) return false;
		return !(Puisto.kentat[kentta][x-1][y] && Puisto.kentat[kentta][x+1][y] && Puisto.kentat[kentta][x][y + 1] == false);
	}
	
}
