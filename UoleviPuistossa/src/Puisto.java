
public class Puisto {
	
	public static int sivunPituus;
	public static boolean[][][] kentat;
	public static long[] vaihtoehdot;

    public long reittienMaara(int sivu) {
		vaihtoehdot = new long[4];
		sivunPituus = sivu;
		kentat = new boolean [4][][];
		if (sivu < 4) {
			kentat[0] = rakennaKentta();
			new ReittienMaara(0, 1, 1, 1).run();
		} else {
			kentat[0] = rakennaKentta();
			kentat[1] = rakennaKentta();
			kentat[2] = rakennaKentta();
			kentat[3] = rakennaKentta();
			
			kentat[0][1][1] = true;
			kentat[0][2][1] = true;
			kentat[1][1][1] = true;
			kentat[1][2][1] = true;
			kentat[2][1][1] = true;
			kentat[2][1][2] = true;
			kentat[3][1][1] = true;
			kentat[3][1][2] = true;
			
			Thread thread1 = new Thread(new ReittienMaara(0, 3, 1, 3));
			Thread thread2 = new Thread(new ReittienMaara(1, 2, 2, 3));
			Thread thread3 = new Thread(new ReittienMaara(2, 2, 2, 3));
			Thread thread4 = new Thread(new ReittienMaara(3, 1, 3, 3));
			
			thread1.start();
			thread2.start();
			thread3.start();
			thread4.start();
			
			try {
				thread1.join();
			} catch (InterruptedException ex) {}
			try {
				thread2.join();
			} catch (InterruptedException ex) {}
			try {
				thread3.join();
			} catch (InterruptedException ex) {}
			try {
				thread4.join();
			} catch (InterruptedException ex) {}
			
		}
//		tulosta(kentta);
		return vaihtoehdot[0] + vaihtoehdot[1] + vaihtoehdot[2] + vaihtoehdot[3];
    }

	private boolean[][] rakennaKentta() {
		boolean[][] kentta = new boolean[sivunPituus + 2][sivunPituus + 2];
		for (int i=0; i<sivunPituus + 2; i++) {
			if (i == 0 || i == sivunPituus + 1) {
				for (int j=1; j< sivunPituus + 1; j++) kentta[i][j] = true;
			}
			kentta[i][0] = true;
			kentta[i][sivunPituus + 1] = true;
		}
		return kentta;
	}

	private void tulosta(boolean[][] taulukko) {
		for (int i=0; i<sivunPituus + 2; i++) {
			for (int j=0; j<sivunPituus + 2; j++) {
				System.out.print(i + "" + j + ":" + taulukko[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
