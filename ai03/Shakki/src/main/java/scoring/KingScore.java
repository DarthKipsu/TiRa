
package scoring;

import position.Position;

public class KingScore extends PieceScore {
    
    protected static final double BASE_SCORE = 500;
    private static final int[] X_MOVES = {1, 1, 1, 0, 0, -1, -1, -1};
    private static final int[] Y_MOVES = {1, 0, -1, 1, -1, 1, 0, -1};
    
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
        if (hasKing) {
            if (sideCoefficient == 1) score += BASE_SCORE;
            score += BASE_SCORE;
            score += protectionAndThreatBonuses();
        }
        return this.sideCoefficient * score;
    }

    private double protectionAndThreatBonuses() {
        double score = 0;
        for (int i = 0; i < X_MOVES.length; i++) {
            int x = coordinate.getX() + X_MOVES[i];
            int y = coordinate.getY() + Y_MOVES[i];
            if (isOutsideBoard(x, y)) continue;
            score += friendlyPieceProtectionValue(x, y);
            score += threatensEnemyValue(x, y, 1);
        }
        return score;
    }
}
