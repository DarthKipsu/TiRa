
package scoring;

public abstract class PieceScore {

    int sideCoefficient;

    public PieceScore(int sideCoefficient) {
        this.sideCoefficient = sideCoefficient;
    }

    abstract public void addPiece(int x, int y);
    abstract public double getScore();
}
