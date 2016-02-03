
package scoring;

import position.Position;

public class RookScore extends PieceScore {
    
    protected static final double BASE_SCORE = 5;
    protected static final double SYNERGETIC_BONUS = 5;
    private static final int[][] X_MOVES = {
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0},
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7}};
    private static final int[][] Y_MOVES = {
        {1, 2, 3, 4, 5, 6, 7},
        {-1, -2, -3, -4, -5, -6, -7},
        {0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0}};
    
    private boolean[] hasRook = new boolean[3];
    private Coordinate[] coordinates = new Coordinate[3];

    public RookScore(int sideCoefficient, Position p) {
        super(sideCoefficient, p);
    }

    public void addPiece(int x, int y) {
        int id = hasRook[1] ? 2 : 1;
        addRook(id, x, y);
        }

    public double getScore() {
        double score = 0;
        if (hasRook[1]) {
            score += BASE_SCORE;
            score += protectionBonus(coordinates[1]);
        }
        if (hasRook[2]) {
            score += BASE_SCORE + SYNERGETIC_BONUS;
            score += protectionBonus(coordinates[2]);
        }
        return this.sideCoefficient * score;
    }

    private void addRook(int id, int x, int y) {
        hasRook[id] = true;
        coordinates[id] = new Coordinate(x, y);
    }

    private double protectionBonus(Coordinate coordinate) {
        double protectionScore = 0;
        for (int i = 0; i < X_MOVES.length; i++) {
            for (int j = 0; j < X_MOVES[0].length; j++) {
                int x = coordinate.getX() + X_MOVES[i][j];
                int y = coordinate.getY() + Y_MOVES[i][j];
                if (isOutsideBoard(x, y)) break;
                protectionScore += friendlyPieceProtectionValue(x, y);
                if (slidedAsFarAsPossible(x, y)) break;
            }
        }
        return protectionScore;
    }
}
