
package scoring;

import position.Position;

public class KingScore extends PieceScore {
    
    private static final double BASE_SCORE = 1000;
    
    private boolean hasKing = false;
    private Coordinate coordinate = null;

    public KingScore(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        hasKing = true;
        coordinate = new Coordinate(x, y);
    }

    public double getScore() {
        double score = 0;
        if (hasKing) score += BASE_SCORE;
        return this.sideCoefficient * score;
    }
}
