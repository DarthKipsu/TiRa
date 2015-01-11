import java.util.*;

public class Main {   
    public static void main(String[] args) {        
        Toimisto t = new Toimisto();
        t.lisaaJonoon("Uolevi");
        t.lisaaJonoon("Maija");
        System.out.println(t.annaAsunto());
        t.lisaaJonoon("Liisa");
        System.out.println(t.annaAsunto());
        System.out.println(t.annaAsunto());
    }        
}