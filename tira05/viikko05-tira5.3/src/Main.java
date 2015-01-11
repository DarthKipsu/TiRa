import java.util.*;

public class Main {  
    public static boolean samanlaiset(Puu a, Puu b) {
		return a.equals(b);
    }
    
    public static void main(String[] args) {        
        Puu puu1 = new Puu(1,
                           new Puu(3,
                                   new Puu(2, null, null),
                                   new Puu(1, null, null)),
                           new Puu(3,
                                   new Puu(3, null, null),
                                   new Puu(2, null, null)));

        Puu puu2 = new Puu(1,
                           new Puu(3,
                                   new Puu(2, null, null),
                                   new Puu(1, null, null)),
                           new Puu(3,
                                   new Puu(3, null, null),
                                   new Puu(2, null, null)));
        
        System.out.println(samanlaiset(puu1, puu2));
    }        
}