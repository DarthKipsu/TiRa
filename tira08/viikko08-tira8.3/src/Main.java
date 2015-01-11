import java.util.*;

public class Main {
	
	private static TreeSet<Long> kahdenJaKolmenKertomat = new TreeSet<Long>();
	private static Long[] kertomatTaulukossa;
		
    public static long etsiTulo(int n) {
		ArrayList<Long> edelliset = new ArrayList<Long>();
		
		if (kahdenJaKolmenKertomat.isEmpty()) {
			kahdenJaKolmenKertomat.add(2L);
			kahdenJaKolmenKertomat.add(3L);
		}
		edelliset.add(2L);
		edelliset.add(3L);
		
		while (kahdenJaKolmenKertomat.size() < 1300) {
			long edellisetLast = edelliset.get(edelliset.size() - 1);
			ArrayList<Long> uudetEdelliset = new ArrayList<Long>();
			for (int i = 0; i <= edelliset.size(); i++) {
				if (i < edelliset.size()) {
					long next = edelliset.get(i) * 2;
					if (next <= edelliset.get(i)) break;
					kahdenJaKolmenKertomat.add(next);
					uudetEdelliset.add(next);
				} else {
					if (edellisetLast * 3 < edellisetLast) break;
					kahdenJaKolmenKertomat.add(edellisetLast * 3);
					uudetEdelliset.add(edellisetLast * 3);
				}
			}
			edelliset = uudetEdelliset;
		}
		if (kertomatTaulukossa == null) {
			kertomatTaulukossa = kahdenJaKolmenKertomat.toArray(new Long[0]);
		}
		return kertomatTaulukossa[n-1];
    }
    
    public static void main(String[] args) {
        System.out.println(etsiTulo(500));
        System.out.println(etsiTulo(5));
        System.out.println(etsiTulo(20));
        System.out.println(etsiTulo(49));
        System.out.println(etsiTulo(200));
    }        
}