import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Mediaani m = new Mediaani();
//        m.lisaaLuku(1);
//        System.out.println(m.mediaani());
//        m.lisaaLuku(5);
//        m.lisaaLuku(4);
//        System.out.println(m.mediaani());
		Mediaani m = new Mediaani();
        m.lisaaLuku(1);
        m.lisaaLuku(1);
        m.lisaaLuku(1);
        System.out.println(m.mediaani());
        m.lisaaLuku(2);
        m.lisaaLuku(2);
        m.lisaaLuku(2);
        System.out.println(m.mediaani());
        m.lisaaLuku(2);
		System.out.println(m.mediaani());
    }        
}