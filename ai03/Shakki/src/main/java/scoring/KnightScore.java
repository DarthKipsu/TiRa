
package scoring;

import position.Position;

public class KnightScore extends PieceScore {
    
    private static final double BASE_SCORE = 3;
    private static final double SYNERGETIC_BONUS = 3;
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

    public double getScore() {
        double score = 0;
        if (hasKnight[1]) {
            score += BASE_SCORE;
            score += protectionBonus(coordinates[1]);
        }
        if (hasKnight[2]) {
            score += BASE_SCORE + SYNERGETIC_BONUS;
            score += protectionBonus(coordinates[2]);
        }
        return this.sideCoefficient * score;
    }

    private void addKnight(int id, int x, int y) {
        hasKnight[id] = true;
        coordinates[id] = new Coordinate(x, y);
    }

    private double protectionBonus(Coordinate coordinate) {
        double protectionScore = 0;
        for (int i = 0; i < X_MOVES.length; i++) {
            int x = coordinate.getX() + X_MOVES[i];
            int y = coordinate.getY() + Y_MOVES[i];
            if (isOutsideBoard(x, y)) continue;
            protectionScore += friendlyPieceProtectionValue(x, y);
        }
        return protectionScore;
    }
}
