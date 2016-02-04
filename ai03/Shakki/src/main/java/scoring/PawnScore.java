
package scoring;

import position.Position;

public class PawnScore extends PieceScore {
    
    protected static final double BASE_SCORE = 2;
    private static final int[] X_MOVES = {1, -1};
    private static final int[] Y_MOVES = {1, 1};
    
    private int pawnCount = 0;
    private Coordinate[] coordinates = new Coordinate[7];
    private double advancementScore = 0;

    public PawnScore(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        addPawn(++pawnCount, x, y);
    }

    public double getScore() {
        double score = pawnCount * BASE_SCORE;
        score += advancementScore;
        for (int i = 1; i <= pawnCount; i++) {
            score += protectionAndThreatBonuses(coordinates[i]);
        }
        return this.sideCoefficient * score;
    }

    private void addPawn(int id, int x, int y) {
        coordinates[id] = new Coordinate(x, y);
        advancementScore += scoreAdvancement(y);
    }

    private double scoreAdvancement(int y) {
        if (sideCoefficient == 1) {
            if (y==5) return 8;
            if (y==4) return 4;
            if (y==3) return 2;
        } else {
            if (y==0) return 8;
            if (y==1) return 4;
            if (y==2) return 2;
        }
        return 0;
    }

    private double protectionAndThreatBonuses(Coordinate coordinate) {
        double score = 0;
        for (int i = 0; i < X_MOVES.length; i++) {
            int x = coordinate.getX() + X_MOVES[i];
            int y = coordinate.getY() + Y_MOVES[i];
            if (isOutsideBoard(x, y)) continue;
            score += friendlyPieceProtectionValue(x, y);
            score += threatensEnemyValue(x, y, 6);
        }
        return score;
    }
}
