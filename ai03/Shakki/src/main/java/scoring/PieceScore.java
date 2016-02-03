
package scoring;

import position.Position;

public abstract class PieceScore {

    int sideCoefficient;
    Position p;

    public PieceScore(int sideCoefficient, Position p) {
        this.sideCoefficient = sideCoefficient;
        this.p = p;
    }

    abstract public void addPiece(int x, int y);
    abstract public double getScore();
}
