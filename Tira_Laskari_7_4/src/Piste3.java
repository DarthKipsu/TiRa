
public class Piste3 {
	public int x;
	public int y;

	public Piste3(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x + y;		// = 0
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Piste3 other = (Piste3) obj;
		if (this.x != other.x) {
			return false;
		}
		return this.y == other.y;
	}
	
}
