
import java.util.Scanner;

public class Main {

    private static long vaihtoehdot;
    private static boolean[][] kentta;
	private static int sivunPituus;

    public static long reittienMaara(int sivu) {
        vaihtoehdot = 0;
        kentta = new boolean[sivu][sivu];
		sivunPituus = sivu;
        reittienMaara(0, 0, 1);
        return vaihtoehdot;
    }

    public static void reittienMaara(int x, int y, int mato) {
        if (kentta[x][y] == true) return;
		kentta[x][y] = true;
        if (y == 0 && x == sivunPituus - 1) {
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
		if (sivunPituus > 4) return true;
		if (x > 2 && y < sivunPituus - 3 && kentta[x - 1][y + 1] &&
				kentta[x - 1][y] == false && kentta[x][y + 1] == false) return false;
		if (x > 2 && y > 2 && kentta[x - 1][y - 1] &&
				kentta[x - 1][y] == false && kentta[x][y - 1] == false) return false;
		if (x < sivunPituus - 3 && y > 2 && kentta[x + 1][y - 1] &&
				kentta[x + 1][y] == false && kentta[x][y - 1] == false) return false;
		if (x < sivunPituus - 3 && y < sivunPituus - 3 && kentta[x + 1][y + 1] &&
				kentta[x + 1][y] == false && kentta[x][y + 1] == false) return false;
		return true;
	}
	
	private static boolean alas(int x, int y) {
		if (x > 0 && (y == 0 || y == sivunPituus - 1 || kentta[x][y-1] && kentta[x][y+1])
				&& kentta[x - 1][y] == false) {
			return false;
		}
		return x < sivunPituus - 1;
	}

	private static boolean ylos(int x, int y) {
		if (y == 0 || y == sivunPituus - 1 || (kentta[x][y-1] && kentta[x][y+1]
				&& kentta[x + 1][y] == false)) {
			return false;
		}
		return x > 0;
	}

	private static boolean oikealle(int x, int y) {
		if (x == sivunPituus - 1 || (y > 0 && (x == 0 || kentta[x-1][y] && kentta[x+1][y])
				&& kentta[x][y - 1] == false)) {
			return false;
		}
		return y < sivunPituus - 1;
	}

	private static boolean vasemmalle(int x, int y) {
		if (x==0 || y < sivunPituus - 1 && (x == sivunPituus - 1 ||
				kentta[x-1][y] && kentta[x+1][y]) && kentta[x][y + 1] == false) {
			return false;
		}
		return y > 0;
	}

	public static void main(String[] args) {
		
		if (args.length != 0) {
			int sivu = Integer.parseInt(args[0]);
			System.out.println("Mahdollisia reitteja:" + reittienMaara(sivu));
		} else {
			Scanner lukija = new Scanner(System.in);
			System.out.print("Anna puiston sivun pituus: ");
			int sivu = Integer.parseInt(lukija.nextLine());
		
			long reitit = reittienMaara(sivu);
			System.out.println("Mahdollisia reitteja:" + reitit);
		}
		
	}
	
}

