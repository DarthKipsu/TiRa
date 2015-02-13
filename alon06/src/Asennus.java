
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


public class Asennus {
	
	private static IO io;
	private static List[] verkko;
	private static int[] kaariLkm;
	private static Queue<Integer> kaarettomat;
	private static int[] jarjestys;
	
	public static void main(String[] args) {
		io = new IO();
		int ohjelmat = io.nextInt();
		int riippuvuudet = io.nextInt();
		luoVerkko(ohjelmat, riippuvuudet);
		etsiJarjestys();
		if (jarjestys[ohjelmat - 1] == 0)  io.print("QAQ");
		else {
			for (int i = 0; i < jarjestys.length; i++) {
				io.print(jarjestys[i] + " ");
			}
		}
		io.close();
	}
	
	public static void luoVerkko(int solmut, int kaaret) {
		verkko = new ArrayList[solmut + 1];
		kaariLkm = new int[solmut + 1];
		kaarettomat = new PriorityQueue<>();
		jarjestys = new int[solmut];
		
		for (int i = 1; i <= solmut; i++) verkko[i] = new ArrayList();
		for (int i = 0; i < kaaret; i++) {
			int riippuvuus = io.nextInt();
			int solmu = io.nextInt();
			verkko[riippuvuus].add(solmu);
			kaariLkm[solmu]++;
		}
		for (int i = 1; i <= solmut; i++) {
			if (kaariLkm[i] == 0) kaarettomat.add(i);
		}
	}
	
	public static void etsiJarjestys() {
		for (int i = 0; i < jarjestys.length; i++) {
			if (kaarettomat.isEmpty()) return;
			int solmu = kaarettomat.poll();
			for (int j = 0; j < verkko[solmu].size(); j++) {
				int riippuvainen = (int)verkko[solmu].get(j);
				kaariLkm[riippuvainen]--;
				if (kaariLkm[riippuvainen] == 0) kaarettomat.add(riippuvainen);
			}
			jarjestys[i] = solmu;
		}
	}
	
}
