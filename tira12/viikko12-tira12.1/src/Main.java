
public class Main {
	
	
    public static void main(String[] args) {
        Ystavat y = new Ystavat(4);
        System.out.println(y.suurinRyhma());
        y.lisaaYstavyys(1, 2);
        System.out.println(y.suurinRyhma());
        y.lisaaYstavyys(3, 4);
        System.out.println(y.suurinRyhma());
        y.lisaaYstavyys(1, 4);
        System.out.println(y.suurinRyhma());
    }        
}