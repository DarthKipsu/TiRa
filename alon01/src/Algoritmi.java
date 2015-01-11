
public class Algoritmi {

	public static void main(String[] args) {
		IO io = new IO();
		io.println(route(io.nextLong()));
		io.close();
	}
	
	public static String route(long value) {
		StringBuilder sb = new StringBuilder("" + value);
		while (value != 1) {
			if (value % 2 == 0) {
				value /= 2;
				addToStringBuilder(sb, value);
			} else {
				value = value * 3 + 1;
				addToStringBuilder(sb, value);
			}
		}
		return sb.toString();
	}

	private static void addToStringBuilder(StringBuilder sb, long value) {
		sb.append(" ");
		sb.append(value);
	}
	
}
