
package scoring;

import position.Position;

public class KnightScore extends PieceScore {
    
    protected static final double BASE_SCORE = 6;
    protected static final double SYNERGETIC_BONUS = 5;
    private static final int[] X_MOVES = {-2, -2, -1, -1, 1, 1, 2, 2};
    private static final int[] Y_MOVES = {1, -1, 2, -2, 2, -2, 1, -1};
    
    private boolean[] hasKnight = new boolean[3];
    private Coordinate[] coordinates = new Coordinate[3];

    public KnightScore(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        int id = hasKnight[1] ? 2 : 1;
        addKnight(id, x, y);
    }

    public boolean hasKnight() {
        return hasKnight[1];
    }

    public double getScore() {
        double score = 0;
        if (hasKnight[1]) {
            score += BASE_SCORE;
            score += protectionAndThreatBonuses(coordinates[1]);
        }
        if (hasKnight[2]) {
            score += BASE_SCORE + SYNERGETIC_BONUS;
            score += protectionAndThreatBonuses(coordinates[2]);
        }
        return this.sideCoefficient * score;
    }

    private void addKnight(int id, int x, int y) {
        hasKnight[id] = true;
        coordinates[id] = new Coordinate(x, y);
    }

    private double protectionAndThreatBonuses(Coordinate coordinate) {
        double score = 0;
        for (int i = 0; i < X_MOVES.length; i++) {
            int x = coordinate.getX() + X_MOVES[i];
            int y = coordinate.getY() + Y_MOVES[i];
            if (isOutsideBoard(x, y)) continue;
            score += friendlyPieceProtectionValue(x, y);
            score += threatensEnemyValue(x, y, 5);
        }
        return score;
    }
}
