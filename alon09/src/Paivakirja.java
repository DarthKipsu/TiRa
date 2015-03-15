
public class Paivakirja {

	public static void main(String[] args) {
		IO io = new IO();
		String pk = io.next();
		String algo = io.next();
		StringBuilder sb = new StringBuilder(pk);
		int aHash = algo.hashCode();
		int n = algo.length() - 1;
		int i = n;
		while (i < sb.length()) {
			int sbHash = sb.substring(i - n, i + 1).hashCode();
			if (sbHash == aHash) {
				sb.delete(i - n, i + 1);
				i -= n + 1;
				if (i < n) i = n;
			}
			else i++;
		}
		io.println(sb.toString());
		io.close();
	}
	
}
