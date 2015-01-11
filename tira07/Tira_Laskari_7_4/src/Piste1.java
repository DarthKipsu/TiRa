
public class Piste1 {
	public int x;
	public int y;

	public Piste1(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x * y + x;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Piste1 other = (Piste1) obj;
		if (this.x != other.x) {
			return false;
		}
		return this.y == other.y;
	}
	
}
