
package scoring;

import position.Position;

public class QueenScore extends PieceScore {
    
    private static final double BASE_SCORE = 9;
    
    private int queenCount = 0;
    private Coordinate[] coordinates = new Coordinate[7];

    public QueenScore(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        queenCount++;
        coordinates[queenCount] = new Coordinate(x, y);
    }

    public double getScore() {
        double score = 0;
        score += queenCount * BASE_SCORE;
        return this.sideCoefficient * score;
    }
}
