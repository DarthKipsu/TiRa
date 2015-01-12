
public class Kirjat {
	
	public static void main(String[] args) {
		IO io = new IO();
		
		int size = io.nextInt();
		String[] books = io.nextLine().split(" ");
		
		io.println(readingTime(books));
		io.close();
	}
	
	public static long readingTime(String[] books) {
		long totalLength = 0;
		long longest = 0;
		for (String book : books) {
			long length = Long.parseLong(book);
			totalLength += length;
			if (length > longest) longest = length;
		}
		if (longest > totalLength / 2) return longest * 2;
		return totalLength;
	}
	
}
