import java.util.*;

public class Main {
	private static String preOrder;
	
    public static String jalki(String esi, String sisa) {
		preOrder = esi;
		Puu puu = createSubTree(sisa);
		return postOrder(puu);		
    }
	
	private static Puu createSubTree(String sisa) {
		char value = preOrder.charAt(0);
		int iValue = sisa.indexOf(value);
		preOrder = preOrder.substring(1);
		
		if (sisa.length() == 1) {
			return new Puu(sisa.charAt(0), null, null);
		} else {
			return new Puu(
					value,
					leftTree(iValue, sisa),
					rightTree(iValue, sisa)
			);
		}
	}

	private static Puu leftTree(int iValue, String sisa) {
		Puu leftTree = null;
		if (iValue > 0) {
			String left = sisa.substring(0, iValue);
			leftTree = createSubTree(left);
		}
		return leftTree;
	}
	
	private static Puu rightTree(int iValue, String sisa) {
		Puu rightTree = null;
		if (iValue < sisa.length()-1) {
			String right = sisa.substring(iValue+1);
			rightTree = createSubTree(right);
		}
		return rightTree;
	}

	private static String postOrder(Puu puu) {
		String left = "";
		String right = "";
		if (puu.vasen != null) left = postOrder(puu.vasen);
		if (puu.oikea != null) right = postOrder(puu.oikea);
		return left + right + puu.arvo;
	}
    
    public static void main(String[] args) {        
        System.out.println(jalki("BDACE", "DBCAE"));
        System.out.println(jalki("ABCD", "DCBA"));
        System.out.println(jalki("ABCD", "ACDB"));
        System.out.println(jalki("GEABFCD", "AEBGCFD"));
    }        
}