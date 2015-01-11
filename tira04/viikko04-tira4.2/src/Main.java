import java.util.*;

public class Main {    
    public static int laskin(String ohjelma) {
		Deque<Integer> pino = luoTyhjaPino();
		char[] komennot = ohjelma.toCharArray();

		suoritaOhjelma(komennot, pino);
		return pino.pop();
    }

	private static Deque<Integer> luoTyhjaPino() {
		Deque<Integer> pino = new ArrayDeque<Integer>();
		pino.push(1);
		return pino;
	}

	private static void suoritaOhjelma(char[] komennot, Deque<Integer> pino) {
		for (char komento : komennot) {
			if (komento == '@') {
				lisaaLuku(pino);
			} else {
				suoritaLasku(pino, komento);
			}
		}
	}

	private static void lisaaLuku(Deque<Integer> pino) {
		int ylinLuku = pino.peek();
		pino.push(ylinLuku);
	}

	private static void suoritaLasku(Deque<Integer> pino, char komento) {
		int luku1 = pino.pop();
		int luku2 = pino.pop();
		if (komento == '+') pino.push(luku1 + luku2);
		else if (komento == '*') pino.push(luku1 * luku2);
	}
    
    
    public static void main(String[] args) {
        System.out.println(laskin("@@+@*"));
        System.out.println(laskin("@+"));
        System.out.println(laskin("@@**"));
        System.out.println(laskin("@+@+@+"));
        System.out.println(laskin("@@@+++"));
    }        
}
