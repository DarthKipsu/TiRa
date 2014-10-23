
import java.util.Scanner;

public class UoleviPuistossa {

	public static void main(String[] args) {
		
		Puisto laskuri = new Puisto();
		if (args.length != 0) {
			int sivu = Integer.parseInt(args[0]);
			System.out.println("Mahdollisia reitteja:" + laskuri.reittienMaara(sivu));
		} else {
			Scanner lukija = new Scanner(System.in);
			System.out.print("Anna puiston sivun pituus: ");
			int sivu = Integer.parseInt(lukija.nextLine());
		
			long reitit = laskuri.reittienMaara(sivu);
			System.out.println("Mahdollisia reitteja:" + reitit);
		}
		
//		LaskePinolla pino = new LaskePinolla();
//		
//		if (args.length != 0) {
//			int sivu = Integer.parseInt(args[0]);
//			System.out.println("Mahdollisia reitteja:" + pino.reittienMaara(sivu, 2));
//		} else {
//			Scanner lukija = new Scanner(System.in);
//			System.out.print("Anna puiston sivun pituus: ");
//			int sivu = Integer.parseInt(lukija.nextLine());
//			System.out.print("Anna threadien määrä: ");
//			int threadit = Integer.parseInt(lukija.nextLine());
//		
//			long reitit = pino.reittienMaara(sivu, threadit);
//			System.out.println("Mahdollisia reitteja:" + reitit);
//		}
		
//		if (args.length != 0) {
//			int sivu = Integer.parseInt(args[0]);
//			System.out.println("Mahdollisia reitteja:" + new Peilikuvat(sivu).reittienMaara());
//		} else {
//			Scanner lukija = new Scanner(System.in);
//			System.out.print("Anna puiston sivun pituus: ");
//			int sivu = Integer.parseInt(lukija.nextLine());
//		
//			long reitit = new Peilikuvat(sivu).reittienMaara();
//			System.out.println("Mahdollisia reitteja:" + reitit);
//		}
		
	}
	
}

