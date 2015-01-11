import java.util.*;

public class Main {   
	
    public static void main(String[] args) {        
        Kokoelma k = new Kokoelma();
        k.lisaaLehti(3);
        k.lisaaLehti(4);
        k.lisaaLehti(3);
        System.out.println(k.eriNumerot());
        k.lisaaLehti(5);
        System.out.println(k.eriNumerot());
        k.lisaaLehti(3);
        System.out.println(k.eriNumerot());
    }        
}