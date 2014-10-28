
public class Piste2 {
	public int x;
	public int y;

	public Piste2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return x*42*y;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Piste2 other = (Piste2) obj;
		if (this.x != other.x) {
			return false;
		}
		return this.y == other.y;
	}
	
}
