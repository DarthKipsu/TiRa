
public class Piste4 {
	public int x;
	public int y;

	public Piste4(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		return (int) Math.sqrt(x*y+x);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Piste4 other = (Piste4) obj;
		if (this.x != other.x) {
			return false;
		}
		return this.y == other.y;
	}
	
}
