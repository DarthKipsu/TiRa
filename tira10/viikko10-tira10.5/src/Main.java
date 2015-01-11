import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Lentoreitit x = new Lentoreitit(4, new int[] {1, 1}, new int[] {2, 3});
//        System.out.println(x.mahdollinen(1, 2, 1));
//        System.out.println(x.mahdollinen(1, 1, 4));
//        System.out.println(x.mahdollinen(1, 2, 2));
//        System.out.println(x.mahdollinen(1, 4, 3));
//        System.out.println();
//		
//        int n = 4;
//        int[] mista = {1, 2, 3, 4};
//        int[] mihin = {2, 3, 4, 1};
//        Lentoreitit x2 = new Lentoreitit(n, mista, mihin);
//		System.out.println(x2.mahdollinen(1, 3, 2));
		
		int n = 100;
        int q = 100000;
        int[] mista = new int[n*n/4];
        int[] mihin = new int[n*n/4];
        int c = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (i%2 == j%2) continue;
                mista[c] = i;
                mihin[c] = j;
                c++;
            }
        }
        Lentoreitit x = new Lentoreitit(n, mista, mihin);
		Long alku = System.nanoTime();
		for (int i = 0; i < q; i++) {
            int a = (int)(Math.random()*100)+1;
            int b = (int)(Math.random()*100)+1;
            int z = (int)(Math.random()*1000000000)+1;
            x.mahdollinen(a, b, z);
        }
		Long loppu = System.nanoTime();
		System.out.println("Kesto: " + (loppu - alku)/1000000.0 + " ms");
	
    }        
}