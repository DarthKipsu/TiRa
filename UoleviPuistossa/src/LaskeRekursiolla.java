
public class LaskeRekursiolla {
	
    private static long vaihtoehdot;
    private static boolean[][] kentta;
	private static int sivunPituus;

    public static long reittienMaara(int sivu) {
        vaihtoehdot = 0;
        kentta = new boolean[sivu + 2][sivu + 2];
		for (int i=0; i<sivu + 2; i++) {
			if (i == 0 || i == sivu + 1) {
				for (int j=1; j< sivu + 1; j++) kentta[i][j] = true;
			}
			kentta[i][0] = true;
			kentta[i][sivu + 1] = true;
		}
		sivunPituus = sivu;
//		tulosta(kentta);
        reittienMaara(1, 1, 1);
        return vaihtoehdot;
    }

    public static void reittienMaara(int x, int y, int mato) {
		kentta[x][y] = true;
        if (y == 1 && x == sivunPituus) {
//			tulosta(kentta);
            if (mato == sivunPituus * sivunPituus) {
                vaihtoehdot++;
            }
        } else if (ylanurkatOK(x, y)) {
            if (alas(x, y)) reittienMaara(x + 1, y, mato + 1);
            if (ylos(x,y)) reittienMaara(x - 1, y, mato + 1);
			if (oikealle(x, y)) reittienMaara(x, y + 1, mato + 1);
            if (vasemmalle(x, y)) reittienMaara(x, y - 1, mato + 1);
        }
		kentta[x][y] = false;
    }
	
	private static boolean ylanurkatOK(int x, int y) {
		if (kentta[x - 1][y + 1] && kentta[x - 1][y] == false 
				&& kentta[x][y + 1] == false) return false;
		if (kentta[x - 1][y - 1] && kentta[x - 1][y] == false 
				&& kentta[x][y - 1] == false) return false;
		if (kentta[x + 1][y - 1] && kentta[x + 1][y] == false && 
				kentta[x][y - 1] == false) return false;
		if (kentta[x + 1][y + 1] && kentta[x + 1][y] == false && 
				kentta[x][y + 1] == false) return false;
		return true;
	}
	
	private static boolean alas(int x, int y) {
		if (kentta[x + 1][y]) return false;
		return !(kentta[x][y-1] && kentta[x][y+1] && kentta[x - 1][y] == false);
	}

	private static boolean ylos(int x, int y) {
		if (kentta[x - 1][y]) return false;
		return !(kentta[x][y-1] && kentta[x][y+1] && kentta[x + 1][y] == false);
	}

	private static boolean oikealle(int x, int y) {
		if (kentta[x][y + 1]) return false;
		return !(kentta[x-1][y] && kentta[x+1][y] && kentta[x][y - 1] == false);
	}

	private static boolean vasemmalle(int x, int y) {
		if (kentta[x][y - 1]) return false;
		return !(kentta[x-1][y] && kentta[x+1][y] && kentta[x][y + 1] == false);
	}
	
	private static void tulosta(boolean[][] taulukko) {
		for (int i=0; i<sivunPituus + 2; i++) {
			for (int j=0; j<sivunPituus + 2; j++) {
				System.out.print(i + "" + j + ":" + taulukko[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
