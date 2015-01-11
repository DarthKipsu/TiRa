import java.util.*;

public class Main {       
    public static void main(String[] args) {
        PisinToisto etsija = new PisinToisto("AABBBA");
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(3); // AABABA
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(0); // BABABA
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(2); // BAAABA
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(4); // BAAAAA
        System.out.println(etsija.pisinToisto());
		System.out.println();
		
        etsija = new PisinToisto("AAAAAA");
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(0);
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(2); 
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(4); 
        System.out.println(etsija.pisinToisto());
		System.out.println();
		
        etsija = new PisinToisto("ABA");
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(0); // BBA
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(0); // ABA
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(1); // AAA
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(1); // ABA
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(2); // ABB
        System.out.println(etsija.pisinToisto());
        etsija.muutaMerkki(2); // ABA
        System.out.println(etsija.pisinToisto());
    }
    
}