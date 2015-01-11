import java.util.*;

public class Main {   
    public static void main(String[] args) {
        Ystavat y = new Ystavat(3);
        System.out.println(y.lahjajako());
        y.lisaaYstavyys(1, 2);
        System.out.println(y.lahjajako());
        y.lisaaYstavyys(2, 3);
        System.out.println(y.lahjajako());
        y.lisaaYstavyys(1, 3);
        System.out.println(y.lahjajako());        
    }        
}