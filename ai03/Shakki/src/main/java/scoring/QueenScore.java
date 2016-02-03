
package scoring;

import position.Position;

public class QueenScore extends PieceScore {
    
    private static final double BASE_SCORE = 9;
    
    private boolean hasQueen = false;
    private Coordinate coordinate = null;

    public QueenScore(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        hasQueen = true;
        coordinate = new Coordinate(x, y);
    }

    public double getScore() {
        double score = 0;
        if (hasQueen) score += BASE_SCORE;
        return this.sideCoefficient * score;
    }
}
